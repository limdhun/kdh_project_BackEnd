package org.kdh.todo.service;

import lombok.RequiredArgsConstructor;
import org.kdh.todo.dto.TodoDTO;
import org.kdh.todo.entities.Todo;
import org.kdh.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    private Todo dtoToEntity(TodoDTO dto) {
        return Todo.builder()
                .tno(dto.getTno())
                .title(dto.getTitle())
                .build();
    }

    private TodoDTO entityToDto(Todo entity) {
        return TodoDTO.builder()
                .tno(entity.getTno())
                .title(entity.getTitle())
                .build();
    }

    @Override
    public Long register(TodoDTO todoDTO) {
        Todo todo = dtoToEntity(todoDTO);
        return todoRepository.save(todo).getTno();
    }

    @Override
    public TodoDTO get(Long tno) {
        return todoRepository.findById(tno)
                .map(this::entityToDto)
                .orElse(null);
    }

    @Override
    public void modify(TodoDTO todoDTO) {
        Todo todo = dtoToEntity(todoDTO);
        todoRepository.save(todo);
    }

    @Override
    public void remove(Long tno) {
        todoRepository.deleteById(tno);
    }

    @Override
    public List<TodoDTO> getAll() {
        return todoRepository.findAll()
                .stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }
}

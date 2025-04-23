package org.kdh.todo.service;

import org.kdh.todo.dto.TodoDTO;

import java.util.List;

public interface TodoService {

    Long register(TodoDTO todoDTO);

    TodoDTO get(Long tno);

    void modify(TodoDTO todoDTO);

    void remove(Long tno);

    List<TodoDTO> getAll();
}

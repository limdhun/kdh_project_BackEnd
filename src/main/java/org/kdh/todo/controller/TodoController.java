package org.kdh.todo.controller;

import lombok.RequiredArgsConstructor;
import org.kdh.todo.dto.TodoDTO;
import org.kdh.todo.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public Long register(@RequestBody TodoDTO dto) {
        return todoService.register(dto);
    }

    @GetMapping("/{tno}")
    public TodoDTO get(@PathVariable Long tno) {
        return todoService.get(tno);
    }

    @GetMapping
    public List<TodoDTO> getAll() {
        return todoService.getAll();
    }

    @PutMapping("/{tno}")
    public void modify(@PathVariable Long tno, @RequestBody TodoDTO dto) {
        dto.setTno(tno);
        todoService.modify(dto);
    }

    @DeleteMapping("/{tno}")
    public void delete(@PathVariable Long tno) {
        todoService.remove(tno);
    }
}

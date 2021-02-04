package com.curso.controllrs;

import com.curso.repository.TodoRepository;
import com.curso.todo.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin("http://localhost:4200")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @PostMapping
    public Todo salvar(@RequestBody Todo todo){
        return todoRepository.save(todo);
    }

    @GetMapping("{id}")
    public Todo getById(@PathVariable  Long id){
        return todoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<Todo> getAll(){
        return todoRepository.findAll();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        todoRepository.deleteById(id);
    }

    @PatchMapping("{id}/done")
    public Todo masrkDone(@PathVariable Long id){
        return todoRepository.findById(id)
                .map(todo -> {
                    todo.setDone(true);
                    todo.setDoneDate(LocalDateTime.now());
                    todoRepository.save(todo);
                    return todo;
                }).orElseThrow(null);
    }

}

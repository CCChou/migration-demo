package tw.dennis.todolist;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/todolist")
public class TodolistService {
    @Autowired
    private TodolistRepository todolistRepository;

    @GetMapping("/{id}")
    public Todolist todolistById(@PathVariable("id") Long id) {
        Optional<Todolist> optTodolist = todolistRepository.findById(id);
        if (optTodolist.isPresent()) {
            return optTodolist.get();
        }
        return null;
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Todolist addTodolist(@RequestBody Todolist todolist) {
        return todolistRepository.save(todolist);
    }

    @PutMapping(path = "/{id}", consumes = "application/json")
    public Todolist updateTodolist(@PathVariable("id") Long id, @RequestBody Todolist patch) {
        Optional<Todolist> optTodolist = todolistRepository.findById(id);
        if (optTodolist.isEmpty()) {
            return null;
        }
        Todolist todolist = optTodolist.get();
        todolist.setTitle(patch.getTitle());
        todolist.setDescription(patch.getDescription());
        return todolistRepository.save(todolist);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTodolist(@PathVariable("id") Long id) {
        try {
            todolistRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.example.lab1.controller;

import com.example.lab1.entity.Task;
import com.example.lab1.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskRepository repo;

    public TaskController(TaskRepository repo) {
        this.repo = repo;
    }

    // GET /tasks?priority=HIGH
    @GetMapping
    public List<Task> getAll(@RequestParam(required = false) String priority) {
        if (priority != null) {
            try {
                Task.Priority p = Task.Priority.valueOf(priority.toUpperCase());
                return repo.findByPriority(p);
            } catch (IllegalArgumentException e) {
                return List.of(); // если параметр неверный
            }
        }
        return repo.findAll();
    }

    @PostMapping
    public Task create(@RequestBody Task task) {
        return repo.save(task);
    }
}

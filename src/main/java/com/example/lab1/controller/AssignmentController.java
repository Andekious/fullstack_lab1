package com.example.lab1.controller;

import com.example.lab1.entity.Task;
import com.example.lab1.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/assign")
public class AssignmentController {
    private final TaskService taskService;

    public AssignmentController(TaskService taskService) {
        this.taskService = taskService;
    }

    // POST /assign/1 — автоматически назначить задачу с id=1
    @PostMapping("/{id}")
    public ResponseEntity<Task> assign(@PathVariable Long id) {
        return taskService.autoAssign(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}

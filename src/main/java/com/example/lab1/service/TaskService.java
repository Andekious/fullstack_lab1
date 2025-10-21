package com.example.lab1.service;

import com.example.lab1.entity.Task;
import com.example.lab1.entity.User;
import com.example.lab1.repository.TaskRepository;
import com.example.lab1.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepo;
    private final UserRepository userRepo;

    public TaskService(TaskRepository taskRepo, UserRepository userRepo) {
        this.taskRepo = taskRepo;
        this.userRepo = userRepo;
    }

    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    public Optional<Task> autoAssign(Long taskId) {
        Task task = taskRepo.findById(taskId).orElseThrow();

        List<User> availableUsers = userRepo.findAll().stream()
                .filter(User::isAvailable)
                .toList();

        if (availableUsers.isEmpty()) return Optional.empty();

        User selected = availableUsers.get(0); // берём первого свободного
        task.setAssignedUser(selected);
        selected.setAvailable(false);
        userRepo.save(selected);
        taskRepo.save(task);
        return Optional.of(task);
    }
}

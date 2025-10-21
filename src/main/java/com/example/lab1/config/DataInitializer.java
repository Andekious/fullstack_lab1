package com.example.lab1.config;

import com.example.lab1.entity.*;
import com.example.lab1.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private final UserRepository userRepo;
    private final TaskRepository taskRepo;

    public DataInitializer(UserRepository userRepo, TaskRepository taskRepo) {
        this.userRepo = userRepo;
        this.taskRepo = taskRepo;
    }

    @Override
    public void run(String... args) {
        if (userRepo.count() == 0) {
            User u = new User();
            u.setUsername("Alice");
            u.setEmail("alice@example.com");
            u.setPassword("pass");
            u.setAvailable(true);
            userRepo.save(u);

            Task t = new Task();
            t.setTitle("Setup project");
            t.setDescription("Initial configuration");
            t.setPriority(Task.Priority.HIGH);
            t.setAssignedUser(u);
            taskRepo.save(t);
        }
    }
}

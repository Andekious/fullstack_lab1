package com.example.lab1.repository;

import com.example.lab1.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByPriority(Task.Priority priority);
}

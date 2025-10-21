package com.example.lab1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @ManyToOne
    private User assignedUser;

    private LocalDateTime createdAt = LocalDateTime.now();

    public enum Priority {
        LOW, MEDIUM, HIGH
    }
}

package com.mwashmyner.mwashmyner.modal;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@Setter
@Getter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Task> allTasks;

    @Transient
    private long completeTasks;

    @Transient
    private long overdueTasks;

    public User() {

    }


    @PostLoad
    public void calculateTaskStats() {
        this.completeTasks = allTasks.stream().filter(task -> "COMPLETE".equals(task.getTaskStatus())).count();
        this.overdueTasks = allTasks.stream().filter(task -> task.getDueDate() != null && task.getDueDate().isBefore(LocalDateTime.now())).count();
    }

    public User(Long userId, String email, List<Task> allTasks, long completeTasks, long overdueTasks) {
        this.userId = userId;
        this.email = email;
        this.allTasks = allTasks;
        this.completeTasks = completeTasks;
        this.overdueTasks = overdueTasks;
    }
}

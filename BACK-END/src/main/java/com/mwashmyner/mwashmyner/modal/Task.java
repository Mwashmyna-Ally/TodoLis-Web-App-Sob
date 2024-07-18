package com.mwashmyner.mwashmyner.modal;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.service.annotation.GetExchange;

import java.time.LocalDateTime;
@Setter
@Getter
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;
    private String taskName;
    private String taskStatus;
    private LocalDateTime dateCreated;
    private LocalDateTime dueDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    public Task() {
        this.dateCreated = LocalDateTime.now();
    }

    public Task(Long taskId, String taskName, String taskStatus, LocalDateTime dateCreated, LocalDateTime dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskStatus = taskStatus;
        this.dateCreated = dateCreated;
        this.dueDate = dueDate;
    }
}

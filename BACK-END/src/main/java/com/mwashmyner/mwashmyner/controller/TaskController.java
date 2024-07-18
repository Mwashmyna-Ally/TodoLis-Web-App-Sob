package com.mwashmyner.mwashmyner.controller;

import com.mwashmyner.mwashmyner.modal.Task;
import com.mwashmyner.mwashmyner.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable Long taskId) {
        return taskService.getTaskById(taskId);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long taskId, @RequestBody Task taskDetails) {
        return taskService.updateTask(taskId, taskDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
    }

    @GetMapping("/search")
    public List<Task> searchTasks(@RequestParam String taskName) {
        return taskService.searchTasks(taskName);
    }

    @GetMapping("/count")
    public long countTasksByStatus(@RequestParam String taskStatus) {
        return taskService.countTasksByStatus(taskStatus);
    }
}

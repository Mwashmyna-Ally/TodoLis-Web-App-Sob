package com.mwashmyner.mwashmyner.service;

import com.mwashmyner.mwashmyner.modal.Task;
import com.mwashmyner.mwashmyner.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long taskId) {
        return taskRepository.findById(taskId);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long taskId, Task taskDetails) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));
        task.setTaskName(taskDetails.getTaskName());
        task.setTaskStatus(taskDetails.getTaskStatus());
        task.setDueDate(taskDetails.getDueDate());
        return taskRepository.save(task);
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    public List<Task> searchTasks(String taskName) {
        return taskRepository.findByTaskNameContaining(taskName);
    }

    public long countTasksByStatus(String taskStatus) {
        return taskRepository.countByTaskStatus(taskStatus);
    }
}

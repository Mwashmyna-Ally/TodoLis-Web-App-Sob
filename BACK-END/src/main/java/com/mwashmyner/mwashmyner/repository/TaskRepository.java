package com.mwashmyner.mwashmyner.repository;

import com.mwashmyner.mwashmyner.modal.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByTaskNameContaining(String taskName);
    long countByTaskStatus(String taskStatus);
}

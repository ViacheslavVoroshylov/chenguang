package com.voroshilov.chenguang.repository;

import com.voroshilov.chenguang.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Task getTasksById(Long id);
}

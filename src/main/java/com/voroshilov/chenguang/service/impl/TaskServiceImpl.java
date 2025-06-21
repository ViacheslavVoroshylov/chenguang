package com.voroshilov.chenguang.service.impl;

import com.voroshilov.chenguang.model.Task;
import com.voroshilov.chenguang.repository.TaskRepository;
import com.voroshilov.chenguang.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{
    private final TaskRepository taskRepository;

    @Autowired
    TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task create(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task readById(long id) {
        return taskRepository.getTasksById(id);
    }

    @Override
    public Task update(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void delete(long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }
}

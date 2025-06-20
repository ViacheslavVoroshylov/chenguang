package com.voroshilov.chenguang.service;

import com.voroshilov.chenguang.model.Task;
import java.util.List;

public interface TaskService {
    Task create(Task task);
    Task readById(int id);
    Task update(Task task);
    void delete(Task task);
    List<Task> getAll();

    Task getByName(String name);
}

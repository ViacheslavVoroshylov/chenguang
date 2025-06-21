package com.voroshilov.chenguang.service;

import com.voroshilov.chenguang.model.Time;

import java.util.List;

public interface TimeService {
    Time create(Time time);
    Time readById(long id);
    Time update(Time time);
    void delete(long time);
    List<Time> getAll();
}

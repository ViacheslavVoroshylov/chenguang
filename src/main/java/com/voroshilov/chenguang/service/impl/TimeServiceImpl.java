package com.voroshilov.chenguang.service.impl;

import com.voroshilov.chenguang.model.Time;
import com.voroshilov.chenguang.repository.TimeRepository;
import com.voroshilov.chenguang.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeServiceImpl implements TimeService {
    private final TimeRepository timeRepository;

    @Autowired
    TimeServiceImpl(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    @Override
    public Time create(Time time) {
        return timeRepository.save(time);
    }

    @Override
    public Time readById(long id) {
        return timeRepository.getTimeById(id);
    }

    @Override
    public Time update(Time time) {
        return timeRepository.save(time);
    }

    @Override
    public void delete(long id) {
        timeRepository.deleteById(id);
    }

    @Override
    public List<Time> getAll() {
        return timeRepository.findAll();
    }
}

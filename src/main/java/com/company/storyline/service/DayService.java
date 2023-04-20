package com.company.storyline.service;

import com.company.storyline.model.Day;
import com.company.storyline.repository.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DayService {

    @Autowired
    private DayRepository repository;

    // CRUD Create, Read, Update, Delete

    public Day addDay(Day day) {
        String addedDate = day.getDate();
        Optional<Day> expectedDay = Optional.ofNullable(repository.findByDate(addedDate));
        if (expectedDay.isPresent()) {
            return null;
        } else {
            return repository.save(day);
        }
    }

    public List<Day> findAllDays() {
        return repository.findAll();
    }

    public Day getDayByDate(String date) {
        return repository.findByDate(date);
    }

    public Day updateDay(Day day) {
        return repository.save(day);
    }

    public void deleteDay(String dayId) {
        repository.deleteById(dayId);
    }
}

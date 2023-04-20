package com.company.storyline.controller;

import com.company.storyline.model.Day;
import com.company.storyline.repository.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class GraphController {

    @Autowired
    DayRepository dayRepository;

    @QueryMapping
    public Day findDayByDate(@Argument String date) {
        return dayRepository.findByDate(date);
    }

    @QueryMapping
    public List<Day> getAllDays() {
        return dayRepository.findAll();
    }

}

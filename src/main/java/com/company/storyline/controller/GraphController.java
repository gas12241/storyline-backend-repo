package com.company.storyline.controller;

import com.company.storyline.model.Day;
import com.company.storyline.repository.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

/**
 * Graph Controller That would be used with the GraphQL schema to get information from the Database.
 */
@Controller
public class GraphController {

    /**
     * Repository worked with.
     */
    @Autowired
    DayRepository dayRepository;

    /**
     * Method to find a specific day by its date.
     * @param date String taken in to find a Day Object with the
     *             matching date in the Storyline Database.
     * @return Returns a Day if one in the database matches it by the date given.
     */
    @QueryMapping
    public Day findDayByDate(@Argument String date) {
        return dayRepository.findByDate(date);
    }

    /**
     * Method to get all the Day(s) in the Storyline Database.
     * @return Returns a List of Day(s), all the Day(s) in
     *         the Storyline Database.
     */
    @QueryMapping
    public List<Day> getAllDays() {
        return dayRepository.findAll();
    }
}

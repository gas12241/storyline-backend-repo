package com.company.storyline.controller;

import com.company.storyline.model.Day;
import com.company.storyline.model.Place;
import com.company.storyline.model.SummaryActivity;
import com.company.storyline.service.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Day Controller that will be used to get Day(s) out of the Storyline Database.
 */
@CrossOrigin
@RestController
@RequestMapping("/days")
public class DayController {

    /**
     * service being used to get information out of the repo.
     */
    @Autowired
    private DayService service;

    /**
     * Get Mapping to Get all of the Day(s) from the Database back.
     * @return Returns a List of Day(s) from the Database.
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Day> getDays() {
        return service.findAllDays();
    }

    /**
     * Get Mapping to Get a specific Day from the Database
     * by its date back.
     * @param date String taken in to Get a specific Day back.
     * @return Returns a Day back if it exists in the Database.
     */
    @GetMapping("/date/{date}")
    @ResponseStatus(HttpStatus.OK)
    public Day getDayByDate(@PathVariable String date) throws IllegalAccessException {
        return service.getDayByDate(date);
    }

    // This gets the calories and idle calories for the day
    // The idle calories come first, followed by the calories burned doing summary activities
    @GetMapping("/date/{date}/calories")
    @ResponseStatus(HttpStatus.OK)
    public List<Integer> getCaloriesByDate(@PathVariable String date) throws IllegalAccessException {
        Day day = service.getDayByDate(date);
        //return service.findStartDateGivenEndDate(date, 7);
        return day.idleAndActivityCaloriesInADay();
    }

    @GetMapping("/endDate/{date}/calories/{daysGoingBack}")
    @ResponseStatus(HttpStatus.OK)
    public HashMap<String, String> getCaloriesForLastXDays(@PathVariable String date, @PathVariable Integer daysGoingBack) {
        return service.caloriesForLastXDays(date, daysGoingBack);
    }

    @GetMapping("/date/{date}/locations")
    @ResponseStatus(HttpStatus.OK)
    public List<List<String>> getListOfLocations(@PathVariable String date) throws IllegalAccessException {
        Day day = service.getDayByDate(date);
        return day.placesInADay();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Day addDay(@RequestBody Day day) {
        return service.addDay(day);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Day updateDay(@RequestBody Day day) {
        return service.updateDay(day);
    }

    @DeleteMapping("/{dayId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDay(@PathVariable String dayId) {
        service.deleteDay(dayId);
    }


    // UpdateMapping where you delete a days calories
    @PutMapping("/deleteCalories")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCaloriesInADay(List<String> data) {
        service.deleteCaloriesInDay(data);
    }

    // UpdateMapping where you delete a days locations
    @PutMapping("/deleteLocation")
    @ResponseStatus(HttpStatus.OK)
    public void deleteLocationInADay(List<String> data) {
        service.deleteLocationInDay(data);
    }

    // UpdateMapping where you add a days calories
    @PutMapping("/addCalories")
    @ResponseStatus(HttpStatus.OK)
    public void addCaloriesToDay(List<String> data) {
        service.addCaloriesToDay(data);
    }
    // Update where u add a location to a day
    @PutMapping("/addLocation")
    @ResponseStatus(HttpStatus.OK)
    public void addLocationToDay(List<String> data) {
        service.addLocationToDay(data);
    }

}

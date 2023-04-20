package com.company.storyline.controller;

import com.company.storyline.model.Day;
import com.company.storyline.model.Place;
import com.company.storyline.model.SummaryActivity;
import com.company.storyline.service.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/days")
public class DayController {

    @Autowired
    private DayService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Day> getDays() {
        return service.findAllDays();
    }

    @GetMapping("/date/{date}")
    @ResponseStatus(HttpStatus.OK)
    public Day getDayByDate(@PathVariable String date){
        return service.getDayByDate(date);
    }

    // This gets the calories and idle calories for the day
    // The idle calories come first, followed by the calories burned doing summary activities
    @GetMapping("/date/{date}/calories")
    @ResponseStatus(HttpStatus.OK)
    public List<Integer> getCaloriesByDate(@PathVariable String date) {
        Day day = service.getDayByDate(date);
        Integer summaryActivityCalories = 0;
        List<Integer> idleAndNoneIdleCalories = new ArrayList<>();
        for (SummaryActivity s : day.getSummary()) {
            if (s.getCalories() != null) {
                summaryActivityCalories += s.getCalories();
            }
        }
        idleAndNoneIdleCalories.add(day.getCaloriesIdle());
        idleAndNoneIdleCalories.add(summaryActivityCalories);
        return idleAndNoneIdleCalories;
    }

    @GetMapping("/date/{date}/locations")
    @ResponseStatus(HttpStatus.OK)
    public List<String> getListOfLocations(@PathVariable String date) {
        Day day = service.getDayByDate(date);
        List<String> locationStrings = new ArrayList<>();
        Integer placeCounter = 0;
        for (int i = 0; i < day.getSegments().size(); i++) {
            if (day.getSegments().get(i).getType().equals("place")) {
                placeCounter += 1;
                Double lat = day.getSegments().get(i).getPlace().getLocation().getLat();
                Double lon = day.getSegments().get(i).getPlace().getLocation().getLon();
                String placeName = day.getSegments().get(i).getPlace().getName();
                String placeType = day.getSegments().get(i).getPlace().getType();
                locationStrings.add("Place " + placeCounter + " was " +
                        placeName + ", which is of type " +
                        placeType + ". It has the coordinates " + lat +
                        " latitude and " + lon + " longitude!");
            }
        }
        return locationStrings;
    }

    /*
    public static void printLocationsForDay(Day day) {
        Integer placeCounter = 0;
        for (int i = 0; i < day.getSegments().size(); i++) {
            if (day.getSegments().get(i).getType().equals("place")) {
                placeCounter += 1;
                Double lat = day.getSegments().get(i).getPlace().getLocation().getLat();
                Double lon = day.getSegments().get(i).getPlace().getLocation().getLat();
                String placeName = day.getSegments().get(i).getPlace().getName();
                String placeType = day.getSegments().get(i).getPlace().getType();
                System.out.println("Place " + placeCounter + " was " +
                        placeName + ", which is of type "+
                        placeType + ". It has the coordinates " + lat +
                        " latitude and " + lon + " longitude!");
            }
        }
    }
     */

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
}

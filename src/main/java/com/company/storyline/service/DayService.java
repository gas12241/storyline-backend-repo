package com.company.storyline.service;

import com.company.storyline.model.Day;
import com.company.storyline.model.Location;
import com.company.storyline.model.Place;
import com.company.storyline.model.StorySegment;
import com.company.storyline.repository.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * Service Layer for the Day repository.
 */
@Service
public class DayService {

    private DayRepository dayRepository;
    private HashMap<String, Integer> daysOfTheMonth;

    @Autowired
    public DayService(
            DayRepository dayRepository,
            HashMap<String, Integer> daysOfTheMonth
    ) {
        this.dayRepository = dayRepository;
        daysOfTheMonth = new HashMap<>();
        daysOfTheMonth.put("01", 31);
        daysOfTheMonth.put("02", 28);
        daysOfTheMonth.put("03", 31);
        daysOfTheMonth.put("04", 30);
        daysOfTheMonth.put("05", 31);
        daysOfTheMonth.put("06", 30);
        daysOfTheMonth.put("07", 31);
        daysOfTheMonth.put("08", 31);
        daysOfTheMonth.put("09", 30);
        daysOfTheMonth.put("10", 31);
        daysOfTheMonth.put("11", 30);
        daysOfTheMonth.put("12", 31);
    }

    /**
     * Method to add a Day to the Repository. Only happens
     * if the Day doesn't already exist in the Database.
     * @param day Day Object taken in to add to the Database.
     * @return Returns the Day that was saved. If it already
     *         exists, then it returns nothing.
     */
    public Day addDay(Day day) {
        String addedDate = day.getDate();
        Optional<Day> expectedDay = Optional.ofNullable(dayRepository.findByDate(addedDate));
        if (expectedDay.isPresent()) {
            return null;
        } else {
            return dayRepository.save(day);
        }
    }

    /**
     * Method to return all the days in the Database.
     * @return Returns a List of Days, all the Days in the Database.
     */
    public List<Day> findAllDays() {
        return dayRepository.findAll();
    }

    /**
     * Method to Get a Day by its Date.
     * @param date String used to find a day.
     * @return Returns a Day if the date given matches a Day in the Database.
     */
    public Day getDayByDate(String date) throws IllegalAccessException {
        Day dayFromRepo = dayRepository.findByDate(date);
        if (dayFromRepo != null) {
            return dayFromRepo;
        } else {
            throw new IllegalAccessException();
        }
    }

    /**
     * Method to Update a Day by its Date.
     * @param day Day Object used to update a Day, should
     *            have its Id attached to it too.
     * @return Returns the Object that was just updated (if the
     *         Id isn't attached to the Object, then the Day will
     *         be Created instead of Updated).
     */
    public Day updateDay(Day day) {
        // String dateOfDay = day.getDate();
        return dayRepository.save(day);
    }

    /**
     * Method to Delete Day by its Id.
     * @param dayId String taken in to Delete a Day in the Database.
     */
    public void deleteDay(String dayId) {
        dayRepository.deleteById(dayId);
    }

    public HashMap<String, String> caloriesForLastXDays(String date, Integer daysGoingBack) {
        DecimalFormat df = new DecimalFormat("0.00");
        HashMap<String, String> returnedHashmap = new HashMap<>();
        Integer idleCalorieTotal = 0;
        Integer activeCalorieTotal = 0;
        Integer daysInDatabase = 0;


        LocalDate endLd = LocalDate.parse(storylineDateIntoLdParsableDate(date));
        List<String> endDateData = localDateIntoMonthDayYear(endLd);
        String endMonth = endDateData.get(0);
        String endDay = endDateData.get(1);
        String endYear = endDateData.get(2);

        String daysGoingBackString = String.valueOf(daysGoingBack);

        // This start date is as YYYY-MM-DD
        String parsableStart = findStartDateGivenEndDate(date, daysGoingBack);

        LocalDate startLd = LocalDate.parse(parsableStart);
        String storylineStart = ldParsableDateIntoStoryline(parsableStart);
        LocalDate firstDayInDatabase = LocalDate.parse("2013-02-11");
        LocalDate updatableDay = startLd;
        if (endLd.isBefore(firstDayInDatabase)) {
            return null;
        }
        if (updatableDay.isBefore(firstDayInDatabase)) {
            updatableDay = LocalDate.parse("2013-02-11");
            long differenceInDays = ChronoUnit.DAYS.between(updatableDay, endLd);
            daysGoingBack = Math.toIntExact(differenceInDays);
            startLd = updatableDay;
        }
        // Turning startDate String to something
        for (int i = 0; i < daysGoingBack; i++) {
            // I'm getting the data for the start day
            Optional<Day> dayFromRepo= Optional.ofNullable(dayRepository.findByDate(ldParsableDateIntoStoryline(updatableDay.toString())));
            // if the day isn't there, don't do anything
            if (!dayFromRepo.isPresent()) {
                break;
            } else {
                System.out.println(updatableDay.toString());
                System.out.println("Beginning for loop" + daysInDatabase);
                daysInDatabase = daysInDatabase + 1;
                // if the day is there, add the idle calories from the day
                idleCalorieTotal = idleCalorieTotal + dayFromRepo.get().idleAndActivityCaloriesInADay().get(0);
                // Add the active calories from the day, and plus one to the day counter
                activeCalorieTotal = activeCalorieTotal + dayFromRepo.get().idleAndActivityCaloriesInADay().get(1);
                System.out.println("After for loop" + daysInDatabase);
                System.out.println("\n");
            }

            // update the day
            updatableDay = updatableDay.plusDays(1);

        }
        System.out.println("Days after for loop" + daysInDatabase);
        List<String> startDateData = localDateIntoMonthDayYear(startLd);
        String startMonth = startDateData.get(0);
        String startDay = startDateData.get(1);
        String startYear = startDateData.get(2);

        Integer totalCalories = idleCalorieTotal + activeCalorieTotal;
        Double averagedCalories = Double.valueOf(totalCalories) / Double.valueOf(daysInDatabase);
        String stringOfDaysInDatabase = String.valueOf(daysInDatabase);
        String stringOfTotalCalories = String.valueOf(totalCalories);
        String stringOfIdleCalories = String.valueOf(idleCalorieTotal);
        String stringOfActiveCalories = String.valueOf(activeCalorieTotal);
        String stringOfAveragedCalories = df.format(averagedCalories);

        // "In the {30} days between {start date} and {End Date}, you had {8} days
        // in the database. In those {8} days, you burned {total calories}, of which
        // {idle calories} were idle, and {active calories} were active. You averaged
        // {average counters burned} for the {8} days in the Database."
        returnedHashmap.put("daysGoingBackPlusOne", daysGoingBackString);
        returnedHashmap.put("startMonth", startMonth);
        returnedHashmap.put("startDay", startDay);
        returnedHashmap.put("startYear", startYear);
        returnedHashmap.put("endMonth", endMonth);
        returnedHashmap.put("endDay", endDay);
        returnedHashmap.put("endYear", endYear);
        returnedHashmap.put("daysInDatabase", stringOfDaysInDatabase);
        returnedHashmap.put("totalCalories", stringOfTotalCalories);
        returnedHashmap.put("idleCalories", stringOfIdleCalories);
        returnedHashmap.put("activeCalories",stringOfActiveCalories);
        returnedHashmap.put("averagedCalories",stringOfAveragedCalories);

        return returnedHashmap;
    }

    public String storylineDateIntoLdParsableDate(String date) {
        String storylineYear = date.substring(0, 4);
        String storylineMonth = date.substring(4, 6);
        String storylineDay = date.substring(6, 8);
        String ldParsableDate = storylineYear + "-" + storylineMonth + "-" + storylineDay;
        return ldParsableDate;
    }

    public String ldParsableDateIntoStoryline(String ldDate) {
        String year = ldDate.substring(0,4);
        String month = ldDate.substring(5,7);
        String day = ldDate.substring(8,10);
        String storylineDate = year + month + day;
        return storylineDate;

    }

    public List<String> localDateIntoMonthDayYear(LocalDate localDate) {
        List<String> monthDayYear = new ArrayList<>();
        String month = String.valueOf(localDate.getMonth());
        String day = String.valueOf(localDate.getDayOfMonth());
        String year = String.valueOf(localDate.getYear());
        monthDayYear.add(month);
        monthDayYear.add(day);
        monthDayYear.add(year);
        return monthDayYear;
    }

    public String findStartDateGivenEndDate(String date, Integer daysGoingBack) {
        String parsedEndDate = storylineDateIntoLdParsableDate(date);

        LocalDate endLd = LocalDate.parse(parsedEndDate);
        LocalDate startLd = endLd.minusDays(daysGoingBack - 1);

        String startDate = startLd.toString();

        return startDate;
    }

    public Day deleteCaloriesInDay(List<String> data) {
        String dateOfDay = data.get(0);
        Day dayFromRepo = dayRepository.findByDate(dateOfDay);
        if (dayFromRepo != null) {
            Integer idleCalories = dayFromRepo.getCaloriesIdle();
            Integer deletedCalories = Integer.valueOf(data.get(1));
            if (idleCalories == 0) {
                return null;
            }
            if (deletedCalories > idleCalories) {
                dayFromRepo.setCaloriesIdle(0);
            } else {
                dayFromRepo.setCaloriesIdle(idleCalories - deletedCalories);
            }
        } else {
            return null;
        }
        return dayRepository.save(dayFromRepo);
    }

    public Day deleteLocationInDay(List<String> data) {
        Double lonFromData = Double.valueOf(data.get(1));
        Double latFromData = Double.valueOf(data.get(2));
        String dateFromData = data.get(0);
        Day dayFromRepo = dayRepository.findByDate(dateFromData);
        if (dayFromRepo != null) {
            List<StorySegment> daySegments = dayFromRepo.getSegments();
            for (int i = 0; i < daySegments.size(); i++) {
                if (daySegments.get(i).getType().equals("place")) {
                    Double lonFromDay = daySegments.get(i).getPlace().getLocation().getLon();
                    Double latFromDay = daySegments.get(i).getPlace().getLocation().getLat();
                    if (lonFromDay == lonFromData && latFromDay == latFromData) {
                        daySegments.remove(i);
                        break;
                    }
                }
            }
        } else {
            return null;
        }
        return dayRepository.save(dayFromRepo);
    }
    public Day addCaloriesToDay(List<String> data) {
        String dateOfDay = data.get(0);
        Integer caloriesAdded = Integer.valueOf(data.get(1));
        Day dayFromRepo = dayRepository.findByDate(dateOfDay);
        if (dayFromRepo != null) {
            dayFromRepo.setCaloriesIdle(dayFromRepo.getCaloriesIdle() + caloriesAdded);
        } else {
            return null;
        }
        return dayRepository.save(dayFromRepo);
    }

    public Day addLocationToDay(List<String> data) {
        String date = data.get(0);
        Double lonFromData = Double.valueOf(data.get(1));
        Double latFromData = Double.valueOf(data.get(2));

        Day dayFromRepo = dayRepository.findByDate(date);
        if (dayFromRepo != null) {
            StorySegment ss = new StorySegment();
            ss.setType("place");
            ss.setStartTime(date + "T000000-0000");
            ss.setEndTime(date + "T115959-9999");
            // Make place
            Place newPlace = new Place();
            Location newLocation = new Location();
            newLocation.setLon(lonFromData);
            newLocation.setLat(latFromData);
            newPlace.setLocation(newLocation);
            newPlace.setId(0000000);
            newPlace.setName("Added Place Name");
            newPlace.setType("Added Place Type");
            ss.setPlace(newPlace);
            ss.setLastUpdate(date + "T000000-0000");

            dayFromRepo.getSegments().add(ss);
        } else {
            return null;
        }
        return dayRepository.save(dayFromRepo);
    }


}

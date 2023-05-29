package com.company.storyline.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Day Object that will be used to get Days from the Storyline Database.
 */
@Document(collection = "Storyline")
public class Day {

    /**
     * Instance Variables for the Day Object.
     */
    @Id
    private String dayId;
    private String date;
    private ArrayList<SummaryActivity> summary = new ArrayList<>();
    private ArrayList<StorySegment> segments = new ArrayList<>();
    private Integer caloriesIdle;
    private String lastUpdate;

    /**
     * Empty Day Constructor.
     */
    public Day() {
    }

    public List<Integer> idleAndActivityCaloriesInADay() {
        List<Integer> idleAndActivityCalories = new ArrayList<>();
        Integer activityCalories = 0;
        // Get all the activity calories in a day
        for (SummaryActivity sa : this.summary) {
            if (sa.getCalories() != null) {
                activityCalories += sa.getCalories();
            }
        }

        //Get idle calories
        //Add them both to the list, with idle going first.
        idleAndActivityCalories.add(this.caloriesIdle);
        idleAndActivityCalories.add(activityCalories);

        return idleAndActivityCalories;
    }

    public List<List<String>> placesInADay() {
        List<List<String>> returnedPlacesList = new ArrayList<>();
        Integer placeCounter = 1;
        for (int i = 0; i < this.getSegments().size(); i++) {
            if (this.getSegments().get(i).getType().equals("place") &&
            this.getSegments().get(i).getPlace().getName() != null) {
                List<String> informationForPlace = new ArrayList<>();
                Place placeOfSegment = this.getSegments().get(i).getPlace();
                String lat = String.valueOf(placeOfSegment.getLocation().getLat());
                String lon = String.valueOf(placeOfSegment.getLocation().getLon());
                String placeName = placeOfSegment.getName();
                String placeType = placeOfSegment.getType();

                informationForPlace.add(String.valueOf(placeCounter));
                placeCounter += 1;
                informationForPlace.add(placeName);
                informationForPlace.add(placeType);
                informationForPlace.add(lat);
                informationForPlace.add(lon);
                returnedPlacesList.add(informationForPlace);
            }
        }
        return returnedPlacesList;
    }

    /**
     * Getter for the dayId of the Day Object.
     * @return Returns a String, the dayId for
     *         the Day Object.
     */
    public String getDayId() {
        return dayId;
    }

    /**
     * Setter for the dayId of the Day Object.
     * @param dayId String taken in to set the dayId
     *              of the Day Object.
     */
    public void setDayId(String dayId) {
        this.dayId = dayId;
    }

    /**
     * Getter for the date of the Day Object.
     * @return Returns a String, the dayId for the Day Object.
     */
    public String getDate() {
        return date;
    }

    /**
     * Setter for the date of the Day Object.
     * @param date String taken in to set the
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Getter for the summary of the Day Object.
     * @return Returns an ArrayList of SummaryActivity(s),
     *         the summary for the Day Object.
     */
    public ArrayList<SummaryActivity> getSummary() {
        return summary;
    }

    /**
     * Setter for the summary of the Day Object.
     * @param summary ArrayList of SummaryActivity(s) taken in to set
     *                the summary for the Day Object.
     */
    public void setSummary(ArrayList<SummaryActivity> summary) {
        this.summary = summary;
    }

    /**
     * Getter for the segments of the Day Object.
     * @return Returns an ArrayList of Story Segments,
     *         the segments for the Day Object.
     */
    public ArrayList<StorySegment> getSegments() {
        return segments;
    }

    /**
     * Setter for the segments of the Day Object.
     * @param segments Arraylist of StorySegment(s) taken in to set the
     *                 segments for the Day Object.
     */
    public void setSegments(ArrayList<StorySegment> segments) {
        this.segments = segments;
    }

    /**
     * Getter for the caloriesIdle of the Day Object.
     * @return Returns an Integer, the caloriesIdle for the Day Object.
     */
    public Integer getCaloriesIdle() {
        return caloriesIdle;
    }

    /**
     * Setter for the caloriesIdle of the Day Object.
     * @param caloriesIdle Integer taken in to set the caloriesIdle for the Day Object.
     */
    public void setCaloriesIdle(Integer caloriesIdle) {
        this.caloriesIdle = caloriesIdle;
    }

    /**
     * Getter for the lastUpdate of the Day Object.
     * @return Returns a String, the lastUpdate for the Day Object.
     */
    public String getLastUpdate() {
        return lastUpdate;
    }

    /**
     * Setter for the lastUpdate of the Day Object.
     * @param lastUpdate String taken in to set the
     *                   lastUpdate of the Day Object.
     */
    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    /**
     * equals() for the Day Object. Will be used for comparison.
     * @param o Object o being used for comparison.
     * @return Returns true if the Object calling the method equals Object o, else returns false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Day day = (Day) o;
        return Objects.equals(getDayId(), day.getDayId()) && Objects.equals(getDate(), day.getDate()) && Objects.equals(getSummary(), day.getSummary()) && Objects.equals(getSegments(), day.getSegments()) && Objects.equals(getCaloriesIdle(), day.getCaloriesIdle()) && Objects.equals(getLastUpdate(), day.getLastUpdate());
    }

    /**
     * hashCode() for the Day Object.
     * @return Returns the Day Object as an int.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getDayId(), getDate(), getSummary(), getSegments(), getCaloriesIdle(), getLastUpdate());
    }

    /**
     * toString() for the Day Object.
     * @return Returns the Day Object as a String.
     */
    @Override
    public String toString() {
        return "Day{" +
                "dayId='" + dayId + '\'' +
                ", date='" + date + '\'' +
                ", summary=" + summary +
                ", segments=" + segments +
                ", caloriesIdle=" + caloriesIdle +
                ", lastUpdate='" + lastUpdate + '\'' +
                '}';
    }
}

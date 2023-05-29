package com.company.storyline.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * StorySegment class that will be used to make up a Day
 * in the Storyline Database.
 */
public class StorySegment {
    private String type;
    private String startTime;
    private String endTime;
    private Place place;
    private ArrayList<SegmentActivity> activities = new ArrayList<>();
    private String lastUpdate;

    /**
     * Empty StorySegment Constructor.
     */
    public StorySegment() {
    }

    /**
     * Getter for the type of the StorySegment Object.
     * @return Returns a String, the type of the
     *         StorySegment Object.
     */
    public String getType() {
        return type;
    }

    /**
     * Setter for the type of the StorySegment Object
     * @param type String taken in to set the type of
     *             the StorySegment Object.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Getter for the startTime of the StorySegment Object.
     * @return Returns a String, the startTime of the
     *         StorySegment Object.
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * Setter for the startTime of the StorySegment Object.
     * @param startTime String taken in to set the startTime
     *                  of the StorySegment Object.
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * Getter for the endTime of the StorySegment Object.
     * @return Returns a String, the endTime of the
     *         StorySegment Object.
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * Setter for the endTime of the StorySegment Object.
     * @param endTime String takne in to set the endTime
     *                of the StorySegment Object.
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * Getter for the place of the StorySegment Object.
     * @return Returns a Place Object, the place of the
     *         StorySegment Object.
     */
    public Place getPlace() {
        return place;
    }

    /**
     * Setter for the place of the StorySegment Object.
     * @param place Place Object taken in to set the place
     *              of the StorySegment Object.
     */
    public void setPlace(Place place) {
        this.place = place;
    }

    /**
     * Getter for the activities of the StorySegment Object.
     * @return Returns an ArrayList made up of SegmentActivity(s),
     * the activities of the StorySegment Object.
     */
    public ArrayList<SegmentActivity> getActivities() {
        return activities;
    }

    /**
     * Setter for the activities of the StorySegment Object.
     * @param activities ArrayList of SegmentActivity(s) taken in to
     *                   set the activities of the StorySegment Object.
     */
    public void setActivities(ArrayList<SegmentActivity> activities) {
        this.activities = activities;
    }

    /**
     * Getter for the lastUpdate of the StorySegment Object.
     * @return Returns a String, the lastUpdate of the
     *         StorySegment Object.
     */
    public String getLastUpdate() {
        return lastUpdate;
    }

    /**
     * Setter for the lastUpdate of the StorySegment Object.
     * @param lastUpdate String taken in to set the lastUpdate
     *                   for the StorySegment Object.
     */
    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    /**
     * equals() for the StorySegment Object.
     * @param o Object o being used for comparison.
     * @return Returns true if the Object calling the method
     *         equals Object O, else it returns false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StorySegment that = (StorySegment) o;
        return Objects.equals(getType(), that.getType()) && Objects.equals(getStartTime(), that.getStartTime()) && Objects.equals(getEndTime(), that.getEndTime()) && Objects.equals(getPlace(), that.getPlace()) && Objects.equals(getActivities(), that.getActivities()) && Objects.equals(getLastUpdate(), that.getLastUpdate());
    }

    /**
     * hashCode() for the StorySegment Object. Can be
     * used for comparison.
     * @return Returns the StorySegment Object as an int.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getType(), getStartTime(), getEndTime(), getPlace(), getActivities(), getLastUpdate());
    }

    /**
     * toString() for the StorySegment Object.
     * @return Returns the StorySegment Object as a String.
     */
    @Override
    public String toString() {
        return "StorySegment{" +
                "type='" + type + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", place=" + place +
                ", activities=" + activities +
                ", lastUpdate='" + lastUpdate + '\'' +
                '}';
    }
}

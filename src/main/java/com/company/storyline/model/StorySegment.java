package com.company.storyline.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StorySegment {
    private String type;
    private String startTime;
    private String endTime;
    private Place place;
    private ArrayList<SegmentActivity> activities = new ArrayList<>();
    private String lastUpdate;

    public StorySegment() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public ArrayList<SegmentActivity> getActivities() {
        return activities;
    }

    public void setActivities(ArrayList<SegmentActivity> activities) {
        this.activities = activities;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StorySegment that = (StorySegment) o;
        return Objects.equals(getType(), that.getType()) && Objects.equals(getStartTime(), that.getStartTime()) && Objects.equals(getEndTime(), that.getEndTime()) && Objects.equals(getPlace(), that.getPlace()) && Objects.equals(getActivities(), that.getActivities()) && Objects.equals(getLastUpdate(), that.getLastUpdate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getStartTime(), getEndTime(), getPlace(), getActivities(), getLastUpdate());
    }

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

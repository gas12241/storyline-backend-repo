package com.company.storyline.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Objects;

@Document(collection = "Storyline")
public class Day {

    @Id
    private String dayId;
    private String date;
    private ArrayList<SummaryActivity> summary = new ArrayList<>();
    private ArrayList<StorySegment> segments = new ArrayList<>();
    private Integer caloriesIdle;
    private String lastUpdate;

    public Day() {
    }

    public String getDayId() {
        return dayId;
    }

    public void setDayId(String dayId) {
        this.dayId = dayId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<SummaryActivity> getSummary() {
        return summary;
    }

    public void setSummary(ArrayList<SummaryActivity> summary) {
        this.summary = summary;
    }

    public ArrayList<StorySegment> getSegments() {
        return segments;
    }

    public void setSegments(ArrayList<StorySegment> segments) {
        this.segments = segments;
    }

    public Integer getCaloriesIdle() {
        return caloriesIdle;
    }

    public void setCaloriesIdle(Integer caloriesIdle) {
        this.caloriesIdle = caloriesIdle;
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
        Day day = (Day) o;
        return Objects.equals(getDayId(), day.getDayId()) && Objects.equals(getDate(), day.getDate()) && Objects.equals(getSummary(), day.getSummary()) && Objects.equals(getSegments(), day.getSegments()) && Objects.equals(getCaloriesIdle(), day.getCaloriesIdle()) && Objects.equals(getLastUpdate(), day.getLastUpdate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDayId(), getDate(), getSummary(), getSegments(), getCaloriesIdle(), getLastUpdate());
    }

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

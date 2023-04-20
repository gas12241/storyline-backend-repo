package com.company.storyline.model;

import java.util.Objects;

public class SummaryActivity {
    private String activity;
    private String group;
    private Integer duration;
    private Integer distance;
    private Integer steps;
    private Integer calories;

    public SummaryActivity() {
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getSteps() {
        return steps;
    }

    public void setSteps(Integer steps) {
        this.steps = steps;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SummaryActivity activity1 = (SummaryActivity) o;
        return Objects.equals(getActivity(), activity1.getActivity()) && Objects.equals(getGroup(), activity1.getGroup()) && Objects.equals(getDuration(), activity1.getDuration()) && Objects.equals(getDistance(), activity1.getDistance()) && Objects.equals(getSteps(), activity1.getSteps()) && Objects.equals(getCalories(), activity1.getCalories());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getActivity(), getGroup(), getDuration(), getDistance(), getSteps(), getCalories());
    }

    @Override
    public String toString() {
        return "Activity{" +
                "activity='" + activity + '\'' +
                ", group='" + group + '\'' +
                ", duration=" + duration +
                ", distance=" + distance +
                ", steps=" + steps +
                ", calories=" + calories +
                '}';
    }
}

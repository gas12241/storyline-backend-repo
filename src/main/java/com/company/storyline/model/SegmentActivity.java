package com.company.storyline.model;

import java.util.Objects;

public class SegmentActivity {
    private String activity;
    private String group;
    private Boolean manual;
    private String startTime;
    private String endTime;
    private Integer duration;
    private Integer distance;
    private Integer steps;
    private Integer calories;

    public SegmentActivity() {
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

    public Boolean getManual() {
        return manual;
    }

    public void setManual(Boolean manual) {
        this.manual = manual;
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
        SegmentActivity that = (SegmentActivity) o;
        return Objects.equals(getActivity(), that.getActivity()) && Objects.equals(getGroup(), that.getGroup()) && Objects.equals(getManual(), that.getManual()) && Objects.equals(getStartTime(), that.getStartTime()) && Objects.equals(getEndTime(), that.getEndTime()) && Objects.equals(getDuration(), that.getDuration()) && Objects.equals(getDistance(), that.getDistance()) && Objects.equals(getSteps(), that.getSteps()) && Objects.equals(getCalories(), that.getCalories());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getActivity(), getGroup(), getManual(), getStartTime(), getEndTime(), getDuration(), getDistance(), getSteps(), getCalories());
    }

    @Override
    public String toString() {
        return "SegmentActivity{" +
                "activity='" + activity + '\'' +
                ", group='" + group + '\'' +
                ", manual=" + manual +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", duration=" + duration +
                ", distance=" + distance +
                ", steps=" + steps +
                ", calories=" + calories +
                '}';
    }
}

package com.company.storyline.model;

import java.util.Objects;

/**
 * SegmentActivity class that will be used to make up
 * a Day in the Storyline Database.
 */
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

    /**
     * Empty SegmentActivity Constructor.
     */
    public SegmentActivity() {
    }

    /**
     * Getter for the activity of the SegmentActivity Object.
     * @return Returns a String, the activity of
     *         the SegmentActivity Object.
     */
    public String getActivity() {
        return activity;
    }

    /**
     * Setter for the activity of the SegmentActivity Object.
     * @param activity String taken in to set the activity
     *                 of the SegmentActivity Object.
     */
    public void setActivity(String activity) {
        this.activity = activity;
    }

    /**
     * Getter for the group of the SegmentActivity Object.
     * @return Returns a String, the group of
     *         the SegmentActivity Object.
     */
    public String getGroup() {
        return group;
    }

    /**
     * Setter for the group of the SegmentActivity Object.
     * @param group String taken in to set the group of
     *              the SegmentActivity Object.
     */
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * Getter for the manual of the SegmentActivity Object.
     * @return Returns a Boolean, the manual of the
     *         SegmentActivity Object.
     */
    public Boolean getManual() {
        return manual;
    }

    /**
     * Setter for the manual of the SegmentActivity Object.
     * @param manual Boolean taken in to set the manual of
     *               the SegmentActivity Object.
     */
    public void setManual(Boolean manual) {
        this.manual = manual;
    }

    /**
     * Getter for the startTime of the SegmentActivity Object.
     * @return Returns a String, the startTime of the
     *         SegmentActivity Object.
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * Setter for the startTime of the SegmentActivity Object.
     * @param startTime String taken in to set the startTime
     *                  of the SegmentActivity Object.
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * Getter for the endTime of the SegmentActivity Object.
     * @return Returns a String, the endTime of the
     *         SegmentActivity Object.
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * Setter for the endTime of the SegmentActivity Object.
     * @param endTime String taken in to set the endTime of
     *                the SegmentActivity Object.
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * Getter for the duration of the SegmentActivity Object.
     * @return Returns an Integer, the duration of the
     *         SegmentActivity Object.
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * Setter for the duration of the SegmentActivity Object.
     * @param duration Integer taken in to set the duration of
     *                 the SegmentActivity Object.
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /**
     * Getter for the distance of the SegmentActivity Object.
     * @return Returns an Integer, the distance of the
     *         SegmentActivity Object.
     */
    public Integer getDistance() {
        return distance;
    }

    /**
     * Setter for the distance of the SegmentActivity Object.
     * @param distance Integer taken in to set the distance of
     *                 the SegmentActivity Object.
     */
    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    /**
     * Getter for the steps of the SegmentActivity Object.
     * @return Returns an Integer, the steps of the SegmentActivity Object.
     */
    public Integer getSteps() {
        return steps;
    }

    /**
     * Setter for the steps of the SegmentActivity Object.
     * @param steps Integer taken in to set the steps of the
     *              SegmentActivity Object.
     */
    public void setSteps(Integer steps) {
        this.steps = steps;
    }

    /**
     * Getter for the calories of the SegmentActivity Object.
     * @return Returns an Integer, the calories of the
     *         SegmentActivity Object.
     */
    public Integer getCalories() {
        return calories;
    }

    /**
     * Setter for the calories of the SegmentActivity Object.
     * @param calories Integer taken in to set the calories
     *                 of the SegmentActivity Object.
     */
    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    /**
     * equals() for the SegmentActivity Object. Will be used for comparison.
     * @param o Object o will be used for comparison.
     * @return Returns true if the Object calling the method equals Object o,
     *         else returns false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SegmentActivity that = (SegmentActivity) o;
        return Objects.equals(getActivity(), that.getActivity()) && Objects.equals(getGroup(), that.getGroup()) && Objects.equals(getManual(), that.getManual()) && Objects.equals(getStartTime(), that.getStartTime()) && Objects.equals(getEndTime(), that.getEndTime()) && Objects.equals(getDuration(), that.getDuration()) && Objects.equals(getDistance(), that.getDistance()) && Objects.equals(getSteps(), that.getSteps()) && Objects.equals(getCalories(), that.getCalories());
    }

    /**
     * hashCode() for the SegmentActivity Object. Can be used for comparison.
     * @return Returns the SegmentActivity Object as an int.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getActivity(), getGroup(), getManual(), getStartTime(), getEndTime(), getDuration(), getDistance(), getSteps(), getCalories());
    }

    /**
     * toString() for the SegmentActivity Object.
     * @return Returns the SegmentActivity Object as a String.
     */
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

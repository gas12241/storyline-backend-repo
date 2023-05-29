package com.company.storyline.model;

import java.util.Objects;

/**
 * SummaryActivity class that will be used to make up a Day in the
 * Storyline Database.
 */
public class SummaryActivity {
    private String activity;
    private String group;
    private Integer duration;
    private Integer distance;
    private Integer steps;
    private Integer calories;

    /**
     * Empty SummaryActivity constructor.
     */
    public SummaryActivity() {
    }

    /**
     * Getter for the activity of a SummaryActivity Object.
     * @return Returns a String, the activity of the
     *         SummaryActivity Object.
     */
    public String getActivity() {
        return activity;
    }

    /**
     * Setter for the activity of a SummaryActivity Object.
     * @param activity String taken in to set the activity of
     *                 the SummaryActivity Object.
     */
    public void setActivity(String activity) {
        this.activity = activity;
    }

    /**
     * Getter for the group of a SummaryActivity Object.
     * @return Returns a String, the group of the
     *         SummaryActivity Object.
     */
    public String getGroup() {
        return group;
    }

    /**
     * Setter for the group of the SummaryActivity Object.
     * @param group String taken in to set the group of the
     *              SummaryActivity Object.
     */
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * Getter for the duration of the SummaryActivity Object.
     * @return Returns an Integer, the duration of the
     *         SummaryActivity Object.
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * Setter for the duration of the SummaryActivity Object.
     * @param duration Integer taken in to set the duration
     *                 of the SummaryActivity object.
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /**
     * Getter for the distance of the SummaryActivity Object.
     * @return Returns an Integer, the distance of the
     *         SummaryActivity Object.
     */
    public Integer getDistance() {
        return distance;
    }

    /**
     * Setter for the distance of the SummaryActivity Object.
     * @param distance Integer taken in to set the distance
     *                 of the SummaryActivity Object.
     */
    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    /**
     * Getter for the steps of the SummaryActivity Object.
     * @return Returns an Integer, the steps of the
     *         SummaryActivity Object.
     */
    public Integer getSteps() {
        return steps;
    }

    /**
     * Setter for the steps of the SummaryActivity Object.
     * @param steps Integer taken in to set the steps of the
     *              SummaryActivity Object.
     */
    public void setSteps(Integer steps) {
        this.steps = steps;
    }

    /**
     * Getter for the calories of the SummaryActivity Object.
     * @return Returns an Integer, the calories of the
     *         SummaryActivity Object.
     */
    public Integer getCalories() {
        return calories;
    }

    /**
     * Setter for the calories of the SummaryActivity Object.
     * @param calories Integer taken in to set the calories of the
     *                 SummaryActivity Object.
     */
    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    /**
     * equals() for the SummaryActivity Object. Will be used for comparison.
     * @param o Object o being used for comparison.
     * @return Returns true if the Object calling the method equals
     *         Object o. Otherwise, it returns false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SummaryActivity activity1 = (SummaryActivity) o;
        return Objects.equals(getActivity(), activity1.getActivity()) && Objects.equals(getGroup(), activity1.getGroup()) && Objects.equals(getDuration(), activity1.getDuration()) && Objects.equals(getDistance(), activity1.getDistance()) && Objects.equals(getSteps(), activity1.getSteps()) && Objects.equals(getCalories(), activity1.getCalories());
    }

    /**
     * hashCode() for the SummaryActivity Object. Can be used for comparison.
     * @return Returns the SummaryActivity Object as an int.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getActivity(), getGroup(), getDuration(), getDistance(), getSteps(), getCalories());
    }

    /**
     * toString() for the SummaryActivity Object.
     * @return Returns the SummaryActivity Object as a String.
     */
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

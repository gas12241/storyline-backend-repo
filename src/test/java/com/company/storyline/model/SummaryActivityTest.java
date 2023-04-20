package com.company.storyline.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SummaryActivityTest {
    private String activity;
    private String expectedActivity;

    private String group;
    private String expectedGroup;

    private Integer duration;
    private Integer expectedDuration;

    private Integer distance;
    private Integer expectedDistance;

    private Integer steps;
    private Integer expectedSteps;

    private Integer calories;
    private Integer expectedCalories;

    private SummaryActivity summAct;

    private String sameActivity;
    private String sameGroup;
    private Integer sameDuration;
    private Integer sameDistance;
    private Integer sameSteps;
    private Integer sameCalories;

    private SummaryActivity sameSA1;
    private SummaryActivity sameSA2;
    private SummaryActivity sameSA3;

    @Before
    public void setUp() throws Exception {
        activity = "Basketball";
        expectedActivity = "Soccer";

        group = "Basketball";
        expectedGroup = "Soccer";

        duration = 3552;
        expectedDuration = 5500;

        distance = 4590;
        expectedDistance = 5249;

        steps = 5000;
        expectedSteps = 4498;

        calories = 312;
        expectedCalories = 213;

        summAct = new SummaryActivity();
        summAct.setActivity(activity);
        summAct.setGroup(group);
        summAct.setDuration(duration);
        summAct.setDistance(distance);
        summAct.setSteps(steps);
        summAct.setCalories(calories);

        sameActivity = "Football";
        sameGroup = "Football";
        sameDuration = 4500;
        sameDistance = 6000;
        sameSteps = 7500;
        sameCalories = 500;

        sameSA1 = new SummaryActivity();
        sameSA1.setActivity(sameActivity);
        sameSA1.setGroup(sameGroup);
        sameSA1.setDuration(sameDuration);
        sameSA1.setDistance(sameDistance);
        sameSA1.setSteps(sameSteps);
        sameSA1.setCalories(sameCalories);

        sameSA2 = new SummaryActivity();
        sameSA2.setActivity(sameActivity);
        sameSA2.setGroup(sameGroup);
        sameSA2.setDuration(sameDuration);
        sameSA2.setDistance(sameDistance);
        sameSA2.setSteps(sameSteps);
        sameSA2.setCalories(sameCalories);

        sameSA3 = new SummaryActivity();
        sameSA3.setActivity(sameActivity);
        sameSA3.setGroup(sameGroup);
        sameSA3.setDuration(sameDuration);
        sameSA3.setDistance(sameDistance);
        sameSA3.setSteps(sameSteps);
        sameSA3.setCalories(sameCalories);
    }

    @Test
    public void getActivity() {
        assertEquals(activity, summAct.getActivity());
    }

    @Test
    public void setActivity() {
        assertEquals(activity, summAct.getActivity());
        summAct.setActivity(expectedActivity);
        assertEquals(expectedActivity, summAct.getActivity());
    }

    @Test
    public void getGroup() {
        assertEquals(group, summAct.getGroup());
    }

    @Test
    public void setGroup() {
        assertEquals(group, summAct.getGroup());
        summAct.setGroup(expectedGroup);
        assertEquals(expectedGroup, summAct.getGroup());
    }

    @Test
    public void getDuration() {
        assertEquals(duration, summAct.getDuration());
    }

    @Test
    public void setDuration() {
        assertEquals(duration, summAct.getDuration());
        summAct.setDuration(expectedDuration);
        assertEquals(expectedDuration, summAct.getDuration());
    }

    @Test
    public void getDistance() {
        assertEquals(distance, summAct.getDistance());
    }

    @Test
    public void setDistance() {
        assertEquals(distance, summAct.getDistance());
        summAct.setDistance(expectedDistance);
        assertEquals(expectedDistance, summAct.getDistance());
    }

    @Test
    public void getSteps() {
        assertEquals(steps, summAct.getSteps());
    }

    @Test
    public void setSteps() {
        assertEquals(steps, summAct.getSteps());
        summAct.setSteps(expectedSteps);
        assertEquals(expectedSteps, summAct.getSteps());
    }

    @Test
    public void getCalories() {
        assertEquals(calories, summAct.getCalories());
    }

    @Test
    public void setCalories() {
        assertEquals(calories, summAct.getCalories());
        summAct.setCalories(expectedCalories);
        assertEquals(expectedCalories, summAct.getCalories());
    }

    @Test
    public void testEquals() {
        assertTrue(sameSA1.equals(sameSA1));

        assertTrue(sameSA1.equals(sameSA2));
        assertTrue(sameSA2.equals(sameSA1));

        assertTrue(sameSA1.equals(sameSA2));
        assertTrue(sameSA2.equals(sameSA3));
        assertTrue(sameSA1.equals(sameSA3));
    }

    @Test
    public void testHashCode() {
        assertEquals(sameSA1.hashCode(), sameSA1.hashCode());

        assertEquals(sameSA1.hashCode(), sameSA2.hashCode());
        assertEquals(sameSA2.hashCode(), sameSA1.hashCode());

        assertEquals(sameSA1.hashCode(), sameSA2.hashCode());
        assertEquals(sameSA2.hashCode(), sameSA3.hashCode());
        assertEquals(sameSA1.hashCode(), sameSA3.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals(sameSA1.toString(), sameSA1.toString());

        assertEquals(sameSA1.toString(), sameSA2.toString());
        assertEquals(sameSA2.toString(), sameSA1.toString());

        assertEquals(sameSA1.toString(), sameSA2.toString());
        assertEquals(sameSA2.toString(), sameSA3.toString());
        assertEquals(sameSA1.toString(), sameSA3.toString());
    }
}
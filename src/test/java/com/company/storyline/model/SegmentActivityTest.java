package com.company.storyline.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SegmentActivityTest {

    private String activity;
    private String expectedActivity;
    private String sameActivity;

    private String group;
    private String expectedGroup;
    private String sameGroup;

    private Boolean manual;
    private Boolean expectedManual;
    private Boolean sameManual;

    private String startTime;
    private String expectedStartTime;
    private String sameStartTime;

    private String endTime;
    private String expectedEndTime;
    private String sameEndTime;

    private Integer duration;
    private Integer expectedDuration;
    private Integer sameDuration;

    private Integer distance;
    private Integer expectedDistance;
    private Integer sameDistance;

    private Integer steps;
    private Integer expectedSteps;
    private Integer sameSteps;

    private Integer calories;
    private Integer expectedCalories;
    private Integer sameCalories;

    private SegmentActivity segAct;

    private SegmentActivity sameSA1;
    private SegmentActivity sameSA2;
    private SegmentActivity sameSA3;

    @Before
    public void setUp() throws Exception {
        activity = "Walk walk";
        expectedActivity = "Running running";
        sameActivity = "Same Activity";

        group = "Walking";
        expectedGroup = "Running";
        sameGroup = "sameGroup";

        manual = false;
        expectedManual = true;
        sameManual = false;

        startTime = "20130211T070036-0800";
        expectedStartTime = "20130211T070036-0200";
        sameStartTime = "20140211T070036-0200";

        endTime = "20130211T070106-0800";
        expectedEndTime = "20130211T070106-0600";
        sameEndTime = "20140211T070106-0600";

        duration = 40;
        expectedDuration = 20;
        sameDuration = 200;

        distance = 22;
        expectedDistance = 30;
        sameDistance = 100;

        steps = 40;
        expectedSteps = 50;
        sameSteps = 100;

        calories = 2;
        expectedCalories = 10;
        sameCalories = 70;

        segAct = new SegmentActivity();
        segAct.setActivity(activity);
        segAct.setGroup(group);
        segAct.setManual(manual);
        segAct.setStartTime(startTime);
        segAct.setEndTime(endTime);
        segAct.setDuration(duration);
        segAct.setDistance(distance);
        segAct.setSteps(steps);
        segAct.setCalories(calories);

        sameSA1 = new SegmentActivity();
        sameSA1.setActivity(sameActivity);
        sameSA1.setGroup(sameGroup);
        sameSA1.setManual(sameManual);
        sameSA1.setStartTime(sameStartTime);
        sameSA1.setEndTime(sameEndTime);
        sameSA1.setDuration(sameDuration);
        sameSA1.setDistance(sameDistance);
        sameSA1.setSteps(sameSteps);
        sameSA1.setCalories(sameCalories);

        sameSA2 = new SegmentActivity();
        sameSA2.setActivity(sameActivity);
        sameSA2.setGroup(sameGroup);
        sameSA2.setManual(sameManual);
        sameSA2.setStartTime(sameStartTime);
        sameSA2.setEndTime(sameEndTime);
        sameSA2.setDuration(sameDuration);
        sameSA2.setDistance(sameDistance);
        sameSA2.setSteps(sameSteps);
        sameSA2.setCalories(sameCalories);

        sameSA3 = new SegmentActivity();
        sameSA3.setActivity(sameActivity);
        sameSA3.setGroup(sameGroup);
        sameSA3.setManual(sameManual);
        sameSA3.setStartTime(sameStartTime);
        sameSA3.setEndTime(sameEndTime);
        sameSA3.setDuration(sameDuration);
        sameSA3.setDistance(sameDistance);
        sameSA3.setSteps(sameSteps);
        sameSA3.setCalories(sameCalories);
    }

    @Test
    public void getActivity() {
        assertEquals(activity, segAct.getActivity());

    }

    @Test
    public void setActivity() {
        assertEquals(activity, segAct.getActivity());
        segAct.setActivity(expectedActivity);
        assertEquals(expectedActivity, segAct.getActivity());
    }

    @Test
    public void getGroup() {
        assertEquals(group, segAct.getGroup());
    }

    @Test
    public void setGroup() {
        assertEquals(group,segAct.getGroup());
        segAct.setGroup(expectedGroup);
        assertEquals(expectedGroup, segAct.getGroup());
    }

    @Test
    public void getManual() {
        assertEquals(manual, segAct.getManual());
    }

    @Test
    public void setManual() {
        assertEquals(manual, segAct.getManual());
        segAct.setManual(expectedManual);
        assertEquals(expectedManual, segAct.getManual());
    }

    @Test
    public void getStartTime() {
        assertEquals(startTime, segAct.getStartTime());
    }

    @Test
    public void setStartTime() {
        assertEquals(startTime, segAct.getStartTime());
        segAct.setStartTime(expectedStartTime);
        assertEquals(expectedStartTime, segAct.getStartTime());
    }

    @Test
    public void getEndTime() {
        assertEquals(endTime, segAct.getEndTime());
    }

    @Test
    public void setEndTime() {
        assertEquals(endTime, segAct.getEndTime());
        segAct.setEndTime(expectedEndTime);
        assertEquals(expectedEndTime, segAct.getEndTime());
    }

    @Test
    public void getDuration() {
        assertEquals(duration, segAct.getDuration());
    }

    @Test
    public void setDuration() {
        assertEquals(duration, segAct.getDuration());
        segAct.setDuration(expectedDuration);
        assertEquals(expectedDuration, segAct.getDuration());
    }

    @Test
    public void getDistance() {
        assertEquals(distance, segAct.getDistance());
    }

    @Test
    public void setDistance() {
        assertEquals(distance, segAct.getDistance());
        segAct.setDistance(expectedDistance);
        assertEquals(expectedDistance, segAct.getDistance());
    }

    @Test
    public void getSteps() {
        assertEquals(steps, segAct.getSteps());
    }

    @Test
    public void setSteps() {
        assertEquals(steps, segAct.getSteps());
        segAct.setSteps(expectedSteps);
        assertEquals(expectedSteps, segAct.getSteps());
    }

    @Test
    public void getCalories() {
        assertEquals(calories, segAct.getCalories());
    }

    @Test
    public void setCalories() {
        assertEquals(calories, segAct.getCalories());
        segAct.setCalories(expectedCalories);
        assertEquals(expectedCalories, segAct.getCalories());
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
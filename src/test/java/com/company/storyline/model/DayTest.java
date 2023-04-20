package com.company.storyline.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DayTest {

    private String date;
    private String expectedDate;

    private Integer caloriesIdle;
    private Integer expectedCaloriesIdle;

    private String lastUpdate;
    private String expectedLastUpdate;

    private Day day;
    private Day sameAsDay;
    private Day sameAsDay2;

    // Summary Activity
    private String sumAct1;
    private String sumAct2;

    private String sumGroup;
    private String sumGroup2;

    private Integer sumDuration;
    private Integer sumDuration2;

    private Integer sumDist;
    private Integer sumDist2;

    private Integer sumSteps;
    private Integer sumSteps2;

    private Integer sumCal;
    private Integer sumCal2;

    private SummaryActivity sa;
    private SummaryActivity sa2;

    // Story Segment
    private String segType;
    private String segType2;

    private String segST;
    private String segST2;

    private String segET;
    private String segET2;

    // Setup for places in SS
    private Integer segID;
    private Integer segID2;

    private String segName;
    private String segName2;

    private String placeName;
    private String placeName2;

    private Integer placeID;
    private Integer placeID2;

    private String placeType;
    private String placeType2;

    private Location location;
    private Location location2;

    private Place place;
    private Place place2;

    // Last setup for Story Segment
    private String segLastUpdate;
    private String segLastUpdate2;

    private StorySegment ss;
    private StorySegment ss2;

    // Segment Activity for Story Segment
    private String segActivity;
    private String segActGroup;
    private Boolean segActManual;
    private String segActStartTime;
    private String segActEndTime;
    private Integer duration;
    private Integer distance;
    private Integer steps;
    private Integer calories;
    private SegmentActivity segAct1;

    private String segActivity2;
    private String segActGroup2;
    private Boolean segActManual2;
    private String segActStartTime2;
    private String segActEndTime2;
    private Integer duration2;
    private Integer distance2;
    private Integer steps2;
    private Integer calories2;
    private SegmentActivity segAct2;

    @Before
    public void setUp() throws Exception {
        date = "10230132T1293019";
        caloriesIdle = 1429;
        lastUpdate = "03132022T0201440560";

        // Setting up the Summary Activities for the Day
        sumAct1 = "Summary Activity 1";
        sumAct2 = "Summary Activity 2";

        sumGroup = "Summary Group 1";
        sumGroup2 = "Summary Group 2";

        sumDuration = 55;
        sumDuration2 = 85;

        sumDist = 100;
        sumDist2 = 135;

        sumSteps = 115;
        sumSteps2 = 150;

        sumCal = 35;
        sumCal2 = 42;

        sa = new SummaryActivity();
        sa.setActivity(sumAct1);
        sa.setGroup(sumGroup);
        sa.setDuration(sumDuration);
        sa.setDistance(sumDist);
        sa.setSteps(sumSteps);
        sa.setCalories(sumCal);

        sa2 = new SummaryActivity();
        sa2.setActivity(sumAct2);
        sa2.setGroup(sumGroup2);
        sa2.setDuration(sumDuration2);
        sa2.setDistance(sumDist2);
        sa2.setSteps(sumSteps2);
        sa2.setCalories(sumCal2);

        //Setting up the StorySegments for the day
        segType = "Segment Type";
        segType2 = "Segment Type 2";

        segST = "Segment Starting Time";
        segST2 = "Segment Starting Time";

        segET = "Segment Ending Time";
        segET2 = "Segment Ending Time 2";

        segID = 123;
        segID2 = 456;

        segName = "Segment Name 1";
        segName2 = "Segment Name 2";

        placeName = "Place Name";
        placeName2 = "Place Name 2";

        placeID = 1010;
        placeID2 = 2929;

        placeType = "Place Type";
        placeType2 = "Place Type 2";

        location = new Location();
        location.setLon(098.765);
        location.setLat(567.890);

        location2 = new Location();
        location2.setLon(123.456);
        location2.setLat(456.123);

        place = new Place();
        place.setType(placeType);
        place.setId(placeID);
        place.setName(placeName);
        place.setLocation(location);

        place2 = new Place();
        place2.setType(placeType2);
        place2.setId(placeID2);
        place2.setName(placeName2);
        place2.setLocation(location2);

        segLastUpdate = "Story Seg Last Update";
        segLastUpdate2 = "Story Seg Last Update 2";

        ss = new StorySegment();
        ss.setType(segType);
        ss.setStartTime(segST);
        ss.setEndTime(segET);
        ss.setPlace(place);
        ss.setLastUpdate(segLastUpdate);

        ss2 = new StorySegment();
        ss2.setType(segType2);
        ss2.setStartTime(segST2);
        ss2.setEndTime(segET2);
        ss2.setPlace(place2);
        ss2.setLastUpdate(segLastUpdate2);

        // Segment Activities
        segActivity = "Walking";
        segActGroup = "Walking";
        segActManual = false;
        segActStartTime = "20130210T175347-0800";
        segActEndTime = "20130211T083003-0800";
        duration = 489;
        distance = 471;
        steps = 684;
        calories = 24;
        segAct1 = new SegmentActivity();
        segAct1.setActivity(segActivity);
        segAct1.setGroup(segActGroup);
        segAct1.setManual(segActManual);
        segAct1.setStartTime(segActStartTime);
        segAct1.setEndTime(segActEndTime);
        segAct1.setDuration(duration);
        segAct1.setDistance(distance);
        segAct1.setSteps(steps);
        segAct1.setCalories(calories);

        segActivity2 = "Basketball";
        segActGroup2 = "Ballin'";
        segActManual2 = true;
        segActStartTime2 = "20130211T085301-0800";
        segActEndTime2 = "20130211T092952-0800";
        duration2 = 452;
        distance2 = 591;
        steps2 = 827;
        calories2 = 50;
        segAct2 = new SegmentActivity();
        segAct2.setActivity(segActivity2);
        segAct2.setGroup(segActGroup2);
        segAct2.setManual(segActManual2);
        segAct2.setStartTime(segActStartTime2);
        segAct2.setEndTime(segActEndTime2);
        segAct2.setDuration(duration2);
        segAct2.setDistance(distance2);
        segAct2.setSteps(steps2);
        segAct2.setCalories(calories2);

        ss.getActivities().add(segAct1);
        ss2.getActivities().add(segAct2);

        //Set up for Day
        day = new Day();
        day.setDate(date);
        day.setCaloriesIdle(caloriesIdle);
        day.setLastUpdate(lastUpdate);
        day.getSummary().add(sa);
        day.getSummary().add(sa2);
        day.getSegments().add(ss);
        day.getSegments().add(ss2);

        sameAsDay = new Day();
        sameAsDay.setDate(date);
        sameAsDay.setCaloriesIdle(caloriesIdle);
        sameAsDay.setLastUpdate(lastUpdate);
        sameAsDay.getSummary().add(sa);
        sameAsDay.getSummary().add(sa2);
        sameAsDay.getSegments().add(ss);
        sameAsDay.getSegments().add(ss2);

        sameAsDay2 = new Day();
        sameAsDay2.setDate(date);
        sameAsDay2.setCaloriesIdle(caloriesIdle);
        sameAsDay2.setLastUpdate(lastUpdate);
        sameAsDay2.getSummary().add(sa);
        sameAsDay2.getSummary().add(sa2);
        sameAsDay2.getSegments().add(ss);
        sameAsDay2.getSegments().add(ss2);

        expectedDate = "Expected Date";
        expectedCaloriesIdle = 1600;
        expectedLastUpdate = "Expected Last Update";
    }

    @Test
    public void getDate() {
        assertEquals(date, day.getDate());
    }

    @Test
    public void setDate() {
        assertEquals(date, day.getDate());
        day.setDate(expectedDate);
        assertEquals(expectedDate, day.getDate());
    }

    @Test
    public void getSummary() {
        assertEquals(sa, day.getSummary().get(0));
        assertEquals(sa2, day.getSummary().get(1));
    }

    @Test
    public void setSummary() {
        assertEquals(sa, day.getSummary().get(0));

        ArrayList<SummaryActivity> newSummary = new ArrayList<>();
        newSummary.add(sa2);
        day.setSummary(newSummary);
        assertEquals(sa2, day.getSummary().get(0));
    }

    @Test
    public void getSegments() {
        assertEquals(ss, day.getSegments().get(0));
        assertEquals(ss2, day.getSegments().get(1));
    }

    @Test
    public void setSegments() {
        assertEquals(ss, day.getSegments().get(0));

        ArrayList<StorySegment> newSegments = new ArrayList<>();
        newSegments.add(ss2);
        day.setSegments(newSegments);
        assertEquals(ss2, day.getSegments().get(0));
    }

    @Test
    public void getCaloriesIdle() {
        assertEquals(caloriesIdle, day.getCaloriesIdle());
    }

    @Test
    public void setCaloriesIdle() {
        assertEquals(caloriesIdle, day.getCaloriesIdle());
        day.setCaloriesIdle(expectedCaloriesIdle);
        assertEquals(expectedCaloriesIdle, day.getCaloriesIdle());
    }

    @Test
    public void getLastUpdate() {
        assertEquals(lastUpdate, day.getLastUpdate());
    }

    @Test
    public void setLastUpdate() {
        assertEquals(lastUpdate, day.getLastUpdate());
        day.setLastUpdate(expectedLastUpdate);
        assertEquals(expectedLastUpdate, day.getLastUpdate());
    }

    @Test
    public void testEquals() {
        assertTrue(day.equals(day));

        assertTrue(day.equals(sameAsDay));
        assertTrue(sameAsDay.equals(day));

        assertTrue(day.equals(sameAsDay));
        assertTrue(sameAsDay.equals(sameAsDay2));
        assertTrue(day.equals(sameAsDay2));
    }

    @Test
    public void testHashCode() {
        assertEquals(day.hashCode(), sameAsDay.hashCode());

        assertEquals(day.hashCode(), sameAsDay.hashCode());
        assertEquals(sameAsDay.hashCode(), day.hashCode());

        assertEquals(day.hashCode(), sameAsDay.hashCode());
        assertEquals(sameAsDay.hashCode(), sameAsDay2.hashCode());
        assertEquals(day.hashCode(), sameAsDay2.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals(day.toString(), sameAsDay.toString());

        assertEquals(day.toString(), sameAsDay.toString());
        assertEquals(sameAsDay.toString(), day.toString());

        assertEquals(day.toString(), sameAsDay.toString());
        assertEquals(sameAsDay.toString(), sameAsDay2.toString());
        assertEquals(day.toString(), sameAsDay2.toString());
    }
}
package com.company.storyline.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class StorySegmentTest {

    private String storyType;
    private String startTime;
    private String endTime;
    private Integer id;
    private String name;
    private String placeType;
    private Location location;
    private Place place;
    private String lastUpdate;
    private StorySegment ss;
    private StorySegment sameAsSS;
    private StorySegment sameAsSS2;

    private String expectedStoryType;
    private String expectedStartTime;
    private String expectedEndTime;

    private Integer id2;
    private String name2;
    private String placeType2;
    private Location location2;
    private Place expectedPlace2;

    private ArrayList<SegmentActivity> expectedActivities;
    private String expectedLastUpdate;

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
        storyType = "Story Segment Type";
        startTime = "20130210T175347-0800";
        endTime = "20130211T083003-0800";
        lastUpdate = "10293021902391";

        id = 255;

        name = "Home";

        placeType = "home";

        location = new Location();
        location.setLat(25.56978);
        location.setLon(58.0987);

        place = new Place();
        place.setId(id);
        place.setName(name);
        place.setType(placeType);
        place.setLocation(location);


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

        ss = new StorySegment();
        ss.setType(storyType);
        ss.setStartTime(startTime);
        ss.setEndTime(endTime);
        ss.setPlace(place);
        ss.getActivities().add(segAct1);
        ss.getActivities().add(segAct2);
        ss.setLastUpdate(lastUpdate);

        expectedStoryType = "Expected Type";
        expectedStartTime = "Expected Start Time";
        expectedEndTime = "Expected End Time";

        id2 = 12321;
        name2 = "foursquare";
        placeType2 = "type2";
        location2 = new Location();
        location2.setLat(123.1231231);
        location2.setLon(34.231231);
        expectedPlace2 = new Place();
        expectedPlace2.setLocation(location2);
        expectedPlace2.setType(placeType2);
        expectedPlace2.setName(name2);
        expectedPlace2.setId(id2);
        expectedActivities = new ArrayList();
        expectedLastUpdate = "12123321231";


        sameAsSS = new StorySegment();
        sameAsSS.setType(storyType);
        sameAsSS.setStartTime(startTime);
        sameAsSS.setEndTime(endTime);
        sameAsSS.setPlace(place);
        sameAsSS.getActivities().add(segAct1);
        sameAsSS.getActivities().add(segAct2);
        sameAsSS.setLastUpdate(lastUpdate);

        sameAsSS2 = new StorySegment();
        sameAsSS2.setType(storyType);
        sameAsSS2.setStartTime(startTime);
        sameAsSS2.setEndTime(endTime);
        sameAsSS2.setPlace(place);
        sameAsSS2.getActivities().add(segAct1);
        sameAsSS2.getActivities().add(segAct2);
        sameAsSS2.setLastUpdate(lastUpdate);


    }

    @Test
    public void getType() {
        assertEquals(storyType, ss.getType());
    }

    @Test
    public void setType() {
        assertEquals(storyType, ss.getType());
        ss.setType(expectedStoryType);
        assertEquals(expectedStoryType, ss.getType());
    }

    @Test
    public void getStartTime() {
        assertEquals(startTime, ss.getStartTime());
    }

    @Test
    public void setStartTime() {
        assertEquals(startTime, ss.getStartTime());
        ss.setStartTime(expectedStartTime);
        assertEquals(expectedStartTime, ss.getStartTime());
    }

    @Test
    public void getEndTime() {
        assertEquals(endTime, ss.getEndTime());
    }

    @Test
    public void setEndTime() {
        assertEquals(endTime, ss.getEndTime());
        ss.setEndTime(expectedEndTime);
        assertEquals(expectedEndTime, ss.getEndTime());
    }

    @Test
    public void getPlace() {
        assertEquals(place, ss.getPlace());
    }

    @Test
    public void setPlace() {
        assertEquals(place, ss.getPlace());
        ss.setPlace(expectedPlace2);
        assertEquals(expectedPlace2, ss.getPlace());
    }

    @Test
    public void getActivities() {
        assertEquals(segAct1, ss.getActivities().get(0));
    }

    @Test
    public void setActivities() {
        expectedActivities.add(segAct2);
        ss.setActivities(expectedActivities);
        assertEquals(segAct2, ss.getActivities().get(0));
    }

    @Test
    public void getLastUpdate() {
        assertEquals(lastUpdate, ss.getLastUpdate());
    }

    @Test
    public void setLastUpdate() {
        assertEquals(lastUpdate, ss.getLastUpdate());
        ss.setLastUpdate(expectedLastUpdate);
        assertEquals(expectedLastUpdate, ss.getLastUpdate());
    }

    @Test
    public void testEquals() {
        assertTrue(ss.equals(ss));

        assertTrue(ss.equals(sameAsSS));
        assertTrue(sameAsSS.equals(ss));

        assertTrue(ss.equals(sameAsSS));
        assertTrue(sameAsSS.equals(sameAsSS2));
        assertTrue(ss.equals(sameAsSS2));
    }

    @Test
    public void testHashCode() {
        assertEquals(ss.hashCode(), ss.hashCode());

        assertEquals(ss.hashCode(), sameAsSS.hashCode());
        assertEquals(sameAsSS.hashCode(), ss.hashCode());

        assertEquals(ss.hashCode(), sameAsSS.hashCode());
        assertEquals(sameAsSS.hashCode(), sameAsSS2.hashCode());
        assertEquals(ss.hashCode(), sameAsSS2.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals(ss.toString(), ss.toString());

        assertEquals(ss.toString(), sameAsSS.toString());
        assertEquals(sameAsSS.toString(), ss.toString());

        assertEquals(ss.toString(), sameAsSS.toString());
        assertEquals(sameAsSS.toString(), sameAsSS2.toString());
        assertEquals(ss.toString(), sameAsSS2.toString());
    }
}
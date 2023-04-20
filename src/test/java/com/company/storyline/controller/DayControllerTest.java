package com.company.storyline.controller;

import com.company.storyline.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.print.attribute.standard.Media;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DayController.class)
public class DayControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    DayController repo;

    private ObjectMapper mapper = new ObjectMapper();
    private List<Day> dayList;

    private Day inputDay;

    private String date;

    private Integer caloriesIdle;

    private String lastUpdate;

    private Day day;
    private Day differentDay;

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

        differentDay = new Day();
        differentDay.setDate("504102T12321");
        differentDay.setLastUpdate("8978908T87567");
        day.setCaloriesIdle(2400);
        day.getSummary().add(sa2);
        day.getSegments().add(ss2);
    }

    @Test
    public void shouldGetDayByDate() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/days/date/20130211")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void shouldGetAllDays() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/days")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void shouldGetCalorieListFromDate() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/days/date/20130211/calories")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void shouldCreateADayAndReturnIsCreated() throws Exception {
        String inputJson = mapper.writeValueAsString(day);
        mockMvc.perform(post("/days").content(inputJson).contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isCreated());
    }

    @Test
    public void shouldUpdateADayAndReturnIsOk() throws Exception {
        day.setDate("New Updated Date");
        day.setLastUpdate("New Last Update");
        day.setCaloriesIdle(12345);
        String inputJson = mapper.writeValueAsString(day);
        mockMvc.perform(MockMvcRequestBuilders.put("/days").content(inputJson).contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteADayAndReturnNoContent() throws Exception {
        mockMvc.perform(delete("/days/123456")).andDo(print()).andExpect(status().isNoContent());
    }
}
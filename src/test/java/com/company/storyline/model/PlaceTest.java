package com.company.storyline.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlaceTest {
    private Integer id;
    private Integer expectedId;

    private String name;
    private String expectedName;

    private String type;
    private String expectedType;

    private Location location;
    private Location expectedLocation;

    private Place place;


    private Integer sameId;
    private String sameName;
    private String sameType;
    private Location sameLocation;

    private Place samePlace1;
    private Place samePlace2;
    private Place samePlace3;

    @Before
    public void setUp() throws Exception {
        id = 255;
        expectedId = 59;

        name = "Home";
        expectedName = "Not Home";

        type = "home";
        expectedType = "not Home";

        location = new Location();
        location.setLat(25.56978);
        location.setLon(58.0987);

        expectedLocation = new Location();
        expectedLocation.setLat(45.890);
        expectedLocation.setLon(12.345678);


        place = new Place();
        place.setId(id);
        place.setName(name);
        place.setType(type);
        place.setLocation(location);

        sameId = 11;
        sameName = "Name of Same Place";
        sameType = "Name of Same Type";
        sameLocation = new Location();
        sameLocation.setLat(47.7112345);
        sameLocation.setLon(99.9871236);

        samePlace1 = new Place();
        samePlace1.setId(sameId);
        samePlace1.setName(sameName);
        samePlace1.setType(sameType);
        samePlace1.setLocation(sameLocation);

        samePlace2 = new Place();
        samePlace2.setId(sameId);
        samePlace2.setName(sameName);
        samePlace2.setType(sameType);
        samePlace2.setLocation(sameLocation);

        samePlace3 = new Place();
        samePlace3.setId(sameId);
        samePlace3.setName(sameName);
        samePlace3.setType(sameType);
        samePlace3.setLocation(sameLocation);
    }

    @Test
    public void getId() {
        assertEquals(id, place.getId());
    }

    @Test
    public void setId() {
        assertEquals(id, place.getId());
        place.setId(expectedId);
        assertEquals(expectedId, place.getId());
    }

    @Test
    public void getName() {
        assertEquals(name, place.getName());
    }

    @Test
    public void setName() {
        assertEquals(name, place.getName());
        place.setName(expectedName);
        assertEquals(expectedName, place.getName());
    }

    @Test
    public void getType() {
        assertEquals(type, place.getType());
    }

    @Test
    public void setType() {
        assertEquals(type, place.getType());
        place.setType(expectedType);
        assertEquals(expectedType, place.getType());
    }

    @Test
    public void getLocation() {
        assertEquals(location, place.getLocation());
    }

    @Test
    public void setLocation() {
        assertEquals(location, place.getLocation());
        place.setLocation(expectedLocation);
        assertEquals(expectedLocation, place.getLocation());
    }

    @Test
    public void testEquals() {
        assertTrue(samePlace1.equals(samePlace1));

        assertTrue(samePlace1.equals(samePlace2));
        assertTrue(samePlace2.equals(samePlace1));

        assertTrue(samePlace1.equals(samePlace2));
        assertTrue(samePlace2.equals(samePlace3));
        assertTrue(samePlace1.equals(samePlace3));
    }

    @Test
    public void testHashCode() {
        assertEquals(samePlace1.hashCode(), samePlace1.hashCode());

        assertEquals(samePlace1.hashCode(), samePlace2.hashCode());
        assertEquals(samePlace2.hashCode(), samePlace1.hashCode());

        assertEquals(samePlace1.hashCode(), samePlace2.hashCode());
        assertEquals(samePlace2.hashCode(), samePlace3.hashCode());
        assertEquals(samePlace1.hashCode(), samePlace3.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals(samePlace1.toString(), samePlace1.toString());

        assertEquals(samePlace1.toString(), samePlace2.toString());
        assertEquals(samePlace2.toString(), samePlace1.toString());

        assertEquals(samePlace1.toString(), samePlace2.toString());
        assertEquals(samePlace2.toString(), samePlace3.toString());
        assertEquals(samePlace1.toString(), samePlace3.toString());
    }
}
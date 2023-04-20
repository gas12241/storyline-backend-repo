package com.company.storyline.model;

import org.junit.Before;

import static org.junit.Assert.*;

public class LocationTest {

    private Double lat1;
    private Double expectedLat;

    private Double lon1;
    private Double expectedLon;

    private Location location;
    private Location sameLocation;
    private Location sameLocation2;
    private Location sameLocation3;

    @org.junit.Before
    public void setUp() throws Exception {
        lat1 = 47.608013;
        expectedLat = 21.1250;

        lon1 = -122.335167;
        expectedLon = 101.6860;

        location = new Location();
        location.setLat(lat1);
        location.setLon(lon1);

        sameLocation = new Location();
        sameLocation.setLat(lat1);
        sameLocation.setLon(lon1);

        sameLocation2 = new Location();
        sameLocation2.setLat(lat1);
        sameLocation2.setLon(lon1);

        sameLocation3 = new Location();
        sameLocation3.setLat(lat1);
        sameLocation3.setLon(lon1);
    }

    @org.junit.Test
    public void getLat() {
        assertEquals(lat1, location.getLat());
    }

    @org.junit.Test
    public void setLat() {
        assertEquals(lat1, location.getLat());
        location.setLat(expectedLat);
        assertEquals(expectedLat, location.getLat());
    }

    @org.junit.Test
    public void getLon() {
        assertEquals(lon1, location.getLon());
    }

    @org.junit.Test
    public void setLon() {
        assertEquals(lon1, location.getLon());
        location.setLon(expectedLon);
        assertEquals(expectedLon, location.getLon());
    }

    @org.junit.Test
    public void testEquals() {
        assertTrue(sameLocation.equals(sameLocation));

        assertTrue(sameLocation.equals(sameLocation2));
        assertTrue(sameLocation2.equals(sameLocation));

        assertTrue(sameLocation.equals(sameLocation2));
        assertTrue(sameLocation2.equals(sameLocation3));
        assertTrue(sameLocation.equals(sameLocation3));
    }

    @org.junit.Test
    public void testHashCode() {
        assertEquals(sameLocation.hashCode(), sameLocation.hashCode());

        assertEquals(sameLocation.hashCode(), sameLocation2.hashCode());
        assertEquals(sameLocation2.hashCode(), sameLocation.hashCode());

        assertEquals(sameLocation.hashCode(), sameLocation2.hashCode());
        assertEquals(sameLocation2.hashCode(), sameLocation3.hashCode());
        assertEquals(sameLocation.hashCode(), sameLocation3.hashCode());
    }

    @org.junit.Test
    public void testToString() {
        assertEquals(sameLocation.toString(), sameLocation.toString());

        assertEquals(sameLocation.toString(), sameLocation2.toString());
        assertEquals(sameLocation2.toString(), sameLocation.toString());

        assertEquals(sameLocation.toString(), sameLocation2.toString());
        assertEquals(sameLocation2.toString(), sameLocation3.toString());
        assertEquals(sameLocation.toString(), sameLocation3.toString());
    }
}
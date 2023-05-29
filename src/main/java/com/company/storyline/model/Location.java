package com.company.storyline.model;

import java.util.Objects;

/**
 * Location class that will be used for the Day Object
 * in the Storyline Database.
 */
public class Location {
    private Double lat;
    private Double lon;

    /**
     * Empty Location Constructor.
     */
    public Location() {
    }

    /**
     * Getter for the lat of the Location Object.
     * @return Returns a Double, the lat of the Location Object.
     */
    public Double getLat() {
        return lat;
    }

    /**
     * Setter for the lat of the Location Object.
     * @param lat Double taken in to set the lat
     *            of the Location Object.
     */
    public void setLat(Double lat) {
        this.lat = lat;
    }

    /**
     * Getter for the lon of the Location Object.
     * @return Returns a Double, the lon of
     *         the Location Object.
     */
    public Double getLon() {
        return lon;
    }

    /**
     * Setter for the lon of the Location Object.
     * @param lon Double taken in to set the lon
     *            of the Location Object.
     */
    public void setLon(Double lon) {
        this.lon = lon;
    }

    /**
     * equals() for the Location Object. Will be used for comparison.
     * @param o Object o being used for comparison.
     * @return Returns true if the Object calling the method
     *         equals Object o, else returns false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(getLat(), location.getLat()) && Objects.equals(getLon(), location.getLon());
    }

    /**
     * hashCode() for the Location Object. Can be used for comparison.
     * @return Returns the Location Object as an int.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getLat(), getLon());
    }

    /**
     * toString() for the Location Object.
     * @return Returns the Location Object as a String.
     */
    @Override
    public String toString() {
        return "Location{" +
                "lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}

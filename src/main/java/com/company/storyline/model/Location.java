package com.company.storyline.model;

import java.util.Objects;

public class Location {
    private Double lat;
    private Double lon;

    public Location() {
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(getLat(), location.getLat()) && Objects.equals(getLon(), location.getLon());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLat(), getLon());
    }

    @Override
    public String toString() {
        return "Location{" +
                "lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}

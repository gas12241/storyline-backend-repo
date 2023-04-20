package com.company.storyline.model;

import java.util.Objects;

public class Place {
    private Integer id;
    private String name;
    private String type;
    private Location location;

    public Place() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return Objects.equals(getId(), place.getId()) && Objects.equals(getName(), place.getName()) && Objects.equals(getType(), place.getType()) && Objects.equals(getLocation(), place.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getType(), getLocation());
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", location=" + location +
                '}';
    }
}

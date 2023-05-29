package com.company.storyline.model;

import java.util.Objects;

/**
 * Place Class that will be used to make up a
 * Day from the Storyline Database.
 */
public class Place {
    private Integer id;
    private String name;
    private String type;
    private Location location;

    /**
     * Empty Constructor for the Place Object.
     */
    public Place() {
    }

    /**
     * Getter for the id of the Place Object.
     * @return Returns an Integer, the id
     *         of the Place Object.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter for the id of the Place Object.
     * @param id Integer taken in to set the id
     *           of the Place Object.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter for the name of the Place Object.
     * @return Returns a String, the name of
     *         the Place Object.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name of the Place Object.
     * @param name String taken in to set the
     *             name of the Place Object.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the type of the Place Object.
     * @return Returns a String, the type of
     *         the Place Object.
     */
    public String getType() {
        return type;
    }

    /**
     * Setter for the type of the Place Object.
     * @param type String taken in to set the type
     *             of the Place Object.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Getter for the location of the Place Object.
     * @return Returns a Location Object, the location
     *         of the Place Object.
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Setter for the location of the Place Object
     * @param location Location Object taken in to set the
     *                 location of the Place Object.
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * equals() for the Place Object. Will be used for comparison.
     * @param o Object o being used for comparison.
     * @return Returns true if the object calling the method
     *         equals Object o, else it returns false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return Objects.equals(getId(), place.getId()) && Objects.equals(getName(), place.getName()) && Objects.equals(getType(), place.getType()) && Objects.equals(getLocation(), place.getLocation());
    }

    /**
     * hashCode() for the Place Object. Can be used for comparison.
     * @return Returns the Place Object as an int.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getType(), getLocation());
    }

    /**
     * toString() for the Place Object.
     * @return Returns the Place Object as a String.
     */
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

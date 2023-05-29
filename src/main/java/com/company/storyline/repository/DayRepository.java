package com.company.storyline.repository;

import com.company.storyline.model.Day;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Day Repository that will be used to pull Day Objects from the Database.
 */
public interface DayRepository extends MongoRepository<Day, String> {

    /**
     * Method to find a Day by its Date.
     * @param date String taken in to check the Database if it
     *             matches up with a Day Object.
     * @return Returns a Day Object if a Day exists in the Database
     *         with the given date, else it returns nothing.
     */
    Day findByDate(String date);
}

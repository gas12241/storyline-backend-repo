package com.company.storyline.repository;

import com.company.storyline.model.Day;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DayRepository extends MongoRepository<Day, String> {
    Day findByDate(String date);
}

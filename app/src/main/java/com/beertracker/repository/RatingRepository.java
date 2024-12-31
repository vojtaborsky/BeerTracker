package com.beertracker.repository;

import com.beertracker.model.Rating;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RatingRepository extends MongoRepository<Rating, String> {
  List<Rating> findByBeerId(String beerId);
}

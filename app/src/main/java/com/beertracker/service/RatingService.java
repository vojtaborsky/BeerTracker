package com.beertracker.service;

import com.beertracker.model.Rating;
import com.beertracker.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

  @Autowired private RatingRepository ratingRepository;

  public void saveRating(Rating rating) {
    ratingRepository.save(rating);
  }
}

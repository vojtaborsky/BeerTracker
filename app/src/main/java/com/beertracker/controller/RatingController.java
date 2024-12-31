package com.beertracker.controller;

import com.beertracker.model.Rating;
import com.beertracker.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RatingController {

  @Autowired private RatingService ratingService;

  @PostMapping("/ratings")
  public void rateBeer(@RequestBody Rating rating) {
    ratingService.saveRating(rating);
  }
}

package com.beertracker.controller;

import com.beertracker.model.Beer;
import com.beertracker.model.Rating;
import com.beertracker.service.BeerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/beers")
public class BeerController {

  @Autowired private BeerService beerService;

  @GetMapping
  public List<Beer> getAllBeers() {
    return beerService.getAllBeers();
  }

  @GetMapping("/{beerId}/ratings")
  public List<Rating> getRatingsForBeer(@PathVariable String beerId) {
    return beerService.getRatingsForBeer(beerId);
  }

  @PostMapping("/{beerId}/ratings")
  public void rateBeer(@PathVariable String beerId, @RequestBody Rating rating) {
    rating.setBeerId(beerId);
    beerService.saveRating(rating);
  }

  @PutMapping("/ratings/{ratingId}")
  public void updateRating(@PathVariable String ratingId, @RequestBody Rating rating) {
    beerService.updateRating(ratingId, rating);
  }
}

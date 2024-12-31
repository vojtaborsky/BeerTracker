package com.beertracker.service;

import com.beertracker.model.Beer;
import com.beertracker.model.Rating;
import com.beertracker.repository.BeerRepository;
import com.beertracker.repository.RatingRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BeerService {

  @Autowired private BeerRepository beerRepository;

  @Autowired private RatingRepository ratingRepository;

  private static final String API_URL = "https://random-data-api.com/api/v2/beers?size=100";

  public void loadBeersFromAPI() {
    RestTemplate restTemplate = new RestTemplate();
    Beer[] beers = restTemplate.getForObject(API_URL, Beer[].class);
    beerRepository.saveAll(List.of(beers));
  }

  public List<Beer> getAllBeers() {
    return beerRepository.findAll();
  }

  public List<Rating> getRatingsForBeer(String beerId) {
    return ratingRepository.findByBeerId(beerId);
  }

  public void saveRating(Rating rating) {
    ratingRepository.save(rating);
  }

  public void updateRating(String ratingId, Rating newRating) {
    Optional<Rating> existingRating = ratingRepository.findById(ratingId);
    if (existingRating.isPresent()) {
      Rating rating = existingRating.get();
      rating.setStars(newRating.getStars());
      rating.setDescription(newRating.getDescription());
      ratingRepository.save(rating);
    }
  }
}

package com.beertracker.service;

import com.beertracker.model.Beer;
import com.beertracker.repository.BeerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BeerService {

  @Autowired private BeerRepository beerRepository;

  private static final String API_URL = "https://random-data-api.com/api/v2/beers?size=100";

  public void loadBeersFromAPI() {
    RestTemplate restTemplate = new RestTemplate();
    Beer[] beers = restTemplate.getForObject(API_URL, Beer[].class);

    if (beers != null) {
      beerRepository.saveAll(List.of(beers));
      System.out.println("Loaded beers: " + beerRepository.count());
    }
  }

  public List<Beer> getAllBeers() {
    return beerRepository.findAll();
  }
}

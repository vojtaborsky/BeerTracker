package com.beertracker.controller;

import com.beertracker.model.Beer;
import com.beertracker.service.BeerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeerController {

  @Autowired private BeerService beerService;

  @GetMapping("/beers")
  public List<Beer> getAllBeers() {
    return beerService.getAllBeers();
  }
}

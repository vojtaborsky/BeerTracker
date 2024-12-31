package com.beertracker.repository;

import com.beertracker.model.Beer;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BeerRepository extends MongoRepository<Beer, String> {
  List<Beer> findAll();
}

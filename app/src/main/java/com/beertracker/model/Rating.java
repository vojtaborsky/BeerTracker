package com.beertracker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ratings")
public class Rating {
  @Id private String id;
  private String beerId;
  private int stars;
  private String description;
}

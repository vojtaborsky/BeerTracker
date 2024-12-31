package com.beertracker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "beers")
public class Beer {
  @Id private String id;
  private String uuid;
  private String name;
  private String brand;
  private String style;
  private String hop;
  private String yeast;
  private String malts;
  private String ibu;
  private String alcohol;
  private String blg;
}

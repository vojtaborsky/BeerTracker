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

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getAlcohol() {
    return alcohol;
  }

  public void setAlcohol(String alcohol) {
    this.alcohol = alcohol;
  }

  public String getStyle() {
    return style;
  }

  public void setStyle(String style) {
    this.style = style;
  }
}

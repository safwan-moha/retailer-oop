package com.retailer.demo.beans.user;

import static com.retailer.demo.constants.DiscountPercentage.GENERAL;

public abstract class User {

  private int id;
  private String name;

  public User(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double calculateGeneralDiscount(double total) {
    return total * GENERAL.getDiscountPercentage() / 100;
  }

  public abstract double calculateSpecialDiscount(double total);
}

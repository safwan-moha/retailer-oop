package com.retailer.demo.beans.user;

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

  public abstract double calculateSpecialDiscount(double total);
}

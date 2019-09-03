package com.retailer.demo.beans.item;

public class HouseHold extends Item {

  private int weight;

  public HouseHold(String name, double price) {
    super(name, price);
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }
}

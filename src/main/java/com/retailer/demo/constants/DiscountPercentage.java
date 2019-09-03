package com.retailer.demo.constants;

public enum DiscountPercentage {
  GENERAL(5),
  EMPLOYEE(30),
  AFFLIATE(10),
  CUSTOMER(5);

  private int rank;

  DiscountPercentage(int rank) {
    this.rank = rank;
  }

  public int getDiscountPercentage() {
    return rank;
  }
}

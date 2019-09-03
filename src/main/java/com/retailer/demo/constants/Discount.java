package com.retailer.demo.constants;

public enum Discount {
  GENERAL_AMOUNT(5),
  EMPLOYEE_PERCENTAGE(30),
  AFFLIATE_PERCENTAGE(10),
  CUSTOMER_PERCENTAGE(5);

  private int rank;

  Discount(int rank) {
    this.rank = rank;
  }

  public int getDiscount() {
    return rank;
  }
}

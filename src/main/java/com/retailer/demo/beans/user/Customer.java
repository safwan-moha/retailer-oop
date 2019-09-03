package com.retailer.demo.beans.user;

import static com.retailer.demo.constants.Discount.CUSTOMER_PERCENTAGE;

import java.util.Date;

public class Customer extends User {

  private Date createdDate;

  public Customer(String name, Date createdDate) {
    super(name);
    this.createdDate = createdDate;
  }

  public double calculateSpecialDiscount(double total) {
    Date twoYearsBefore = new Date();
    twoYearsBefore.setYear(twoYearsBefore.getYear() - 2);
    if (createdDate.compareTo(twoYearsBefore) < 0)
      return total * CUSTOMER_PERCENTAGE.getDiscount() / 100;
    return 0;
  }
}

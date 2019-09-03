package com.retailer.demo.beans.user;

import static com.retailer.demo.constants.DiscountPercentage.CUSTOMER;

import java.util.Date;

public class Customer extends User {

  private int departmentId;
  private Date createdDate;

  public Customer(String name, int departmentId, Date createdDate) {
    super(name);
    this.departmentId = departmentId;
    this.createdDate = createdDate;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public int getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(int departmentId) {
    this.departmentId = departmentId;
  }

  public double calculateSpecialDiscount(double total) {
    Date twoYearsBefore = new Date();
    twoYearsBefore.setYear(twoYearsBefore.getYear() - 2);
    if (createdDate.compareTo(twoYearsBefore) < 0)
      return total * CUSTOMER.getDiscountPercentage() / 100;
    return 0;
  }
}

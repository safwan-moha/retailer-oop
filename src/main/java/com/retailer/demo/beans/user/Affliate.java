package com.retailer.demo.beans.user;

import static com.retailer.demo.constants.Discount.AFFLIATE_PERCENTAGE;

public class Affliate extends User {

  private int departmentId;

  public Affliate(String name, int departmentId) {
    super(name);
    this.departmentId = departmentId;
  }

  public int getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(int departmentId) {
    this.departmentId = departmentId;
  }

  public double calculateSpecialDiscount(double total) {
    return total * AFFLIATE_PERCENTAGE.getDiscount() / 100;
  }

}

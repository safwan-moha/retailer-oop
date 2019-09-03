package com.retailer.demo.beans.user;

import static com.retailer.demo.constants.DiscountPercentage.EMPLOYEE;

public class Employee extends User {

  private int departmentId;

  public Employee(String name, int departmentId) {
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
    return total * EMPLOYEE.getDiscountPercentage() / 100;
  }

}

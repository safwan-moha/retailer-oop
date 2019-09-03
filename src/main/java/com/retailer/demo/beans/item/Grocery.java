package com.retailer.demo.beans.item;

import java.util.Date;

public class Grocery extends Item {

  private Date expiryDate;

  public Grocery(String name, double price) {
    super(name, price);
  }

  public Date getExpiryDate() {
    return expiryDate;
  }

  public void setExpiryDate(Date expiryDate) {
    this.expiryDate = expiryDate;
  }
}

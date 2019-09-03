package com.retailer.demo.beans.bill;

import static com.retailer.demo.constants.Discount.GENERAL_AMOUNT;

import com.retailer.demo.beans.item.Grocery;
import com.retailer.demo.beans.item.Item;
import com.retailer.demo.beans.user.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Bill {

  private int id;
  private Date date;

  private User user;
  private List<Item> items;
  private double discount;

  public Bill(int id, User user) {
    this.id = id;
    this.user = user;
    discount = 0;
    items = new ArrayList<>();
    date = new Date();
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public List<Item> getItems() {
    return items;
  }

  public void setDiscount(double discount) {
    this.discount = discount;
  }

  public void addItem(Item item) {
    if (item != null)
      this.items.add(item);
  }

  public double calculateGrossTotal() {
    return calculateGrossTotal(items);
  }

  public double calculateGrossTotal(List<Item> items) {
    return items
        .stream()
        .mapToDouble(Item::getPrice)
        .sum();
  }

  public double calculateGrandTotal() {
    return calculateGrossTotal() - discount;
  }

  public double calculateBillDiscount() {
    List<Item> nonGroceryItems = items
        .stream()
        .filter(item -> item.getClass() != Grocery.class)
        .collect(Collectors.toList());

    double total = calculateGrossTotal(nonGroceryItems);

    return (int) (total / 100) * GENERAL_AMOUNT.getDiscount();
  }
}

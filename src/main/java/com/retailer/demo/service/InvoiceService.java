package com.retailer.demo.service;

import com.retailer.demo.beans.bill.Bill;
import com.retailer.demo.beans.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

  private int billNumber = 20000;

  @Value("${currency}")
  String currency;

  public int getNextBillNumber() {
    return billNumber++;
  }

  public double getNetPayable(Bill bill) {
    User user = bill.getUser();

    double specialDiscount = user.calculateSpecialDiscount(bill.calculateGrossTotal());
    double billDiscount = bill.calculateBillDiscount();

    double maxDiscount = Math.max(specialDiscount, billDiscount);

    bill.setDiscount(maxDiscount);
    return bill.calculateGrandTotal();
  }

  public void printBill(Bill bill) {
    System.out.println("Net Payable: " + getNetPayable(bill) + currency);
  }
}

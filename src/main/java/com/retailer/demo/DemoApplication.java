package com.retailer.demo;

import static com.retailer.demo.constants.Constants.Departments.CLEANING_DEPARTMENT;

import com.retailer.demo.beans.bill.Bill;
import com.retailer.demo.beans.item.Grocery;
import com.retailer.demo.beans.item.HouseHold;
import com.retailer.demo.beans.user.Employee;
import com.retailer.demo.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

  @Autowired
  InvoiceService invoiceService;

  @Value("${user.name}")
  String name;

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    Employee cleaner = new Employee(name, CLEANING_DEPARTMENT);

    Grocery rice = new Grocery("Samba Rice", 2.3);
    HouseHold broom = new HouseHold("Broom", 20);

    int nextBillNum = invoiceService.getNextBillNumber();

    Bill bill = new Bill(nextBillNum, cleaner);
    bill.addItem(rice);
    bill.addItem(broom);

    double netPayable = invoiceService.getNetPayable(bill);

    invoiceService.printBill(bill);
  }
}

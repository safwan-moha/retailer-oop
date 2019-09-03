package com.retailer.demo.beans.bill;

import static com.retailer.demo.constants.Constants.Departments.CLEANING_DEPARTMENT;
import static org.junit.Assert.assertEquals;

import com.retailer.demo.beans.item.Grocery;
import com.retailer.demo.beans.item.HouseHold;
import com.retailer.demo.beans.user.Employee;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BillTests {

  int billNum = 4444;
  Employee employee = new Employee("dummy", CLEANING_DEPARTMENT);
  Grocery rice = new Grocery("Samba Rice", 2.3);
  HouseHold broom = new HouseHold("Broom", 200);
  Bill bill = new Bill(billNum, employee);

  @AfterAll
  public void tearDown() {
    bill = new Bill(billNum, employee);
  }

  @Test
  public void testAddBill() {
    assertEquals(0, bill.getItems().size());
    bill.addItem(rice);
    assertEquals(1, bill.getItems().size());
  }

  @Test
  public void testCalculateGrossTotal() {
    bill.addItem(rice);
    bill.addItem(rice);
    assertEquals(4.6, bill.calculateGrossTotal(),0);
  }

  @Test
  public void testCalculateBillDiscountGrocery() {
    bill.addItem(rice);
    assertEquals(0, bill.calculateBillDiscount(),0);
  }

  @Test
  public void testCalculateBillDiscount() {
    bill.addItem(broom);
    assertEquals(10, bill.calculateBillDiscount(),0);
  }
}

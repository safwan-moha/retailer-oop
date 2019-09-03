package com.retailer.demo.beans.item;

import static com.retailer.demo.constants.Constants.Departments.CLEANING_DEPARTMENT;
import static org.junit.Assert.assertEquals;

import com.retailer.demo.beans.user.Affliate;
import com.retailer.demo.beans.user.Customer;
import com.retailer.demo.beans.user.Employee;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemTests {

  String name = "dummy";

  @Test
  public void testEmployeeDiscount() {
    Employee user = new Employee(name, CLEANING_DEPARTMENT);
    double discount = user.calculateSpecialDiscount(500);

    assertEquals(150, discount, 0);
  }

  @Test
  public void testAffliateDiscount() {
    Affliate user = new Affliate(name, CLEANING_DEPARTMENT);
    double discount = user.calculateSpecialDiscount(500);

    assertEquals(50, discount, 0);
  }

  @Test
  public void testNewCustomerDiscount() {
    Customer user = new Customer(name, CLEANING_DEPARTMENT, new Date());
    double discount = user.calculateSpecialDiscount(500);

    assertEquals(0, discount, 0);
  }

  @Test
  public void testOldCustomerDiscount() {
    Date threeYearsAgo = new Date();
    threeYearsAgo.setYear(threeYearsAgo.getYear() - 3);
    Customer user = new Customer(name, CLEANING_DEPARTMENT, threeYearsAgo);
    double discount = user.calculateSpecialDiscount(500);

    assertEquals(25, discount, 0);
  }
}

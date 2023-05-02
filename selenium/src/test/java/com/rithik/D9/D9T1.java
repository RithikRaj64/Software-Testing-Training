package com.rithik.D9;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class D9T1 {
  @Test(dataProvider = "dp")
  public void add(Integer a, Integer b) {
    System.out.println(a + b);
    if (a == 100 && b == 10)
      Assert.assertEquals(110, (a + b));
    else
      Assert.assertEquals(15, (a + b));
  }

  @Test(dataProvider = "dp")
  public void sub(Integer a, Integer b) {
    System.out.println(a - b);
    if (a == 100 && b == 10)
      Assert.assertEquals(90, (a - b));
    else
      Assert.assertEquals(5, (a - b));
  }

  @Test(dataProvider = "dp")
  public void mul(Integer a, Integer b) {
    System.out.println(a * b);
    if (a == 100 && b == 10)
      Assert.assertEquals(1000, (a * b));
    else
      Assert.assertEquals(50, (a * b));
  }

  @Test(dataProvider = "dp")
  public void div(Integer a, Integer b) {
    System.out.println(a / b);
    if (a == 100 && b == 10)
      Assert.assertEquals(10, (a / b));
    else
      Assert.assertEquals(2, (a / b));
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
        new Object[] { 100, 10 },
        new Object[] { 10, 5 },
    };
  }
}

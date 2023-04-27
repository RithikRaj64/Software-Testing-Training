package com.rithik.D7;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import org.junit.Assert;

public class D7T2 {

  // Defining variables to test
  int a = 5;
  int b = 5;

  @Test(priority = 1)
  public void add() {
    Assert.assertEquals(10, Calculator.addition(a, b));
  }

  @Test(priority = 2)
  public void sub() {
    Assert.assertEquals(0, Calculator.subtraction(a, b));
  }

  @Test(priority = 3)
  public void mul() {
    Assert.assertEquals(25, Calculator.multiplication(a, b));
  }

  @Test(priority = 4)
  public void div() {
    Assert.assertEquals(1, Calculator.division(a, b));
  }

  @BeforeTest
  public void beforeTest() {
    System.out.println("Performing basic Calculator operations");
  }

  @AfterTest
  public void afterTest() {
    System.out.println("All operations performed successfully");
  }

}

// Defining a class for Calculator
class Calculator {
  // Defining functions for all the operations
  public static int addition(int a, int b) {
    System.out.println("Testing addition");
    return a + b;
  }

  public static int subtraction(int a, int b) {
    System.out.println("Testing subtraction");
    return a - b;
  }

  public static int multiplication(int a, int b) {
    System.out.println("Testing multiplication");
    return a * b;
  }

  public static int division(int a, int b) {
    System.out.println("Testing division");
    return a / b;
  }
}
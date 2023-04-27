package com.rithik.D7;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class D7T1 {

  WebDriver driver;

  @Test
  public void f() {
    System.out.println("Test");
  }

  @BeforeTest
  public void beforeTest() {
    // Driver setup
    WebDriverManager.chromedriver().setup();
    ChromeOptions co = new ChromeOptions();
    co.addArguments("--remote-allow-origins=*");
    driver = new ChromeDriver(co);
  }

  @AfterTest
  public void afterTest() {
    // Close the browser
    driver.quit();
  }

  static void searchAndPrint(WebDriver driver, String url, String query) {
    // Open the URL
    driver.get(url);

    // Search
    WebElement search = driver.findElement(By.name("q"));
    search.sendKeys(query, Keys.ENTER);

    // Get window ID and print
    String id = driver.getWindowHandle();
    System.out.println("Window ID : " + id);

    // Get title and print
    String title = driver.getTitle();
    System.out.println("Title : " + title);
  }

}

package com.rithik.D7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import org.junit.Assert;

public class D7T1 {

  WebDriver driver;

  @Test
  public void f() {
    // Assert the title
    String expectedTitle = "Guest Registration Form – User Registration";
    String actualTitle = driver.getTitle();
    Assert.assertEquals(expectedTitle, actualTitle);
  }

  @BeforeTest
  public void beforeTest() {
    // Driver setup
    WebDriverManager.chromedriver().setup();
    ChromeOptions co = new ChromeOptions();
    co.addArguments("--remote-allow-origins=*");
    driver = new ChromeDriver(co);

    String url = "https://demo.wpeverest.com/user-registration/guest-registration-form/";

    // Open the URL
    driver.get(url);

    // Maximize
    driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
    // Close the browser
    driver.quit();
  }

}

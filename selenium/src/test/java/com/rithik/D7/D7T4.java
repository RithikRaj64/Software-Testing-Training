package com.rithik.D7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.junit.Assert;

public class D7T4 {

  WebDriver driver;

  @Test
  public void Login() throws InterruptedException {
    // Enter username
    WebElement username = driver.findElement(By.name("username"));
    username.sendKeys("Admin");

    // Enter password
    WebElement password = driver.findElement(By.name("password"));
    password.sendKeys("admin123");

    // Click on login button
    WebElement login = driver
        .findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
    login.click();

    // Wait for 2 seconds
    Thread.sleep(2000);

    // Assert the URL
    String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
    String actualURL = driver.getCurrentUrl();

    Assert.assertEquals(expectedURL, actualURL);
  }

  @Test(dependsOnMethods = { "Login" })
  public void Logout() throws InterruptedException {

    // Open the dropdown
    WebElement dropdown = driver
        .findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/img"));
    dropdown.click();

    // Click on Logout button
    WebElement logout = driver
        .findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a"));
    logout.click();

    // Wait for 2 seconds
    Thread.sleep(2000);

    // Assert the URL
    String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    String actualURL = driver.getCurrentUrl();

    Assert.assertEquals(expectedURL, actualURL);
  }

  @BeforeTest
  public void beforeTest() throws InterruptedException {
    // Driver setup
    WebDriverManager.chromedriver().setup();
    ChromeOptions co = new ChromeOptions();
    co.addArguments("--remote-allow-origins=*");
    driver = new ChromeDriver(co);

    String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    // Open the URL
    driver.get(url);

    // Maximize
    driver.manage().window().maximize();

    // Wait for 2 seconds
    Thread.sleep(2000);
  }

  @AfterTest
  public void afterTest() {
    // Close the browser
    System.err.println("Closing the browser");
    driver.quit();
  }

}

package com.rithik.D9;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

public class D9T2_3 {
  WebDriver driver;

  @Test()
  public void test1() throws InterruptedException {
    // Driver setup
    WebDriverManager.chromedriver().setup();
    ChromeOptions co = new ChromeOptions();
    co.addArguments("--remote-allow-origins=*");
    WebDriver driver = new ChromeDriver(co);

    String url = "https://www.godaddy.com/";

    // Open the URL
    driver.get(url);

    // Maximize
    driver.manage().window().maximize();

    // Assert the title
    String title = driver.getTitle();
    String expectedTitle = "Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy IN";
    Assert.assertEquals(expectedTitle, title);

    // Assert the URL
    String currentURL = driver.getCurrentUrl();
    String expectedURL = "https://www.godaddy.com/en-in";
    Assert.assertEquals(expectedURL, currentURL);
  }

  @Test()
  public void test2() throws InterruptedException {
    // Driver setup
    WebDriverManager.chromedriver().setup();
    ChromeOptions co = new ChromeOptions();
    co.addArguments("--remote-allow-origins=*");
    WebDriver driver = new ChromeDriver(co);

    String url = "https://www.godaddy.com/";

    // Open the URL
    driver.get(url);

    // Maximize
    driver.manage().window().maximize();

    // Waiting for 3 seconds
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    // Clicking on Domains
    WebElement Domains = driver.findElement(By.className("fsp77ll"));
    Domains.click();

    // Clicking on Domain Name Search
    WebElement DomainNameSearch = driver.findElement(By.linkText("Domain Name Search"));
    DomainNameSearch.click();

    Thread.sleep(2000);
  }

  @Test()
  public void test3() throws InterruptedException {
    // Driver setup
    WebDriverManager.chromedriver().setup();
    ChromeOptions co = new ChromeOptions();
    co.addArguments("--remote-allow-origins=*");
    WebDriver driver = new ChromeDriver(co);

    String url = "https://www.godaddy.com/";

    // Open the URL
    driver.get(url);

    // Maximize
    driver.manage().window().maximize();

    // Waiting for 3 seconds
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    // Clicking on Domains
    WebElement Domains = driver.findElement(By.className("fsp77ll"));
    Domains.click();

    // Clicking on Domain Name Search
    WebElement DomainNameSearch = driver.findElement(By.linkText("Domain Name Search"));
    DomainNameSearch.click();

    Thread.sleep(2000);

    // Get title and print
    String title = driver.getTitle();
    System.out.println("Title: " + title);

    // Assert the title
    String expectedTitle = "GoDaddy Domain Search - Buy and Register Available Domain Names";
    Assert.assertEquals(expectedTitle, title);

    // Check if the search box is present and enabled
    WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"8469f0c3-e08f-4343-9756-ce0390b0d581\"]"));
    Assert.assertTrue(searchBox.isDisplayed());
    Assert.assertTrue(searchBox.isEnabled());

    // Check if the buy it button in present
    WebElement buyIt = driver.findElement(By.xpath(
        "//*[@id=\"id-1467954b-c5e3-4b0c-9046-9fc94d8ca892\"]/section/div/div/section/div/div[1]/div/div/div[2]/button"));
    Assert.assertTrue(buyIt.isDisplayed());

    // Give input to the search box and click Buy It
    searchBox.sendKeys("mydomain");
    buyIt.click();
  }

  @AfterTest
  public void afterMethod() {
    // Close the browser
    driver.quit();
  }
}

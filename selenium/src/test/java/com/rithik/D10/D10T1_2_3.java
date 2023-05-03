package com.rithik.D10;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class D10T1_2_3 {

  ExtentTest extentTest;
  ExtentReports extentReports;
  ExtentHtmlReporter extentHtmlReporter;

  @BeforeTest
  public void createReporter() {
    // Extent report setup
    extentHtmlReporter = new ExtentHtmlReporter("R:\\SEM 4 Training\\Software Testing\\Code\\selenium\\src\\test\\java\\com\\rithik\\D10\\page.html");
    extentReports = new ExtentReports();
    extentReports.attachReporter(extentHtmlReporter);

    // Setting configs for the html page
    extentHtmlReporter.config().setReportName("D10T1_2_3 Report");
    extentHtmlReporter.config().setDocumentTitle("D10T1_2_3");
    extentHtmlReporter.config().setChartVisibilityOnOpen(true);
    extentHtmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
    extentHtmlReporter.config().setTheme(Theme.STANDARD);
  }

  WebDriver driver;

  @Test()
  public void test1() {
    // Assert the title
    String title = driver.getTitle();
    String expectedTitle = "Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy IN";
    Assert.assertEquals(expectedTitle, title);

    // Assert the URL
    String currentURL = driver.getCurrentUrl();
    String expectedURL = "https://www.godaddy.com/en-in";
    Assert.assertEquals(expectedURL, currentURL);

    // Creating the extent test
    extentTest = extentReports.createTest("Test Case 1", "Asserting the title and URL");
  }

  @Test()
  public void test2() throws InterruptedException {
    // Waiting for 3 seconds
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    // Clicking on Domains
    WebElement Domains = driver.findElement(By.className("fsp77ll"));
    Domains.click();

    // Clicking on Domain Name Search
    WebElement DomainNameSearch = driver.findElement(By.linkText("Domain Name Search"));
    DomainNameSearch.click();

    Thread.sleep(2000);

    // Creating the extent test
    extentTest = extentReports.createTest("Test Case 2", "Clicking on Domain Name Search");
  }

  @Test()
  public void test3() throws InterruptedException {
    // Open the Domain Name Search page
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

    // Creating the extent test
    extentTest = extentReports.createTest("Test Case 3", "Searching for a domain name and clicking Buy It");
  }

  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
    // Driver setup
    WebDriverManager.chromedriver().setup();
    ChromeOptions co = new ChromeOptions();
    co.addArguments("--remote-allow-origins=*");
    driver = new ChromeDriver(co);

    String url = "https://www.godaddy.com/";

    // Open the URL
    driver.get(url);

    // Maximize
    driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod(ITestResult result) {
    // Generate the test status and pass it to the extent report
    if (result.getStatus() == ITestResult.FAILURE) {
      extentTest.log(Status.FAIL, result.getThrowable());
    } else if (result.getStatus() == ITestResult.SUCCESS) {
      extentTest.log(Status.PASS, result.getTestName());
    } else {
      extentTest.log(Status.SKIP, result.getTestName());
    }

    // Close the driver
    driver.quit();
  }

  @AfterTest
  public void aftertest() {
    extentReports.flush();
  }

}

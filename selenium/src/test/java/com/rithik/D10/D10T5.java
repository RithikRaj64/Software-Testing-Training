package com.rithik.D10;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;

public class D10T5 {

  // Creating extent report
  ExtentTest extentTest;
  ExtentReports extentReports;
  ExtentHtmlReporter extentHtmlReporter;
  String screenshot = "R:\\SEM 4 Training\\Software Testing\\Code\\selenium\\src\\test\\java\\com\\rithik\\D10\\test5.png";

  @BeforeTest
  public void extent() {
    // Extent report setup
    extentHtmlReporter = new ExtentHtmlReporter(
        "R:\\SEM 4 Training\\Software Testing\\Code\\selenium\\src\\test\\java\\com\\rithik\\D10\\test5.html");
    extentReports = new ExtentReports();
    extentReports.attachReporter(extentHtmlReporter);

    // Setting configs for the html page
    extentHtmlReporter.config().setReportName("D10T5 Report");
    extentHtmlReporter.config().setDocumentTitle("D10T5");
    extentHtmlReporter.config().setChartVisibilityOnOpen(true);
    extentHtmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
    extentHtmlReporter.config().setTheme(Theme.STANDARD);
  }

  WebDriver driver;

  @Test
  public void f() throws InterruptedException {
	// Creating the extent test
	extentTest = extentReports.createTest("Test Case 5", "Login to OrangeHRM wrong Credentials");

    // Enter username
    WebElement username = driver.findElement(By.name("username"));
    username.sendKeys("Suvitha");

    // Enter password
    WebElement password = driver.findElement(By.name("password"));
    password.sendKeys("12345");

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

  @BeforeMethod
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

  @AfterMethod
  public void afterTest(ITestResult result) throws IOException {
    // Status into log
    if (result.getStatus() == ITestResult.SUCCESS) {
      extentTest.log(Status.PASS, result.getTestName());
    } else if (result.getStatus() == ITestResult.FAILURE) {
      takeScreenshot(screenshot);
      extentTest.log(Status.FAIL, result.getThrowable());
      extentTest.addScreenCaptureFromPath(screenshot);
    } else if (result.getStatus() == ITestResult.SKIP) {
      extentTest.log(Status.SKIP, result.getTestName());
    }

    // Close the browser
    driver.quit();

    // Flush the report
    extentReports.flush();
  }

  // Screenshot function
  public void takeScreenshot(String path) throws IOException {
    // Convert web driver object to TakeScreenshot
    TakesScreenshot scrShot = ((TakesScreenshot) driver);

    // Call getScreenshotAs method to create image file
    File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

    // Move image file to new destination
    File DestFile = new File(path);

    // Copy file at destination
    FileUtils.copyFile(SrcFile, DestFile);
  }

}

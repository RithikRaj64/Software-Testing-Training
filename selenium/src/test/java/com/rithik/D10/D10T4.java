package com.rithik.D10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.annotations.Parameters;

import org.junit.Assert;

public class D10T4 {

  // Creating the extent report
  ExtentTest extentTest;
  ExtentReports extentReports;
  ExtentHtmlReporter extentHtmlReporter;

  @BeforeTest
  public void extent() {
    // Extent report setup
    extentHtmlReporter = new ExtentHtmlReporter(
        "R:\\SEM 4 Training\\Software Testing\\Code\\selenium\\src\\test\\java\\com\\rithik\\D10\\test4.html");
    extentReports = new ExtentReports();
    extentReports.attachReporter(extentHtmlReporter);

    // Setting configs for the html page
    extentHtmlReporter.config().setReportName("D10T4 Report");
    extentHtmlReporter.config().setDocumentTitle("D10T4");
    extentHtmlReporter.config().setChartVisibilityOnOpen(true);
    extentHtmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
    extentHtmlReporter.config().setTheme(Theme.STANDARD);
  }

  WebDriver driver;

  @Test
  public void f() throws InterruptedException {

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

    // Create test
    extentTest = extentReports.createTest("Test Case 4", "Login to OrangeHRM");
  }

  @Parameters("browser")
  @BeforeMethod
  public void beforeTest(String browser) throws InterruptedException {

    // Chrome Driver setup
    if (browser.equals("chrome")) {
      WebDriverManager.chromedriver().setup();
      ChromeOptions co = new ChromeOptions();
      co.addArguments("--remote-allow-origins=*");
      driver = new ChromeDriver(co);
    }

    // Edge Driver setup
    else if (browser.equals("edge")) {
      WebDriverManager.edgedriver().setup();
      driver = new EdgeDriver();
    }

    String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    // Open the URL
    driver.get(url);

    // Maximize
    driver.manage().window().maximize();

    // Wait for 2 seconds
    Thread.sleep(2000);
  }

  @AfterMethod
  public void afterTest(ITestResult result) {

    // Take status and put in log
    if (result.getStatus() == ITestResult.FAILURE) {
      extentTest.log(Status.FAIL, result.getThrowable());
    } else if (result.getStatus() == ITestResult.SUCCESS) {
      extentTest.log(Status.PASS, result.getTestName());
    } else {
      extentTest.log(Status.SKIP, result.getTestName());
    }

    // Close the browser
    driver.quit();

    // Flush the report
    extentReports.flush();
  }
}

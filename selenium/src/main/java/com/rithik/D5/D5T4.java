package com.rithik.D5;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class D5T4 {
    public static void main(String[] args) {

        // Driver setup
        WebDriverManager.chromedriver().setup();
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(co);

        // URL to open
        String url = "https://www.abhibus.com/bus-ticket-booking";

        // Open the URL
        driver.get(url);

        // Maximize
        driver.manage().window().maximize();

        // Fill the from and to boxes
        WebElement from = driver.findElement(By.id("source"));
        WebElement to = driver.findElement(By.id("destination"));

        from.sendKeys("New Orleans");
        to.sendKeys("Mystic Falls");

        // To enter the date of journey we use JS executor
        WebElement date = driver.findElement(By.id("datepicker1"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='30/04/2023'", date);
    }
}

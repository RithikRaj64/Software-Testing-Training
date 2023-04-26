package com.rithik.D4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class D4T4 {
    public static void main(String[] args) throws InterruptedException {
        // Driver setup
        WebDriverManager.chromedriver().setup();
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(co);

        // URL to open
        String url = "https://j2store.net/free/";

        // Open the URL
        driver.get(url);

        // Maximize
        driver.manage().window().maximize();

        // Scroll the page
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 1000)");

        // Click on Clothing
        WebElement clothingLink = driver.findElement(By.linkText("Clothing (5)"));
        clothingLink.click();

        // If linkText doesn't work use xpath
        // driver.findElement(By.xpath("//*[@id=\"Mod112\"]/div/div/ul/li[1]/h4/a"));

        // Navigate backward
        driver.navigate().back();

        Thread.sleep(2000);

        // Navigate forward
        driver.navigate().forward();

        // Refresh
        driver.navigate().refresh();

        Thread.sleep(2000);

        // Close browser
        driver.quit();
    }
}
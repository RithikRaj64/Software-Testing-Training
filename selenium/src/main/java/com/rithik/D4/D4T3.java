package com.rithik.D4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class D4T3 {
    public static void main(String[] args) throws InterruptedException {
        // Driver setup
        WebDriverManager.chromedriver().setup();
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(co);

        // URL to open
        String url = "https://demo.opencart.com/index.php?route=account/register&language=en-gb";

        // Open the URL
        driver.get(url);

        // Maximize
        driver.manage().window().maximize();

        // Scrolling
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");

        // First Name
        WebElement firstName = driver.findElement(By.xpath("//*[@id=\"input-firstname\"]"));
        firstName.sendKeys("Klaus");

        // Last Name
        WebElement lastName = driver.findElement(By.xpath("//*[@id=\"input-lastname\"]"));
        lastName.sendKeys("Mikaelson");

        // Email
        WebElement email = driver.findElement(By.xpath("//*[@id=\"input-email\"]"));
        email.sendKeys("thehybrid@hotmail.com");

        // Password
        WebElement password = driver.findElement(By.xpath("//*[@id=\"input-password\"]"));
        password.sendKeys("password");

        // Subscribe
        WebElement subscribe = driver.findElement(By.xpath("//*[@id=\"input-newsletter-yes\"]"));
        subscribe.click();

    }
}

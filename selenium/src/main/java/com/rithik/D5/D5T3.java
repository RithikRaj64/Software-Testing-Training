package com.rithik.D5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class D5T3 {
    public static void main(String[] args) throws InterruptedException {

        // Driver setup
        WebDriverManager.chromedriver().setup();
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(co);

        // URL to open
        String url = "https://demo.guru99.com/test/delete_customer.php";

        // Open the URL
        driver.get(url);

        // Maximize
        driver.manage().window().maximize();

        // Type the customer ID
        WebElement customerId = driver.findElement(By.name("cusid"));
        customerId.sendKeys("401");

        // Click the submit button
        WebElement submit = driver.findElement(By.name("submit"));
        submit.click();

        // Create an Alert object
        Alert alert1 = driver.switchTo().alert();

        // Cancel the alert
        alert1.dismiss();

        // Clear the text box
        customerId.clear();

        // Type the new customer ID
        customerId.sendKeys("402");

        // Click the submit button again
        submit.click();

        // Create an Alert object
        Alert alert2 = driver.switchTo().alert();

        // Accept the alert
        alert2.accept();

        // Create an Alert object
        Alert alert3 = driver.switchTo().alert();

        // Accept the alert
        String finalAlert = alert2.getText();

        // Accept the alert
        alert3.accept();

        // Print the final alert
        System.out.println(finalAlert);

        // Close the browser
        driver.quit();
    }
}

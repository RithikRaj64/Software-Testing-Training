package com.rithik.cc1;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class question2 {
    public static void main(String[] args) throws InterruptedException {
        // Setting up driver
        WebDriverManager.chromedriver().setup();
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(co);

        String url = "https://www.saucedemo.com/";

        driver.get(url);

        driver.manage().window().maximize();

        // Login
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // Verify if A-Z and Z-A filters available
        Select filter = new Select(
                driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")));
        List<WebElement> li = filter.getOptions();
        int count = 0;

        for (WebElement x : li) {
            if (x.getText().equals("Name (A to Z)") || x.getText().equals("Name (Z to A)"))
                count++;
        }

        Assert.assertEquals(count, 2);

        System.out.println("* User is able to apply filter name wise from A-Z and Z-A");

        WebElement firstName;
        // First product name in asc
        filter.selectByIndex(0);
        firstName = driver.findElement(By.className("inventory_item_name"));
        System.out.println("First Product Name (A-Z) : " + firstName.getText());

        // First product name in desc
        filter.selectByIndex(1);
        firstName = driver.findElement(By.className("inventory_item_name"));
        System.out.println("First Product Name (Z-A) : " + firstName.getText());

        // Verify if price filters available
        Select filter2 = new Select(
                driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")));
        List<WebElement> li2 = filter2.getOptions();

        int count2 = 0;

        for (WebElement x : li2) {
            if (x.getText().equals("Price (low to high)") || x.getText().equals("Price (high to low)"))
                count2++;
        }

        Assert.assertEquals(count2, 2);

        System.out.println("* User is able to apply filter from low price to high price and high price to low price");

        WebElement firstPrice;
        // First product price in asc
        filter2.selectByIndex(2);
        firstPrice = driver.findElement(By.className("inventory_item_price"));
        System.out.println("First Product Price (low-high) : " + firstPrice.getText());

        Select filter3 = new Select(
                driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")));

        // First product price in desc
        filter3.selectByIndex(3);
        firstPrice = driver.findElement(By.className("inventory_item_price"));
        System.out.println("First Product Price (high-low) : " + firstPrice.getText());

        // Close the browser
        driver.quit();
    }
}

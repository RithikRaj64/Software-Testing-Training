package com.rithik.cc1;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class question1 {
    public static void main(String[] args) {
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

        // Click add to cart
        WebElement addToCart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCart.click();
        System.out.println("* User can add the product");

        WebElement cart = driver.findElement(By.className("shopping_cart_link"));
        cart.click();

        // Check if cart contents displayed
        WebElement cartList = driver.findElement(By.className("cart_list"));
        Assert.assertTrue(cartList.isDisplayed());
        System.out.println("* Cart contents displayed");

        // Click checkout
        WebElement checkout = driver.findElement(By.id("checkout"));
        checkout.click();

        // Check if info is asked
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/checkout-step-one.html";
        Assert.assertEquals(currentUrl, expectedUrl);
        System.out.println("* Your Information is displayed");

        // Fill form
        WebElement fName = driver.findElement(By.id("first-name"));
        fName.sendKeys("FirstName");

        WebElement lName = driver.findElement(By.id("last-name"));
        lName.sendKeys("LastName");

        WebElement zCode = driver.findElement(By.id("postal-code"));
        zCode.sendKeys("123456");

        WebElement continueBtn = driver.findElement(By.id("continue"));
        continueBtn.click();

        // Check product overview is displayed
        WebElement cartItem = driver.findElement(By.className("cart_item"));
        Assert.assertTrue(cartItem.isDisplayed());
        System.out.println("* Product Overview is displayed");

        // Name and price of the product
        WebElement itemName = driver.findElement(By.className("inventory_item_name"));
        System.out.println("Product name : " + itemName.getText());

        WebElement itemPrice = driver.findElement(By.className("inventory_item_price"));
        System.out.println("Product price : " + itemPrice.getText());

        // Assert title and url
        String currentTitle = driver.getTitle();
        String expectedTitle = "Swag Labs";
        Assert.assertEquals(currentTitle, expectedTitle);

        String currentUrl2 = driver.getCurrentUrl();
        String expectedUrl2 = "https://www.saucedemo.com/checkout-step-two.html";
        Assert.assertEquals(currentUrl2, expectedUrl2);

        // Close the browser
        driver.quit();
    }
}

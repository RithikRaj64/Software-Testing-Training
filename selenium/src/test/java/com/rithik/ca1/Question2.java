package com.rithik.ca1;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Question2 {
    public static void main(String[] args) throws InterruptedException {
        // Setting up driver
        WebDriverManager.chromedriver().setup();
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(co);

        String url = "https://www.amazon.com/";
        driver.get(url);

        driver.manage().window().maximize();

        // Search a product
        WebElement srch = driver.findElement(By.id("twotabsearchtextbox"));
        srch.sendKeys("laptop", Keys.ENTER);

        // List
        List<WebElement> li = driver
                .findElements(By.xpath("//h2[@class=\"a-size-mini a-spacing-none a-color-base s-line-clamp-2\"]"));

        // Verify if results are displayed
        Assert.assertNotEquals(li.size(), 0);
        System.out.println("* Relevant Products are displayed");

        System.out.println("* List of 5 Products : ");
        for (int i = 0; i < 5; i++)
            System.out.println((i + 1) + ") " + li.get(i).getText());

        // Price filter
        WebElement pricefil = driver.findElement(By.id("p_36-title"));
        Assert.assertTrue(pricefil.isDisplayed());
        System.out.println("* Price filter is enabled");

        // Brand filter
        WebElement brandfil = driver.findElement(By.id("p_89-title"));
        Assert.assertTrue(brandfil.isDisplayed());
        System.out.println("* Brand filter is enabled");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");

        // Brand filter
        WebElement otherfil = driver.findElement(By.id("filters"));
        Assert.assertTrue(otherfil.isDisplayed());
        System.out.println("* Other filters also enabled");

        // Close the browser
        driver.quit();
    }
}

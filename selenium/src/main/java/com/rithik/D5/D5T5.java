package com.rithik.D5;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class D5T5 {
    public static void main(String[] args) throws InterruptedException {
        // Driver setup
        WebDriverManager.chromedriver().setup();
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(co);

        // URL to open
        String url = "https://www.google.com/";

        // Browser 1 : Apple
        searchAndPrint(driver, url, "Apple");

        // Create new window
        driver.switchTo().newWindow(WindowType.TAB);

        // Browser 2 : Selenium
        searchAndPrint(driver, url, "Selenium");

        // Create new window
        driver.switchTo().newWindow(WindowType.TAB);

        // Browser 3 : Cucumber
        searchAndPrint(driver, url, "Cucumber");

        // Get window handles collectively
        Set<String> handles = driver.getWindowHandles();

        // Print the window handles and nos of tabs
        System.out.println("Window Handles : " + handles);
        System.out.println("No of Tabs : " + handles.size());

        // Close the browser
        driver.quit();

    }

    static void searchAndPrint(WebDriver driver, String url, String query) {
        // Open the URL
        driver.get(url);

        // Search
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys(query, Keys.ENTER);

        // Get window ID and print
        String id = driver.getWindowHandle();
        System.out.println("Window ID : " + id);

        // Get title and print
        String title = driver.getTitle();
        System.out.println("Title : " + title);
    }
}

package com.rithik.D5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class D5T1 {
    public static void main(String[] args) throws InterruptedException {

        // Driver setup
        WebDriverManager.chromedriver().setup();
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(co);

        // URL to open
        String url = "https://demoqa.com/droppable/";

        // Open the URL
        driver.get(url);

        // Maximize
        driver.manage().window().maximize();

        // Create an Actions object
        Actions a = new Actions(driver);

        // Get the draggable and droppable elements
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        // Drag and drop
        a.dragAndDrop(draggable, droppable).build().perform();

        // Drag and drop with clickhold command
        // a.clickAndHold(draggable).release(droppable).build().perform();

        Thread.sleep(3000);

        // Close the browser
        driver.quit();
    }
}

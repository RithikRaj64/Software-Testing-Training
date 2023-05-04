package com.rithik.ca1;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Question3 {
    public static void main(String[] args) throws InterruptedException {
        // Setting up driver
        WebDriverManager.chromedriver().setup();
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(co);

        String url = "https://www.amazon.com/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3F_encoding%3DUTF8%26ref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&";
        driver.get(url);

        driver.manage().window().maximize();


        WebElement em = driver.findElement(By.id("ap_email"));
        em.sendKeys("rithukuza@gmail.com", Keys.ENTER);

        WebElement pw = driver.findElement(By.id("ap_password"));
        pw.sendKeys("rithukuza", Keys.ENTER);

        WebElement clik = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"));
        clik.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.amazon.com/gp/css/homepage.html?ref_=nav_youraccount_btn");
        System.out.println("* Your Account page is displayed");

        WebElement yourOrders = driver
                .findElement(By.xpath("//*[@id=\"a-page\"]/div[2]/div/div[2]/div[1]/a/div/div/div/div[2]/h2"));
        Assert.assertTrue(yourOrders.isDisplayed());
        System.out.println("* Your orders is enabled to check the orders");
    }
}

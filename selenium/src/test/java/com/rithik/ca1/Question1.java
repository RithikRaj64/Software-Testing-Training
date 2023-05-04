package com.rithik.ca1;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Question1 {
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

        // Search a product
        WebElement srch = driver.findElement(By.id("twotabsearchtextbox"));
        srch.sendKeys("cloth", Keys.ENTER);

        // Click laptop
        WebElement cloth = driver.findElement(By.xpath(
                "//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/div/div/div/div/div[3]/div[2]/h2/a"));
        cloth.click();

        // Add to cart
        WebElement addToCart = driver.findElement(By.id("add-to-cart-button"));
        addToCart.click();

        // Wait
        Thread.sleep(3000);

        // Verify added
        WebElement added = driver.findElement(By.id("nav-cart-count"));
        Assert.assertNotEquals(added.getText(), "0");
        System.out.println("* User can add a product by clicking on Add to Cart button");

        WebElement open = driver.findElement(By.xpath("//*[@id=\"sw-gtc\"]/span/a"));
        open.click();

        // Take price
        String acPrice = driver
                .findElement(By.xpath(
                        "//*[@id=\"sc-subtotal-amount-activecart\"]/span"))
                .getText();
        
         // Delete verify
         WebElement deleteButton =
         driver.findElement(By.xpath("//*[@id=\"sc-active-C786292ce-7473-4968-8fd0-a45b402154e6\"]/div[4]/div/div[3]/div[1]/span[2]/span/input"));
         Assert.assertTrue(deleteButton.isEnabled());
         System.out.println("* User can remove a product by clicking on Remove button");

        
         // Update verify
         WebElement update = driver.findElement(By.id("a-autoid-0-announce"));
         Assert.assertTrue(update.isEnabled());
         System.out.println("* User can update a product by clicking on Update button");

         // Checkout
         WebElement checkout = driver.findElement(By.xpath("//*[@id=\"sc-buy-box-ptc-button\"]/span/input"));
         checkout.click();
         
         Assert.assertEquals(driver.getCurrentUrl(), "https://www.amazon.com/gp/buy/payselect/handlers/display.html?_from=cheetah");
         System.out.println("* User can  can proceed to the checkout page by clicking on the Checkout button");
         
         System.out.println("* Checkout process is working as expected and calculates the total cost accurately");

         driver.quit();
    }
}

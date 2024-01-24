package LIDL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class US106OgulcanLogin {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to the Lidl website
        driver.get("https://www.lidl.com/");

        // Verify the homepage URL
        if (driver.getCurrentUrl().equals("https://www.lidl.com/")) {
            System.out.println("Homepage URL verification successful");
        } else {
            System.out.println("Homepage URL verification unsuccessful");
        }

        // Click on the "Login" link
        WebElement loginLink = driver.findElement(By.xpath("//[@id='nav']/div/nav[2]/ul/li[3]/a"));
        loginLink.click();

        // Wait for the username input field to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//[@id='input0']")));

        // Find the username input field and enter the username
        usernameInput.sendKeys("o.erdekli@gmail.com");

        // Wait for the password input field to be visible
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//[@id='input1']")));

        // Find the password input field and enter the password
        passwordInput.sendKeys("Ogulcan2004");

        // Introduce a delay (5 seconds)
        try {
            System.out.println("Waiting for 5 seconds before clicking the 'Sign In' button");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Click the "Sign In" button
        driver.findElement(By.xpath("//[@id='main-content']/div[2]/div/div/form/div/button[5]")).click();

        // Verify login success
        if (driver.getCurrentUrl().equals("https://www.lidl.com/login")) {
            System.out.println("Login successful");
        } else {
            System.out.println("Login unsuccessful. Current URL: " + driver.getCurrentUrl());
        }


    }

}

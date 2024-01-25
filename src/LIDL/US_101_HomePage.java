package LIDL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class US_101_HomePage {
    public static void main(String[] args) {
        //As a website visitor, I want to access the homepage so
        //that I can view the products and services offered by Lidl.

        //1. I should be able to successfully access the homepage.
        //2. I should verify that the page's URL is "https://www.lidl.com"

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.lidl.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();



        WebElement cookiesButton = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        cookiesButton.click();



            String actualURL = driver.getCurrentUrl();
            String expectedURL = "https://www.lidl.com/";



            if (actualURL.equals(expectedURL)) {
                System.out.println("Test Passed: Homepage verified the URL.");

            } else {
                System.out.println("Test Failed:  URL verification failed.");
            }


            driver.quit();
        }
    }







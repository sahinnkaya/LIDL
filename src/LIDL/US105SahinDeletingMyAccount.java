package LIDL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class US105SahinDeletingMyAccount {

    public static void waitMethod(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void cookies(WebDriver driver) {
        WebElement cookiesButton = driver.findElement(By.xpath(" //button[@id='onetrust-accept-btn-handler'] "));
        cookiesButton.click();
    }
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.lidl.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        WebElement signInButton = driver.findElement(By.xpath("//a[@data-test='signIn']"));
        signInButton.click();
        waitMethod(3);
        cookies(driver);

        WebElement closeSelectStore = driver.findElement(By.xpath("//img[@ alt='close-white description']"));
        closeSelectStore.click();

        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
        email.sendKeys("kayasahin94@gmail.com");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("SaKa1234");

        WebElement showButton = driver.findElement(By.xpath("//button[@class='show']"));
        showButton.click();

        WebElement signButton = driver.findElement(By.xpath("//button[@data-test='signInButton']"));
        signButton.click();

        WebElement myAccountButton = driver.findElement(By.xpath("//span[@class='profile-dropdown-button-label ']"));
        myAccountButton.click();

        WebElement myAccountOPT = driver.findElement(By.xpath("//div[@class='name']"));
        myAccountOPT.click();

        WebElement accountManagement = driver.findElement(By.xpath("//a[@href='/profile/account-management']"));
        accountManagement.click();

        WebElement deleteAccount = driver.findElement(By.xpath("//button[@type='submit']"));
        deleteAccount.click();

        // Deletes Account
        // WebElement deleteAccountButton = driver.findElement(By.xpath("//button[@data-test='confirmation-button']"));
        // deleteAccountButton.click();

        // driver.quit();



    }
}

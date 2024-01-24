package LIDL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class US103AliyeUpdateAccount {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        // go to url profile/general
        driver.navigate().to("https://www.lidl.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

//----------------------------------Update account ------------------------------------------
        // I should be able to access the account page by clicking on the "My
        //Account" link in the top right corner of the page.
        WebElement myAccountLinkDropDownList = driver.findElement(By.xpath("//span[@class='profile-dropdown-button-label']"));
        myAccountLinkDropDownList.click();

        //I should be able to update my first and last name by clicking the
        // "Edit Account" button.
        WebElement myAccountLink = driver.findElement(By.xpath("//article[@class='profile-img-detail']"));
        myAccountLink.click();

        //I should verify that the URL of the account page is
        // "https://www.lidl.com/profile/general"
        String expectedURL = "https://www.lidl.com/profile/general";
        String actualURL = driver.getCurrentUrl();
        if(expectedURL.equals(actualURL)){
            System.out.println("url Test PASSED");
        }else{
            System.out.println("FAILED, wrong URL");
        }

        //I should be able to update my first and last name by clicking the
        // "Edit Account" button.
        //I should verify that the updated first and last name are
        // correctly displayed in my profile.
        WebElement firstName = driver.findElement(By.xpath("//input[@value='Tetiana']")); //1
        firstName.sendKeys("i");
        if(firstName.isDisplayed()){
            System.out.println("Firstname update Passed");
        }else{
            System.out.println("Firstname update Failed");
        }
        WebElement lastName = driver.findElement(By.xpath("//input[@value='Khokhlova']"));
        lastName.sendKeys("i");
        if(lastName.isDisplayed()){
            System.out.println("Lastname update Passed");
        }else{
            System.out.println("Lastname update Failed");
        }


        //I should be able to save the updates by clicking the "Save" button
        WebElement saveButton = driver.findElement(By.xpath("//div[@class='row row-reverse profile-save']"));
        saveButton.click();
        //I should receive the message "Profile updated successfully."
        WebElement profileUpdateMessage = driver.findElement(By.xpath("//p[@aria-live='assertive']"));
        if(profileUpdateMessage.isDisplayed()){
            System.out.println("Profile updated successfully - Passed");
        }else{
            System.out.println("Profile updated successfully - Failed");
        }

        // I should be able to see my updated username in the top right corner of the page.
        WebElement updatedUsername = driver.findElement(By.xpath("//h3[@class='title-3']"));
        if(updatedUsername.isDisplayed()){
            System.out.println("Passed ");
        }else{
            System.out.println("Failed ");
        }

        driver.quit();

    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class US102_RegisteringAsAUser {

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

        WebElement joinButton = driver.findElement(By.xpath("//a[@data-test='joinButton']"));
        joinButton.click();

        String expectedUrl = "https://www.lidl.com/register";
        String actualUrl = driver.getCurrentUrl();
        if (expectedUrl.equals(actualUrl)) {
            System.out.println(" The page is correct");
        } else {
            System.out.println(" The page is false");
        }

        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.sendKeys(" Kris");
        WebElement lastName = driver.findElement(By.name("lastName"));
        lastName.sendKeys("Jonson");

        WebElement emailInput = driver.findElement(By.xpath("//input[@name='email']"));
        emailInput.sendKeys("porler3@gmail.com");
        WebElement confirmEmail = driver.findElement(By.xpath("//input[@name='confirm_email']"));
        confirmEmail.sendKeys("porler3@gmail.com");

        String emailInputValue = emailInput.getAttribute("value");
        String confirmEmailValue = confirmEmail.getAttribute("value");

        if (driver.getPageSource().contains("This email is already registered")) {
            System.out.println("This email is already registered. Want to sign in or recover your password? ");
        } else {
            if (!emailInputValue.equals(confirmEmailValue)) {
                System.out.println(" Emails don't match");
            } else {
                System.out.println(" Email registration is successful ");
            }

            WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
            password.sendKeys("Raq3727@");

            WebElement phoneNumber = driver.findElement(By.xpath("//input[@name ='phone']"));
            phoneNumber.sendKeys("7822194663");


            if (driver.getPageSource().contains("This phone number is already being used, please use another one")) {
                System.out.println("This phone number is already being used, please use another one");
            } else {
                System.out.println("Phone is correct  ");
            }


            WebElement zipCodeInput = driver.findElement(By.xpath("//input[@name='zip']"));
            zipCodeInput.sendKeys("30032");
            String enteredZipCode = zipCodeInput.getAttribute("value");

            if (enteredZipCode.length() == 5)
                System.out.println("Zip code is valid ");
            else
                System.out.println("Enter a valid zip code ");


            WebElement birthdayInput = driver.findElement(By.xpath("//input[@name='birthday']"));
            birthdayInput.sendKeys("11/02/1987");
            String enterBirthday = birthdayInput.getAttribute("value");

            LocalDate birthdayDate = LocalDate.parse(enterBirthday, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
            LocalDate currentDate = LocalDate.now();
            Duration ageDifference = Duration.between(birthdayDate.atStartOfDay(), currentDate.atStartOfDay());

            if (ageDifference.toDays() < 4745 || ageDifference.toDays() > 36252)
                System.out.println(" You must be at least 13 years old and Age must be less than 100");
            else {
                System.out.println(" Age is valid");
            }

            //   WebElement confirm = driver.findElement(By.cssSelector(".spinnie-container"));
            //    confirm.click();


        }
    }
}











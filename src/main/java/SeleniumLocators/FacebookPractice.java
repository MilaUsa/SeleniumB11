package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.webaudio.WebAudio;

public class FacebookPractice {
    public static void main(String[] args) throws InterruptedException {
        /*
    Facebook Sign up:
Scenario:
Open a Chrome browser.
Navigate to "http://www.fb.com"
Verify that the page is redirected to "http://www.facebook.com", by getting the current URL. (use Assertion)
Verify that there is a "Create an account" section on the page.
Fill in the text boxes: First Name, Surname, Mobile Number or email address, "Re-enter mobile number", new password.
Update the date of birth in the drop-down.
Select gender.
Click on "Create an account".
Verify that the account is not created.
     */
        WebDriver driver= new ChromeDriver();
        driver.navigate().to("http://www.facebook.com");
        System.out.println(driver.getCurrentUrl());
        driver.manage().window().maximize();
        String actualUrl= driver.getCurrentUrl();
        String expectedUrl="http://www.facebook.com/";
        if(actualUrl.equals(expectedUrl)){
            System.out.println("The website is correct");
        }else{
            System.out.println("The website is wrong");
        }
        Thread.sleep(1000);

        WebElement createAButton=driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));

        createAButton.click();
        boolean validationButton=createAButton.isDisplayed();
        boolean expectedValidationButton=true;
        if(validationButton==expectedValidationButton){
            System.out.println("Button is displayed");
        }else{
            System.out.println("Button is not displayed");
        }




        Thread.sleep(1000);
        WebElement firstName=driver.findElement(By.name("firstname"));
        firstName.sendKeys("Milana");

        WebElement lastName=driver.findElement(By.name("lastname"));
        lastName.sendKeys("Usekeeva");

        WebElement email=driver.findElement(By.name("reg_email__"));
        email.sendKeys("usekkeemm@gmail.com");

        WebElement email2=driver.findElement(By.name("//input[@data-type='text']"));
        email2.sendKeys("mmmudhukeemm@gmail.com");

        WebElement password=driver.findElement(By.xpath("//input[@data-type='password']"));
        password.sendKeys("Mila55555");

        WebElement month=driver.findElement(By.name("birthday_month"));
        month.sendKeys("March");
        WebElement day=driver.findElement(By.name("birthday_day"));
        day.sendKeys("21");
        WebElement year=driver.findElement(By.name("birthday_year"));
        year.sendKeys("2000");




    }
}

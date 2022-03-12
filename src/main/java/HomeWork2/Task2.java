package HomeWork2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {
    public static void main(String[] args) {
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.nopcommerce.com/");
        WebElement register=driver.findElement(By.xpath("//a[@class='ico-register']"));
        register.click();

        WebElement genderClick=driver.findElement(By.xpath("//input[@id='gender-female']"));
        genderClick.click();
        WebElement firstName=driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstName.sendKeys("Milana");

        WebElement lastName=driver.findElement(By.xpath("//input[@id='LastName']"));
        lastName.sendKeys("Usekeeva");

        WebElement day=driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
        day.click();
        day.sendKeys("9");
        day.submit();

        WebElement month=driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));
        month.click();
        month.sendKeys("March");
        month.submit();

       WebElement year=driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));
        year.click();
        year.sendKeys("2000");
        year.submit();

        WebElement email2=driver.findElement(By.xpath("//input[@name='Email']"));
        email2.sendKeys("mmuummuumu@gmail.com");
        WebElement companyName=driver.findElement(By.xpath("//input[@name='Company']"));
        companyName.sendKeys("Star");
        WebElement newsteller=driver.findElement(By.xpath("//input[@type='checkbox']"));
        newsteller.click();


        WebElement password=driver.findElement(By.xpath("//input[@name='Password']"));
        password.sendKeys("Mila55555");
        WebElement confirmPassword=driver.findElement(By.xpath("//input[@name='ConfirmPassword']"));
        confirmPassword.sendKeys("Mila55555");
        WebElement registerButton=driver.findElement(By.xpath("//button[@name='register-button']"));
        registerButton.click();

        WebElement registered=driver.findElement(By.xpath("//div[@class='result']"));
        System.out.println(registered.getText());
        String actualResalt=registered.getText();
        String expectedResult="Your registration completed";
        WebElement clikContinue=driver.findElement(By.xpath("//a[@class='button-1 register-continue-button']"));
        if(actualResalt.equals(expectedResult)){
            clikContinue.click();
            System.out.println("Passed");
        }else{
            System.out.println("failed");
        }






    }
}

package HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWorkTask3 {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement uName=driver.findElement(By.xpath("//input[@id='user-name']"));
        uName.sendKeys("Java");
        WebElement pWord=driver.findElement(By.xpath("//input[@id='password']"));
        pWord.sendKeys("Selenium");
        WebElement login=driver.findElement(By.xpath("//input[@id='login-button']"));
        login.click();
        WebElement loginButton=driver.findElement(By.xpath("//h3"));
        System.out.println(loginButton.getText());
        String expectedValidation="Epic sadface: Username and password do not match any user in this service";
        String actualValidation=loginButton.getText();
        if(expectedValidation.equals(actualValidation)) {
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }

        






    }
}

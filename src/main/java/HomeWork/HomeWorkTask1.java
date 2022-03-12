package HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWorkTask1 {
    public static void main(String[] args) {
        WebDriver driver= new ChromeDriver();
        //What is webDriver?
        //It is a connection between webpage and your system.
        //I need webdriver to manipulate the webpage elements.

        //First step of starting automation should be reading the test case(task)
        //step by step implement the requirements.
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/text-box");
        WebElement firstName= driver.findElement(By.xpath("//input"));
        firstName.sendKeys("Milana");
        WebElement email= driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys("umilana@gmail.com");
        WebElement curAddress=driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        curAddress.sendKeys("5441 N East River Road Chicago IL 60656");
        WebElement perAddress=driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        perAddress.sendKeys("5441 N East River Road Chicago IL 60656");




        WebElement button= driver.findElement(By.xpath("//button[@id='submit']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        button.click();


        WebElement nameValidation=driver.findElement(By.xpath("//p[@id='name']"));
        System.out.println(nameValidation.getText());
        String expectedValidation="Name:Milana";
        String actualValidation=nameValidation.getText();
        if(expectedValidation.equals(actualValidation)) {
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }





    }
}

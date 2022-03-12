package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("file:///Users/milanausekeeva/Downloads/Techtorial%20(2).html");
        WebElement header= driver.findElement(By.id("techtorial1"));
       String actualText= header.getText();
       String expectedText="Techtorial Academy";
       if(actualText.equals(expectedText)){
           System.out.println("passed");
       }else{
           System.out.println("failed");
       }
       WebElement paragraph= driver.findElement(By.id("details2"));
        System.out.println(paragraph.getText());
        if(paragraph.getText().equals("To create your account, \n" +
                "        we'll need some basic information about you. This information will be \n" +
                "        used to send reservation confirmation emails, mail tickets when needed \n" +
                "        and contact you if your travel arrangements change. Please fill in the \n" +
                "        form completely.")){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }
        WebElement tools=driver.findElement(By.className("group_checkbox"));
        System.out.println(tools.getText());

        //Locater Name
        WebElement firstName= driver.findElement(By.name("firstName"));
       firstName.sendKeys("Milana");
       WebElement lastName= driver.findElement(By.name("lastName"));
       lastName.sendKeys("Usekeeva");
       WebElement phoneNumber = driver.findElement(By.name("phone"));
       phoneNumber.sendKeys("9209291121");
       WebElement email=driver.findElement(By.name("userName"));
       email.sendKeys("Usekeevam@gmail.com");

       //Click
        WebElement javaBox=driver.findElement(By.id("cond1"));
        javaBox.click();
        System.out.println(javaBox.isDisplayed());// true
        System.out.println(javaBox.isSelected());
        WebElement testNGBox=driver.findElement(By.id("cond3"));
        testNGBox.click();
        System.out.println(testNGBox.isDisplayed());// true
        System.out.println(testNGBox.isSelected());
        WebElement CucumberBox=driver.findElement(By.id("cond4"));
        CucumberBox.click();
        System.out.println(CucumberBox.isDisplayed());// true
        System.out.println(CucumberBox.isSelected());

    }
}

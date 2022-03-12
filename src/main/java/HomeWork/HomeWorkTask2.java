package HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWorkTask2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/radio-button");

        // WebElement radioButton=driver.findElement(By.xpath("//span[contains(text(),'Radio Button')]"));
        // radioButton.click();
        WebElement yesButton = driver.findElement(By.id("yesRadio"));
        //yesButton.click();
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", yesButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click(true);", yesButton);

        WebElement readyYesButton = driver.findElement(By.xpath("//p[@class='mt-3']"));
        String actualResult = readyYesButton.getText();
        System.out.println(actualResult);
        String expectedValidation = "You have selected Yes";
        if (expectedValidation.equals(actualResult)) {
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }


        WebElement impressiveButton = driver.findElement(By.xpath("//input[@id='impressiveRadio']"));
        //impressiveButton.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click(true);", impressiveButton);

        WebElement readyImpressiveButton = driver.findElement(By.xpath("//p[@class='mt-3']"));
        String actualResult1=readyImpressiveButton.getText();
        System.out.println(actualResult1);
        String expectResult="You have selected Impressive";
        if(actualResult1.equals(expectResult)){
            System.out.println("Passed");
       }else{
            System.out.println("Failed");
        }

    }
}










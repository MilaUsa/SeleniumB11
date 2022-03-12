package Waits;

import Utils.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicitlyWaitPractice {
    @Test
    public void validateWait(){
        WebDriver driver= DriverHelper.getDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement startButton= driver.findElement(By.xpath("//button[.='Start']"));
        startButton.click();
//        WebElement headerText= driver.findElement(By.xpath("//h4[.='Hello World!']"));
//        String actualtext= headerText.getText().trim();
//        String expectedText="Hello World!";
//        Assert.assertEquals(actualtext,expectedText);
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement text=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h4[.='Hello World!']"))));
        Assert.assertEquals(text.getText().trim(),"Hello World!");
    }
}

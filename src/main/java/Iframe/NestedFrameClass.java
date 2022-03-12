package Iframe;

import Utils.Browserutils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NestedFrameClass {
    @Test
    public void nestedFrameValidation(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new  ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.manage().window().maximize();
        driver.switchTo().frame(0);
        WebElement middleFrame= driver.findElement(By.name("frame-middle"));
        driver.switchTo().frame(middleFrame);
        WebElement textBox= driver.findElement(By.xpath("//div[@id='content']"));
        String actualName= Browserutils.getTextMethod(textBox);
        String expectedName="MIDDLE";
        Assert.assertEquals(actualName,expectedName);
       driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-left");
        WebElement leftFrame= driver.findElement(By.xpath("//body[contains(text(),'LEFT']"));
        String actualText=leftFrame.getText().trim();
        String expectedtext="LEFT";
        Assert.assertEquals(actualText,expectedtext);
//        driver.switchTo().parentFrame();
//        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        WebElement bottomFrame= driver.findElement(By.xpath("//body[contains(text),'BOTTOM']"));
        String actualText1=bottomFrame.getText().trim();
        String expectedtext1="BOTTOM";
        Assert.assertEquals(actualText1,expectedtext1);





    }
}

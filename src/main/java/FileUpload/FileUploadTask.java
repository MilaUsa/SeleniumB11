package FileUpload;

import Utils.Browserutils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTask {
    @Test
    public void validateFileUploadTask() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demo.guru99.com/test/upload/");
        driver.manage().window().maximize();
       WebElement chooseFile = driver.findElement(By.id("uploadfile_0"));
       chooseFile.sendKeys("/Users/milanausekeeva/Desktop/usa.png");
       WebElement acceptbox = driver.findElement(By.xpath("//input[@id='terms']"));
       acceptbox.click();
        Assert.assertTrue(acceptbox.isSelected());
        WebElement submitbox = driver.findElement(By.xpath("//button[@id='submitbutton']"));
        submitbox.click();
        WebElement message=driver.findElement(By.xpath("//h3"));
        String actualMessage=Browserutils.getTextMethod(message);
        System.out.println(actualMessage);
        String expectedMessage="";
        Assert.assertEquals(actualMessage,expectedMessage);


    }
}

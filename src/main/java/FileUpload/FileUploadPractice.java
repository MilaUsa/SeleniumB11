package FileUpload;

import Utils.Browserutils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadPractice {
    @Test
    public void validateFileUpload() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();
        WebElement chooseFile=driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys("/Users/milanausekeeva/Desktop/usa.png");
        WebElement uploadbutton= driver.findElement(By.id("file-submit"));
        uploadbutton.click();
        WebElement message1= driver.findElement(By.xpath("//h3"));
        String actualMessage= Browserutils.getTextMethod(message1);
        String expectedMessage="File Uploaded!";
        Assert.assertEquals(actualMessage,expectedMessage);
        Thread.sleep(2000);
        WebElement message2= driver.findElement(By.id("uploaded-files"));
        String actualMessage2= Browserutils.getTextMethod(message2);
        String expectedMessage2="usa.png";
        Assert.assertEquals(actualMessage2,expectedMessage2);

    }
}

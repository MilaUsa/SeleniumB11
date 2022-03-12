package Alert;

import Utils.Browserutils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertIntro {
    @Test
    public void JSBAsicAlertTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        WebElement clickJSalert = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        clickJSalert.click();
//     WebElement clickJSalertText= driver.findElement(By.xpath("//h3"));
//     System.out.println(clickJSalertText.getText());
        Alert alert = driver.switchTo().alert();
        String actualtext = alert.getText();
        String expectedText = "I am a JS Alert";
        Assert.assertEquals(actualtext, expectedText);
        alert.accept();
        WebElement message = driver.findElement(By.xpath("//p[@id='result']"));
        String actualMessage = Browserutils.getTextMethod(message);
        String expectedMessage = "You successfully clicked an alert";
        Assert.assertEquals(actualMessage, expectedMessage);

    }

    @Test
    public void JSBAAlertdissmisMethods() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        WebElement JSalert= driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        JSalert.click();
        Alert alert = driver.switchTo().alert();
        String actualtext = alert.getText();
        String expectedText = "I am a JS Confirm";
        Assert.assertEquals(actualtext, expectedText);
        alert.dismiss();
        WebElement resulttest= driver.findElement(By.xpath("//p[.='You clicked: Cancel']"));

        String actualResult=Browserutils.getTextMethod(resulttest);
        String expectedResult="You clicked: Cancel";
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test
    public void JSBAAlertdissmisMethods3() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        WebElement JSalert3= driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        JSalert3.click();

       Alert alert = driver.switchTo().alert();
       alert.sendKeys("Mila");
       alert.accept();
       WebElement message= driver.findElement(By.xpath("//p[@id='result']"));
        String actualtext = Browserutils.getTextMethod(message);
        String expectedText = "You entered: Mila";
        Assert.assertEquals(actualtext, expectedText);


    }
}
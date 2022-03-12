package WindowHandle;

import Utils.Browserutils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultiPlyWindowHandling {
    @Test
    public void Practice() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        driver.manage().window().maximize();
        WebElement newTap=driver.findElement(By.id("newTabsBtn"));
        newTap.click();
        Browserutils.switchMultipleWinows(driver,"Basic Control");
        WebElement fName=driver.findElement(By.id("firstName"));
        fName.sendKeys("Milana");
        WebElement LName=driver.findElement(By.id("lastName"));
        LName.sendKeys("Usekeeva");
        WebElement email=driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("fdggfgfh@gmail.com");
        WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("fdsdgfd233");
        WebElement register=driver.findElement(By.xpath("//button[.='Register']"));
        register.click();
//        Browserutils.switchMultipleWinows(driver,"AlertsDemo");
//        WebElement clickmeBox= driver.findElement(By.xpath("//button[.='Click me']"));
//        clickmeBox.click();



        WebElement actualRegister= driver.findElement(By.xpath("//label[.='Registration is Successful']"));
        String expectedRegister="Registration is Successful";
        Assert.assertEquals(actualRegister.getText(),expectedRegister);

        Browserutils.switchMultipleWinows(driver,"AlertsDemo");
        WebElement clickmeBox= driver.findElement(By.xpath("//button[.='Click me']"));
       clickmeBox.click();
        driver.quit();




    }
}
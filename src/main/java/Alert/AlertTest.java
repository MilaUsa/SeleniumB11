package Alert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTest {
    /*
     */
    @Test
    public void JSAlert() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://sweetalert.js.org");
        driver.manage().window().maximize();
        WebElement previewButton = driver.findElement(By.xpath("//h5[contains(text(),'Normal alert')]//..//button[@class='preview']"));
        previewButton.click();
        Alert alert = driver.switchTo().alert();
        String actualtext = alert.getText();
        String expectedtext = "Oops, something went wrong!";
        Assert.assertEquals(actualtext, expectedtext);
    }

    @Test
    public void TrialForAlertHandleHTMLPopup() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://sweetalert.js.org");
        driver.manage().window().maximize();

        WebElement prevButton = driver.findElement(By.xpath("//h5[contains(text(),'SweetAlert')]//..//button[@class='preview']"));
        prevButton.click();
        Alert alert=driver.switchTo().alert();
        String actualtext = alert.getText();
        String expectedText = "Oops, something went wrong!";
        Assert.assertEquals(actualtext, expectedText);
        alert.accept();
    }

    @Test
    public void HTMLPopup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://sweetalert.js.org");
        driver.manage().window().maximize();
        WebElement prevButton = driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        prevButton.click();
        Thread.sleep(2000);
        WebElement text=driver.findElement(By.xpath("//div[.='Something went wrong!']"));
        System.out.println(text.getText());

        String actualtext=text.getText();
        String expectedText = "Something went wrong!";
        Assert.assertEquals(actualtext, expectedText);
        WebElement okButton= driver.findElement(By.xpath("//button[.='OK']"));
        okButton.click();


    }
}
package Iframe;

import Utils.Browserutils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IframeTask {
    private Browserutils BrowserUtils;

    @Test
    public void iframeTask(){
        /*
TASK:
    1)Navigate to the website "https://skpatro.github.io/demo/iframes/"
    2)Click Pavilion and click selenium-java and validate the header
    3)Go back to mainPage and click category1
    4)from new webpage validate the title is ending with "qavalidation"
    5)Go back to mainppage and click Category3
    6)validate the new url is equal to "https://qavalidation.com/category/softwaretesting/"
 */
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://skpatro.github.io/demo/iframes/");
        driver.manage().window().maximize();

        WebElement Pavilion= driver.findElement(By.xpath("//a[.='Pavilion']"));
        Pavilion.click();
        Browserutils.switchByTitle(driver,"Home - qavalidation");
        WebElement selenium=driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium']//.."));
        Actions actions=new Actions(driver);
        actions.moveToElement(selenium).perform();
//        driver.switchTo().frame();

        WebElement seleniumJava=driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium-Java']//.."));
        actions.click(seleniumJava).perform();
        WebElement header= driver.findElement(By.tagName("h1"));
        String actualheader=Browserutils.getTextMethod(header);
        String expectedheader="Selenium-Java Tutorial – Basic to Advance";
        Assert.assertEquals(actualheader,expectedheader);
        Browserutils.switchMultipleWinows(driver,"iframes");
        driver.switchTo().frame("Frame1");
        WebElement catecory1= driver.findElement(By.xpath("//a[.='Category1']"));
        catecory1.click();
        Browserutils.switchByTitle(driver,"qavalidation");
       Assert.assertTrue(driver.getTitle().trim().endsWith("qavalidation"));
        Browserutils.switchMultipleWinows(driver,"iframes");
       driver.switchTo().frame("Frame2");
       WebElement category3= driver.findElement(By.xpath("//a[.='Category3']"));
       category3.click();
       Browserutils.switchByTitle(driver,"SoftwareTesting Archives");
        Assert.assertTrue(driver.getCurrentUrl().equals("https://qavalidation.com/category/softwaretesting/"));

//
    }
}

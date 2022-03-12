package JavaScriptExecuter;

import Utils.Browserutils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScriptMethods {
    @Test
    public void titleMethod(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://www.techtorialacademy.com");
        driver.manage().window().maximize();
        driver.getTitle();

//        JavascriptExecutor javascriptExecutor=(JavascriptExecutor) driver;
//        String title=javascriptExecutor.executeScript("return document.title").toString();
//        System.out.println(title+"from javaScript");
        String actualTitle= Browserutils.GetTitleWithJS(driver);
        String expectetTitle="Home Page - Techtorial";
        Assert.assertEquals(actualTitle,expectetTitle);

    }
    @Test
    public void clickWithJS() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        WebElement browserCourse = driver.findElement(By.xpath("//a[.='Browse Course']"));
//        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
//       javascriptExecutor.executeScript("arguments[0].click()", browserCourse);
        Browserutils.ClickWithJS(driver,browserCourse);


    }
    @Test
    public  void ClickWithJSPractice(){
        //click the student login
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        WebElement loginStudentButton = driver.findElement(By.xpath("//div[@class='navigation hidden-xs']//a[.='Student login']"));
        Browserutils.ClickWithJS(driver,loginStudentButton);
    }
    @Test
    public void ScrollingIntoView(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        WebElement copyright= driver.findElement(By.xpath("//p[contains(text(),'© Copyrights')]"));
        JavascriptExecutor js=(JavascriptExecutor)driver;
//        js.executeScript("arguments[0].scrollIntoView(true)",copyright);

        //Task1:
        WebElement broowsC= driver.findElement(By.xpath("//a[contains(text(),'Browse Course')]"));
        js.executeScript("arguments[0].click()",broowsC);
        WebElement getstartedButton= driver.findElement(By.xpath("//h4[contains(text(),'On-Campus Course')]//..//a[.='Get Started']"));
       // js.executeScript("argument[0].scrollIntoView(true).",getstartedButton);
        Browserutils.ScrollingWith(driver,getstartedButton);
        Browserutils.ClickWithJS(driver,getstartedButton);






    }
    @Test
    public void ScroolWithXandYCordinantTest(){
        //This is interview question(Point Class)
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        WebElement copyright= driver.findElement(By.xpath("//p[contains(text(),'© Copyrights')]"));
//
        Browserutils.ScrollWithXandYCord(driver,copyright);
    }
}

package Iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IframePractice {
    @Test
    public void iframetest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.manage().window().maximize();
        driver.switchTo().frame("mce_0_ifr");
        WebElement text= driver.findElement(By.xpath("//p[.='Your content goes here.']"));
        text.clear();
        text.sendKeys("I love Selenium");
        driver.switchTo().parentFrame();

        WebElement headerText= driver.findElement(By.xpath("//h3"));
        System.out.println(headerText.getText());
        String actualText=headerText.getText();
        String  expectedText="An iFrame containing the TinyMCE WYSIWYG Editor";
        Assert.assertEquals(actualText,expectedText);



    }

}

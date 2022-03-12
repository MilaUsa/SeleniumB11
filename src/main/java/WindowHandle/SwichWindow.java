package WindowHandle;

import Utils.Browserutils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class SwichWindow {
    @Test
    public void practice1() {

        // it is failing because my driver is still pointing
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement clickHere = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHere.click();
        WebElement text = driver.findElement(By.xpath("//h3[.='New Window']"));
        System.out.println(text.getText());

    }

    @Test
    public void switchingWindow() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();
        System.out.println(driver.getWindowHandle());
        WebElement clickHere = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHere.click();
        System.out.println(driver.getWindowHandles());
        // WebElement text= driver.findElement(By.xpath("//h3[.='New Window']"));
        String mainPageId = driver.getWindowHandle();//123
        Set<String> allPagesId = driver.getWindowHandles();//123,563

        for (String id : allPagesId) {
            System.out.println(id);
            if (id.equals(mainPageId)) {
                driver.switchTo().window(id);
            }
        }
        WebElement header = driver.findElement(By.xpath("//h3[.='New Window']"));
        System.out.println(header.getText());
        String actualText = header.getText();
        String expectedText = "New Window";
        Assert.assertEquals(actualText, expectedText);


    }

    @Test
    public void switchingWindowPractice() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        driver.manage().window().maximize();
        String MainPageId = driver.getWindowHandle();

        WebElement tapButton = driver.findElement(By.id("newTabBtn"));
        tapButton.click();
        Browserutils.SwitchOnlyForTwoTabs(driver,MainPageId);
//        Set<String> allPagesId = driver.getWindowHandles();
//        for (String id : allPagesId) {
//            if(!id.equals(allPagesId)) {
//                driver.switchTo().window(id);
//            }
//        }
        WebElement header = driver.findElement(By.xpath("//h1[contains(text(),'Alert')]"));
        String actualHeader = Browserutils.getTextMethod(header);
        String expectedHeader = "AlertsDemo";
        Assert.assertEquals(actualHeader, expectedHeader);
        WebElement click= driver.findElement(By.id("alertBox"));
        click.click();
    }
}

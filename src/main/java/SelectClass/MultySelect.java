package SelectClass;

import Utils.Browserutils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultySelect {
    @Test
    public void multipleselectAndFirstSelectPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("file:///Users/milanausekeeva/Downloads/Techtorial%20(2).html");
        driver.manage().window().maximize();
        WebElement multiSelectBox=driver.findElement(By.xpath("//select[@class='select']"));
        Browserutils.selectBy(multiSelectBox,"Two","text");
        Browserutils.selectBy(multiSelectBox,"3","index");
        Browserutils.selectBy(multiSelectBox,"1","value");
       // Browserutils.selectBy(multiSelectBox,"three","text");

        Select select = new Select(multiSelectBox);
        Thread.sleep(2000);
        select.selectByIndex(3);
        //select.deselectAll();

        WebElement countryList= driver.findElement(By.name("country"));
        Select country=new Select(countryList);
        String actualFirstSELECTEDOPTION=Browserutils.getTextMethod(country.getFirstSelectedOption());
//        String actualFirstSELECTEDOPTION=country.getFirstSelectedOption().getText().trim();
        String expectedFirstSelectedOption="UNITED STATES";
        Assert.assertEquals(actualFirstSELECTEDOPTION,expectedFirstSelectedOption);


    }
}

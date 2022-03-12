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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectClassWithExample {
    @Test
    public void ValidationTripButton(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement oneWayButton=driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWayButton.click();
        Assert.assertTrue(oneWayButton.isDisplayed());
        Assert.assertTrue(oneWayButton.isSelected());

        WebElement roundTripButton=driver.findElement(By.xpath("//input[@value='roundtrip']"));
        roundTripButton.click();
        Assert.assertFalse(roundTripButton.isDisplayed());
        Assert.assertTrue(roundTripButton.isSelected());
    }
    @Test
    public void SelectMethods() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement oneWayButton=driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWayButton.click();
        WebElement passengerCount= driver.findElement(By.name("passCount"));
        Select psnger=new Select(passengerCount);
        psnger.selectByIndex(1);
        WebElement departfrom= driver.findElement(By.name("fromPort"));
        Select depart=new Select(departfrom);
        depart.selectByValue("Sydney");
        WebElement month= driver.findElement(By.name("fromMonth"));
        Select mnth=new Select(month);
        mnth.selectByVisibleText("April");
        WebElement day= driver.findElement(By.name("fromDay"));
        Select d=new Select(day);
        d.selectByIndex(3);
        WebElement arriving= driver.findElement(By.name("toPort"));
       Select arvng= new Select(arriving);
       arvng.selectByIndex(2);
        WebElement returningMonth= driver.findElement(By.name("toMonth"));
        Select rtMonth=new Select(returningMonth);
        rtMonth.selectByVisibleText("August");
        WebElement returningDay= driver.findElement(By.name("toDay"));
        Select rtDay=new Select(returningDay);
        rtDay.selectByValue("4");
        driver.manage().window().maximize();
        WebElement bussinesClass= driver.findElement(By.xpath("//input[@value='Business']"));
      bussinesClass.click();
      driver.manage().window().maximize();
        Thread.sleep(1000);
        WebElement airline= driver.findElement(By.xpath("//select[@name='airline']"));
      Select arln= new Select(airline);
        arln.selectByIndex(3);
        WebElement continueButton= driver.findElement(By.name("findFlights"));
        continueButton.click();

    }
    @Test
    public void SelectMetods2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement oneWayButton=driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWayButton.click();

        WebElement passengerCount= driver.findElement(By.name("passCount"));
        Browserutils.selectBy(passengerCount,"2","value");

        WebElement departfrom= driver.findElement(By.name("fromPort"));
        Browserutils.selectBy(departfrom,"Paris","text");
//        Select depart=new Select(departfrom);
//        depart.selectByValue("Sydney");

        WebElement month= driver.findElement(By.name("fromMonth"));
        Browserutils.selectBy(month,"April","text");
//        Select mnth=new Select(month);
//        mnth.selectByVisibleText("April");
        WebElement day= driver.findElement(By.name("fromDay"));
        Browserutils.selectBy(day,"3","index");
//        Select d=new Select(day);
//        d.selectByIndex(3);
        WebElement arriving= driver.findElement(By.name("toPort"));
        Browserutils.selectBy(arriving,"2","index");
//        Select arvng= new Select(arriving);
//        arvng.selectByIndex(2);
        WebElement returningMonth= driver.findElement(By.name("toMonth"));
        Browserutils.selectBy(returningMonth,"August","text");
//        Select rtMonth=new Select(returningMonth);
//        rtMonth.selectByVisibleText("August");
        WebElement returningDay= driver.findElement(By.name("toDay"));
        Browserutils.selectBy(returningDay,"4","value");
//        Select rtDay=new Select(returningDay);
//        rtDay.selectByValue("4");
//        driver.manage().window().maximize();
//        WebElement bussinesClass= driver.findElement(By.xpath("//input[@value='Business']"));
//        bussinesClass.click();
//        driver.manage().window().maximize();
//        Thread.sleep(1000);
//        WebElement airline= driver.findElement(By.xpath("//select[@name='airline']"));
//        Select arln= new Select(airline);
//        arln.selectByIndex(3);
//        WebElement continueButton= driver.findElement(By.name("findFlights"));
//        continueButton.click();
        WebElement Services = driver.findElement(By.xpath("//input[@value='First']"));
        Services.click();
        WebElement airlines = driver.findElement(By.name("airline"));
        Select airline = new Select(airlines);
        List<WebElement> allairlines = airline.getOptions();
        List<String> actualAirlines = Arrays.asList("No Preference", "Blue Skies Airlines", "Unified Airlines", "Pangea Airlines");
        List<String> expectedairlines = new ArrayList<>();
        for (WebElement line : allairlines) {
            expectedairlines.add(line.getText().trim());
        }
        Assert.assertEquals(actualAirlines, expectedairlines);
        WebElement continueButton = driver.findElement(By.name("findFlights"));
        continueButton.click();
        WebElement message = driver.findElement(By.xpath("//font[@face='Arial, Helvetica, sans-serif']//font[@size='4']"));
        String actual = message.getText().trim();
        String expected = "After flight finder - No Seats Available";
        Assert.assertEquals(actual, expected);


    }
}

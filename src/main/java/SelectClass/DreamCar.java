package SelectClass;

import Utils.Browserutils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DreamCar {
    @Test public void CarName(){
        //first go to the ""
        //choose the options you want for your car
        //click search button
        //Validate the header
        //and validate all the subheaders contains the name of the cars you are looking for
        //.clear--> sendkey

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.cars.com/");
        driver.manage().window().maximize();
        WebElement carBox= driver.findElement(By.id("make-model-search-stocktype"));
        Browserutils.selectBy(carBox,"New cars","text");
       WebElement carType= driver.findElement(By.name("makes[]"));
        Browserutils.selectBy(carType,"lexus","value");
        WebElement carModel= driver.findElement(By.xpath("//select[@name='models[]']"));
        Browserutils.selectBy(carModel,"LS 500","text");
        WebElement search= driver.findElement(By.xpath("//button[@type='submit' and @data-searchtype='make']"));
        search.click();
        WebElement header= driver.findElement(By.xpath("//h1"));
        String actualHeader= header.getText();
        String expectedHeader="New Lexus LS 500 for sale";
        Assert.assertEquals(actualHeader,expectedHeader);

        List<WebElement> cartypes=driver.findElements(By.xpath("//h2[@class='title']"));
        for(WebElement foundCars:cartypes){
            boolean contains= foundCars.getText().trim().contains("Lexus LS 500");
            Assert.assertTrue(contains);
//           if(foundCars.getText().contains("Lexus LS 500")){
//               System.out.println(foundCars.getText());
//           }
        }





    }
}

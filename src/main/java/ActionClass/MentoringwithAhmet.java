package ActionClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MentoringwithAhmet {
    //go to the edureka.com
    //hover Over categories/browser
   // and hoverOver CyberSecurity
    // validate the 3


    @Test
    public void practiceHoverOver(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.edureka.co");
        driver.manage().window().maximize();
        WebElement browseButton = driver.findElement(By.xpath("//a[@class='dropdown-toggle hidden-xs " +
                "hidden-sm ga_browse_top_cat']//small[.='Browse']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(browseButton).perform();
        WebElement dataScience= driver.findElement(By.xpath("//a[@class='dropdown-toggle ga_top_category'" +
                " and .='Data Science']"));
        actions.moveToElement(dataScience).perform();
        WebElement cyberSecurity= driver.findElement(By.xpath("//a[@class='dropdown-toggle ga_top_category" +
                "' and .='Cyber Security']"));
        actions.moveToElement(cyberSecurity).perform();
      List<WebElement> threeElements=driver.findElements(By.xpath("//a[@class='ga_top_categories_course' and " +
              " @data-categoryname='Cyber Security']"));

      Actions action=new Actions(driver);
      for(int i=0; i<threeElements.size();i++){
          action.moveToElement(threeElements.get(i)).perform();
          System.out.println(threeElements.get(i).getText());
          boolean actualvalitation= threeElements.get(i).isDisplayed();
          Assert.assertTrue(actualvalitation);

      }




    }
    @Test
    public void PlanBpractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/fx/expand");
        driver.manage().window().maximize();
        List<WebElement> pictures=driver.findElements(By.xpath("//div[@role='listitem']"));
        List<WebElement> allPrices=driver.findElements(By.xpath("//div[@class='product-description']//p"));
        List<Double> prices=new ArrayList<>();
        Actions actions=new Actions(driver);
        for(int i = 0; i<pictures.size();i++){
            Thread.sleep(1000);
            actions.moveToElement(pictures.get(i)).perform();
            prices.add(Double.parseDouble(allPrices.get(i).getText().trim().replace("$","")));

        }
        Collections.sort(prices);
        System.out.println(prices);
        Collections.reverse(prices);
        System.out.println(prices);
    }

}





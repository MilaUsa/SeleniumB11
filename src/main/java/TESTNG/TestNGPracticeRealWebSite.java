package TESTNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestNGPracticeRealWebSite {
    @Test
    public void validateWebsite(){
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        String actualWebsite= driver.getCurrentUrl();
        String expectWebsite="https://demo.opencart.com/admin/";
        Assert.assertEquals(actualWebsite,expectWebsite);
        WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
    }
    @Test
    public void validationDisplayed(){
        WebDriver driver= new ChromeDriver();

        driver.get("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();

        String expectWebsite="https://demo.opencart.com/admin/";

        WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
       WebElement catalogBar=driver.findElement(By.id("menu-catalog"));
//        boolean actualCatalog=catalogBar.isDisplayed();
//        boolean expextedCatalog=true;
//        Assert.assertEquals(actualCatalog,expextedCatalog,"catalog is not there");
//        catalogBar.click();
//    }
//    @Test
//    public void validateProductIsDisplayed(){
//        WebDriver driver= new ChromeDriver();
//
//        driver.get("https://demo.opencart.com/admin/");
//        driver.manage().window().maximize();
//
//        String expectWebsite="https://demo.opencart.com/admin/";
//
//        WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
//        loginButton.click();
//        WebElement catalogBar=driver.findElement(By.xpath("menu-catalog"));
//        catalogBar.click();
//        WebElement productBar=driver.findElement(By.xpath(""));
//        boolean actualCatalog=catalogBar.isDisplayed();
//        boolean expextedCatalog=true;
//        Assert.assertEquals(actualCatalog,expextedCatalog);
//        productBar.click();
//
//    }
//    @Test
//    public void validationBoxes() throws InterruptedException {
//        WebDriver driver= new ChromeDriver();
//
//        driver.get("https://demo.opencart.com/admin/");
//        driver.manage().window().maximize();
//
//        String expectWebsite="https://demo.opencart.com/admin/";
//
//        WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
//        loginButton.click();
//        WebElement catalogBar=driver.findElement(By.xpath("menu-catalog"));
//        catalogBar.click();
//        WebElement productBar=driver.findElement(By.xpath(""));
//        Thread.sleep(1000);
//        productBar.click();
//        List<WebElement> boxes=driver.findElements(By.xpath(""));
//        for(int i=1;i<boxes.size();i++){
//            Thread.sleep(500);
//            boxes.get(i).click();
//            boolean actualValidation=boxes.get(i).isDisplayed();
//            boolean expectedValidation=true;
//            Assert.assertEquals(actualValidation,expectedValidation);
//            boolean actualValidationSelected=boxes.get(i).isSelected();
//            boolean expectedValidationSelected=true;
//            Assert.assertEquals(actualValidation,expectedValidation);
//
//        }

    }
}

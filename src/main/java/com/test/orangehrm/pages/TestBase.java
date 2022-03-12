package com.test.orangehrm.pages;

import Utils.Browserutils;
import Utils.ConfigReader;
import Utils.DriverHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
  public  WebDriver driver;
    @BeforeMethod
    public void setup(){

        driver = DriverHelper.getDriver();
        driver.navigate().to(ConfigReader.readProperty("urlorangehrm"));

    }
    @AfterMethod
    public void tearDown(ITestResult result){
        if(!result.isSuccess()){
            Browserutils.getScreenShot(driver,"orangeHrmScreenShot");
        }
      //  DriverHelper.tearDown();
    }
}

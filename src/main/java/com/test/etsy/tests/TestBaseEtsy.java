package com.test.etsy.tests;

import Utils.ConfigReader;
import Utils.DriverHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBaseEtsy {
    public WebDriver driver;
    @BeforeMethod
    public void setup(){
    driver= DriverHelper.getDriver();

       // WebDriverManager.chromedriver().setup();
       // driver = new ChromeDriver();
        driver.navigate().to(ConfigReader.readProperty("urletsy"));
       // driver.manage().window().maximize();
        System.out.println("I am running before every test annotation");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("I am running after each annotation");
        //driver.quit();
    }
}

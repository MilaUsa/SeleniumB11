package com.test.openchart.tests;

import com.test.openchart.Pages.OpenChartLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBaseOpenChart {
    public WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://demo.opencart.com/admin/index.php?route=common/login");
        driver.manage().window().maximize();
        System.out.println("I am running before every test annotation");
        OpenChartLoginPage openChartLoginPage=new OpenChartLoginPage(driver);
        openChartLoginPage.login("demo","demo");

    }
    @AfterMethod
    public void tearDown(){
        System.out.println("I am running after each annotation");
       driver.quit();
    }
}

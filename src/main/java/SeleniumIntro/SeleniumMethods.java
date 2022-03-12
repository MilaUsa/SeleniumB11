package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumMethods {
    public static void main(String[] args) throws InterruptedException {
        //What is difference between

        System.setProperty("webdriver.chrome.driver","chromedriver");
        Thread.sleep(3000);
        WebDriver driver= new ChromeDriver();
        driver.navigate().to("https://www.google.com/");
       //driver.quit();
       //driver.close();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        //System.out.println(driver.getPageSource()); it gives the html source of the page
        driver.navigate().to("https://www.techtorialacademy.com");

        driver.navigate().back();// amazon
        driver.navigate().forward();
        //driver.navigate().refresh();//
        //driver.close();


    }
}

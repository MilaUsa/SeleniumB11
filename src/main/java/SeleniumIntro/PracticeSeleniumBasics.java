package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeSeleniumBasics {
    public static void main(String[] args) {
        // Task : I want to you go to the 3 websites. get the title, currentUrl.you decide and going back
        //forward with them lastly refresh and quit.
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver= new ChromeDriver();

        driver.get("https://www.etsy.com/");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.navigate().to("https://www.amazon.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.navigate().to("https://www.ebay.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
       // driver.close();
       // driver.quit();

        driver.navigate().back();
        driver.navigate().forward();
       // driver.close();
        driver.quit();

    }
}

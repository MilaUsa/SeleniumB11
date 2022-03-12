package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.InterfaceAddress;

public class SeleniumBasics {
    public static void main(String[] args) {
       // Step1) we need to define the chrome driver into the project as a property.
        System.setProperty("webdriver.chrome.driver","chromedriver");
        //Windows:
        //System.setProperty("webdriver.chrome.driver","chromedriver");
        //Step 2)We need to instantiate(declare) our driver.
        WebDriver driver= new ChromeDriver();
        // Note: driver is a reference name.WebDriver--.InterfaceAddress
        // new ChromeDriver()--> new object
        //1. Where do you use polymorphism in your testing framework?
        // I use it to instantiate my driver.example
        //WebDriver driver= new ChromeDriver
        //2. Can you instantiate your driver like
        //WebDriver driver= new WebDriver(); you can not do it

        //First method
        //Get()
        driver.get("https://www.techtorialacademy.com");
        //getTitle()--> methods get the title of the page

        String title= driver.getTitle();
        System.out.println(title);
        if(title.equals("Home Page- Techtorial")){
            System.out.println("Your test is passed");
        }else{
            System.out.println("Your tes is failed");
        }
        //getCurrentUrl() it gets the current url of the website
        String actual= driver.getCurrentUrl();
        String expected="https://www.techtorialacademy.com";
        if(actual.equals(expected)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

    }
}

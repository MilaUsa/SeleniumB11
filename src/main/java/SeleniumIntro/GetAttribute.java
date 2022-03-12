package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttribute {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com/");
        WebElement googlebutton= driver.findElement(By.xpath("//input[@value='Google Search']"));
        System.out.println(googlebutton.getAttribute("value"));
        System.out.println(googlebutton.getAttribute("aria-label"));
      if(googlebutton.getAttribute("value").equals("Google Search")){
          System.out.println("passed");
      }else{
          System.out.println("Failed");
      }
    }
}

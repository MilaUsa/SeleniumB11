package HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWorkTask4 {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();             //tread.sleep
        driver.get("https://www.saucedemo.com/");
        driver.navigate().refresh();
        WebElement uName1=driver.findElement(By.xpath("//input[@id='user-name']"));
        uName1.sendKeys("standard_user");
        WebElement pWord1=driver.findElement(By.xpath("//input[@id='password']"));
        pWord1.sendKeys("secret_sauce");
        WebElement login1=driver.findElement(By.xpath("//input[@id='login-button']"));
        login1.click();
       String currentUrl= driver.getCurrentUrl();
        System.out.println(currentUrl);
        String expectResult="https://www.saucedemo.com/inventory.html";
        if(currentUrl.equals(expectResult)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }
    }
}

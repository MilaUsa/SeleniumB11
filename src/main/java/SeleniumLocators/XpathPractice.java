package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathPractice {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("file:///Users/milanausekeeva/Downloads/Techtorial%20(2).html");
        WebElement javalink=driver.findElement(By.xpath("//[@href='https://www.oracle.com/java/']"));
        javalink.click();
    }
}

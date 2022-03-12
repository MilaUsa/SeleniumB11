package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice1 {
    public static void main(String[] args) {
        WebDriver driver= new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        WebElement slider= driver.findElement(By.xpath("//h3"));//or //h3[contains(text(),'Horizontal Slider')]
        System.out.println(slider.getText());
        WebElement text=driver.findElement(By.xpath("//h4"));// //h4[@class='subheader']
        System.out.println(text.getText());
        WebElement slider2= driver.findElement(By.xpath("//div[contains(text(),'Powered by ')]"));
        System.out.println(text.getText());



        //contains: it works with text.
        //tagname[contains(text(),'HorizontalLine')]// %60
        WebElement slider1= driver.findElement(By.xpath("//h3[contains(text(),'Horizontal Slider')]"));
        System.out.println(text.getText());

        //text
       // WebElement slider2= driver.findElement(By.xpath("//h3[.=''Horizontal Slider']"));
       // System.out.println(text.getText());


    }
}

package HomeWork2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTask {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        WebElement helloSighn = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
        System.out.println(helloSighn.getText());
        String actualResult = helloSighn.getText();
        String expectedResult = "Hello, Sign in";
        if (actualResult.equals(expectedResult)) {
            helloSighn.click();
        }
        WebElement signIn= driver.findElement(By.xpath("//a[@id='createAccountSubmit']"));
        signIn.click();
        WebElement name= driver.findElement(By.xpath("//input[@name='customerName']"));
        name.sendKeys("Milana");
        WebElement email= driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys("uyhuh@gmail.com");
        WebElement password= driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("mhsxhy222N");
        WebElement password2= driver.findElement(By.xpath("//input[@tabindex='6']"));
        password2.sendKeys("mhsxhy222N");
        WebElement continueButton= driver.findElement(By.xpath("//input[@id='continue']"));
        continueButton.click();
        WebElement output= driver.findElement(By.xpath("//span[@class='a-size-large']"));
        System.out.println(output.getText());
        String actualOutput=output.getText();
        String expectOutput="Solve this puzzle to protect your account";
        if(actualOutput.equals(expectOutput)){
            System.out.println("passed");
        }else{
            System.out.println("Failed");
        }
       // WebElement pazzleButton= driver.findElement(By.xpath("//a[contains(text(),'Solve Puzzle')]"));
       // pazzleButton.click();


    }
}

package TESTNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class TestNGPracticeWithRealWebsite2 {
    @Test
            public void validationAssendingOrderobtions() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        WebElement catalogBar = driver.findElement(By.id("menu-catalog"));
        catalogBar.click();
        Thread.sleep(1000);
        WebElement options = driver.findElement(By.xpath("//a[.='Options']"));
        options.click();
        Thread.sleep(1000);
        List<WebElement> allOptions = driver.findElements(By.xpath("//tbody/tr/td[2]"));
        Set<String> actualOptionOrder = new LinkedHashSet<>();
        Set<String> expectedOptionOrder = new TreeSet<>();
        for (WebElement option : allOptions) {
            actualOptionOrder.add(option.getText().trim());
            expectedOptionOrder.add(option.getText().trim());
            Assert.assertEquals(actualOptionOrder, expectedOptionOrder);
        }
    }
        @Test
        public void validationDesendingOrderobtions() throws InterruptedException {
            WebDriver driver = new ChromeDriver();
            driver.navigate().to("https://demo.opencart.com/admin/");
            driver.manage().window().maximize();

            WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
            loginButton.click();
            WebElement catalogBar = driver.findElement(By.id("menu-catalog"));
            catalogBar.click();
            Thread.sleep(1000);
            WebElement options = driver.findElement(By.xpath("//a[.='Options']"));
            options.click();
            WebElement optionNameButton= driver.findElement(By.xpath("//a[.='Option Name']"));
            optionNameButton.click();
            List<WebElement> descendinAllOptions = driver.findElements(By.xpath("//tbody/tr/td[2]"));
            List<String> actualDescendingOrder= new LinkedList<>();
            List<String> expectedDescendingOrder=new ArrayList<>();
            for(int i=0; i<descendinAllOptions.size();i++){
                actualDescendingOrder.add(descendinAllOptions.get(i).getText().trim());
                expectedDescendingOrder.add(descendinAllOptions.get(i).getText().trim());
                Collections.sort(expectedDescendingOrder);
                Collections.reverse(expectedDescendingOrder);

            }
            Assert.assertEquals(actualDescendingOrder,expectedDescendingOrder);


        }

    }



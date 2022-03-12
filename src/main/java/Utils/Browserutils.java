package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class Browserutils {
    //we create browserutils to able to call reusable methods from here to reduce amount of the codes
    public static void selectBy(WebElement element, String value, String methodName) {
        Select select = new Select(element);
        switch (methodName) {
            case "text":
                select.selectByVisibleText(value);
                break;
            case "index":
                select.selectByIndex(Integer.parseInt(value));
                break;
            case "value":
                select.selectByValue(value);
                break;
            default:
                System.out.println("Method name is not available, use text, value");
        }

    }

    public static String getTextMethod(WebElement element) {
        return element.getText().trim();
    }

    public static String GetTitleWithJS(WebDriver driver) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        String title = javascriptExecutor.executeScript("return document.title").toString();
        System.out.println(title + "from javaScript");
        return title;
    }

    @Test
    public static void ClickWithJS(WebDriver driver, WebElement element) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click()", element);

    }

    @Test
    public static void ScrollingWith(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("argument[0].scrollIntoView(true)", element);

    }

    public static void ScrollWithXandYCord(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Point location = element.getLocation();
        int xCord = location.getX();
        int yCord = location.getY();
        js.executeScript("window.scrollTo(" + xCord + "," + yCord + ")");
    }

    public static void SwitchOnlyForTwoTabs(WebDriver driver, String MainPageid) {
        Set<String> allPagesId = driver.getWindowHandles();
        for (String id : allPagesId) {
            if (!id.equals(allPagesId)) {
                driver.switchTo().window(id);
            }
        }
    }

    public static void switchMultipleWinows(WebDriver driver, String title) {
        Set<String> allPagesId = driver.getWindowHandles();
        for (String id : allPagesId) {
            driver.switchTo().window(id);
            if (driver.getTitle().contains(title)) {
                break;

            }

        }
    }
    public static void  switchByTitle(WebDriver driver, String title){
        Set<String> allPages = driver.getWindowHandles();
        for(String id : allPages){
            driver.switchTo().window(id);
            if(driver.getTitle().contains(title)){
                break;
            }
        }

    }
    public static void getScreenShot(WebDriver driver, String packageName){
      File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      String location=System.getProperty("user.dir")+"/src/java/screenshot"+packageName;

        try {
            FileUtils.copyFile(file,new File(location+System.currentTimeMillis()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}



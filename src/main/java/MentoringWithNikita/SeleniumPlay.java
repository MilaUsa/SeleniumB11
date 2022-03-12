package MentoringWithNikita;

import com.google.gson.internal.bind.util.ISO8601Utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class SeleniumPlay {

    public static void playnote(String[] notes,HashMap<String,WebElement> instrument) throws InterruptedException {
        for(String note:notes){
            instrument.get(note).click();
            Thread.sleep(100);
        }
    }
    @Test
    public void Piano() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.musicca.com/piano");
        driver.manage().window().maximize();
//        List<WebElement> whiteKeys=driver.findElements(By.xpath("//span[@class='white-key']"));
//        List<WebElement> blackKeys=driver.findElements(By.xpath("//span[@class='black-key']"));
//        HashMap<WebElement,String> whiteKeysMap=new LinkedHashMap<>();
//        HashMap<WebElement,String> blackKeysMap=new LinkedHashMap<>();
        List<WebElement> keys=driver.findElements(By.xpath("//span[@data-key]"));
        HashMap<String,WebElement> keyboard=new HashMap<>();
        for(WebElement key:keys){
            keyboard.put(key.getAttribute("data-note"),key);
        }
//        for(WebElement note:keyboard.values()){
//            note.click();
//
//        }
          String [] test={"2g","2e","2e","2g","2d","2g"};
        String[] surprise={"2g","2g","2g","2d","2e","2e","2d","3b","3b","3a","3a","2g"};






        Thread.sleep(5000);
        driver.quit();

    }
}

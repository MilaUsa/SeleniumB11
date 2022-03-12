package ActionClass;

import Utils.Browserutils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class actionClassMethods {
    private Browserutils BrowserUtils;

    //contextclick--> right click
    @Test
    public void ContextClick() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement contextMenu = driver.findElement(By.partialLinkText("Context"));
        contextMenu.click();
        WebElement box = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        //action class you must use perform at the end
        actions.contextClick(box).perform();


    }

    @Test
    public void hoverOver() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement hovers = driver.findElement(By.linkText("Hovers"));
        hovers.click();
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        List<WebElement> pictures = driver.findElements(By.xpath("//div[@class='figure']//img"));
        List<WebElement> names = driver.findElements(By.tagName("h5"));
        List<String> expectedNames = Arrays.asList("name: user1", "name: user2", "name: user3");
        for (int i = 0; i < names.size(); i++) {
            Thread.sleep(3000);
            actions.moveToElement(pictures.get(i)).perform();//hover over here
            Assert.assertEquals(Browserutils.getTextMethod(names.get(i)), expectedNames.get(i));
            System.out.println(Browserutils.getTextMethod(names.get(i)));// get text here
        }
    }

    @Test
    public void doubleClick() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demo.guru99.com/test/simple_context_menu.html");
        driver.manage().window().maximize();
//            WebElement button= driver.findElement(By.xpath("//button"));
//            Actions actions= new Actions(driver);
//            actions.doubleClick(button).perform();
        WebElement button = driver.findElement(By.name("context-menu-one btn btn-neutral"));
        Actions actions = new Actions(driver);
        actions.contextClick().perform();


    }

    @Test
    public void doubleClick2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://selenium08.blogspot.com/2019/11/double-click.html");
        driver.manage().window().maximize();
        WebElement button = driver.findElement(By.xpath("//button[.='Double-Click me to see Alert message']"));
        Actions actions = new Actions(driver);
        actions.doubleClick(button).perform();
        Thread.sleep(10000);
        driver.quit();

    }

    @Test
    public void draAndDrop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        driver.manage().window().maximize();
        WebElement acceptCookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
        Thread.sleep(3000);
        acceptCookies.click();
        Actions actions = new Actions(driver);
//        for(int i = 0; i<5;i++){
//            actions.sendKeys(Keys.ARROW_DOWN).perform();
//        }
        WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement orangeBox = driver.findElement(By.xpath("//div[@class='test2']"));
        String actualMessage = Browserutils.getTextMethod(orangeBox);
        String expectedMessage = "... Or here.";
        Assert.assertEquals(actualMessage, expectedMessage);
        actions.dragAndDrop(draggable, orangeBox).perform();
        Thread.sleep(3000);
        orangeBox = driver.findElement(By.xpath("//div[@class='test2']"));
        String actualAfterDragAndDrop = Browserutils.getTextMethod(orangeBox);
        String expectedAfterDragAndDrop = "You did great!";
        Assert.assertEquals(actualAfterDragAndDrop, expectedAfterDragAndDrop);


        String actualcssValue = orangeBox.getCssValue("background-color");
        String expectedCssValue = "rgba(238, 111, 11, 1)";
        Assert.assertEquals(actualcssValue, expectedCssValue);
    }

    @Test
    public void ClickandHold() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        driver.manage().window().maximize();
        WebElement acceptCookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
        Thread.sleep(3000);
        acceptCookies.click();
        WebElement blueBox = driver.findElement(By.xpath("//div[@class='test1']"));
        String actualBlueBoxMessage = Browserutils.getTextMethod(blueBox);
        String expectedBlueBoxMessage = "Drag the small circle here ...";
        Assert.assertEquals(actualBlueBoxMessage, expectedBlueBoxMessage);
        WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(draggable).moveToElement(blueBox).release().perform();
    }

    @Test
    public void practice() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/droppable");
        driver.manage().window().maximize();
        WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement blueLikeBox = driver.findElement(By.xpath("//div[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable, blueLikeBox).perform();
        String actualBox = Browserutils.getTextMethod(blueLikeBox);
        String expectedBox = "Dropped!";
        Assert.assertEquals(actualBox, expectedBox);

    }

    @Test
    public void practice2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/droppable");
        driver.manage().window().maximize();
        WebElement acceptButton= driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']"));
        acceptButton.click();
        WebElement notAcceptButton= driver.findElement(By.id("notAcceptable"));
       WebElement dropButton= driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[2]/p"));
        Actions actions=new Actions(driver);
        Thread.sleep(300);
        actions.dragAndDrop(notAcceptButton,dropButton).perform();
        String actualBox =dropButton.getCssValue("box-sizing");
        String expectedBox ="border-box";
       Assert.assertEquals(actualBox, expectedBox);

       WebElement acceptableButton= driver.findElement(By.id("acceptable"));
       actions.clickAndHold(acceptableButton).moveToElement(dropButton).release().perform();
       String actualcolor=dropButton.getCssValue("background-color");
       String expectedColor="rgba(0, 0, 0, 0)";
       Assert.assertEquals(actualcolor,expectedColor);

    }
    @Test
    public void MoveByOffSetPractice(){
        //Task By using move by off set and point class.
        //click contact us
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
       WebElement contactUs= driver.findElement(By.xpath("//div[@class='navigation hidden-xs']//a[.='Contact Us']"));
        Point coordinatesOfContactUs=contactUs.getLocation();
        int xCoord=coordinatesOfContactUs.getX();
        int yCoord=coordinatesOfContactUs.getY();
        Actions actions=new Actions(driver);
        actions.moveByOffset(xCoord,yCoord).click().build().perform();


    }
}
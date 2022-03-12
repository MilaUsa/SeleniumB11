package com.test.orangehrm.pages.tests;

import Utils.ConfigReader;
import com.test.orangehrm.pages.DataForLoginNegativeTest;
import com.test.orangehrm.pages.TestBase;
import com.test.orangehrm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    LoginPage loginPage;
    @BeforeMethod
    public void initiliazePage(){
        loginPage=new LoginPage(driver);
    }


//    WebDriver driver;
//    @BeforeMethod
//    public void setup(){
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
//        driver.manage().window().maximize();
//        System.out.println("I am running before every test annotation");
//    }


    @Test
    public void validateLoginPositive(){
       // LoginPage loginPage = new LoginPage(driver);
       // loginPage.login(ConfigReader.readProperty("orangehrmusername"),ConfigReader.readProperty("orangehrmpassword")););
        Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/index.php/dashboard");
    }

     @Test(dataProvider = "LoginNegativeTestScenario",dataProviderClass = DataForLoginNegativeTest.class)
    public void validateLoginNegative1(String username,String password,String expectedMessage){
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
//        driver.manage().window().maximize();
       // LoginPage loginPage = new LoginPage(driver);
         loginPage.login(username,password);//correct username but wrong password
         Assert.assertEquals(loginPage.geterrorMessage(),expectedMessage);
        loginPage.login(ConfigReader.readProperty("orangehrmusername"),ConfigReader.readProperty("orangehrmpassword"));
//        String actualErrorMessage=loginPage.geterrorMessage();
//        String expectedErrorMessage="Invalid credentials";
//        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
    }
    //2 more negative scenarious(wrong username, correct password,wrong username, wrong password

    @Test
    public void validateLoginNegative2(){
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
//        driver.manage().window().maximize();
      //  LoginPage loginPage = new LoginPage(driver);
        loginPage.login("","");
        String actualErrorMessage=loginPage.geterrorMessage();
        String expectedErrorMessage="Username can be empty";
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
        String actualColorOfErrorMessage=loginPage.getColorOfTheErrorMessage();
        String expectedColorOfErrorMessage="rgba(221, 119, 0, 1)";
        Assert.assertEquals(actualColorOfErrorMessage,expectedColorOfErrorMessage);
    }

//    @Test
//    public void validateLoginPositive(){
////        WebDriverManager.chromedriver().setup();
////        WebDriver driver = new ChromeDriver();
////        driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
////        driver.manage().window().maximize();
//        LoginPage loginPage= new LoginPage(driver);
//        loginPage.login("Admin","admin123");
////        String actualUrl = driver.getCurrentUrl();
////        String expectedUrl = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
//        Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/index.php/dashboard");
//    }
//    @Test
//    public void alidateLoginNegative(){
////        WebDriverManager.chromedriver().setup();
////        WebDriver driver = new ChromeDriver();
////        driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
////        driver.manage().window().maximize();
//        LoginPage loginPage= new LoginPage(driver);
//        loginPage.login("Admin","Milana");
//        String actualErrormessage=loginPage.geterrorMessage();
//        String expectederrorMessage="Invalid credentials";
//        Assert.assertEquals(actualErrormessage,expectederrorMessage);
//    }
//    @Test
//    public void validateLoginNegative2(){
////        WebDriverManager.chromedriver().setup();
////        WebDriver driver = new ChromeDriver();
////        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
////        driver.manage().window().maximize();
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.login("","");
//        String actualErrorMessage=loginPage.geterrorMessage();
//        String expectedErrorMessage="Username cannot be empty";
//        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
//        String actualColorOfErrorMessage=loginPage.getColorOfTheErrorMessage();
//        String expectedColorOfErrorMessage="rgba(221, 119, 0, 1)";
//        Assert.assertEquals(actualColorOfErrorMessage,expectedColorOfErrorMessage);
//    }
//
//
////    @AfterMethod
////    public void tearDown(){
////        System.out.println("I am running after each annotation");
////        driver.quit();
////    }
}

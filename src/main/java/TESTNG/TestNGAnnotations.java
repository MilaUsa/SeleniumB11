package TESTNG;

import org.testng.annotations.*;

public class TestNGAnnotations {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("before suite");
        //you can use to setup your chrome Browser properties
        //For ex:(deletecookies)
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("before test");
        //you can use to launch your browser
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("before class");
        //you can navigate to the website
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("before method");
        //You can use it to login the page
    }

    @Test
    public void test1(){
        System.out.println("test-1");
    }
    @Test
    public void test2(){
        System.out.println("test-2");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("after method");
        //YOU CAN TAKE A SCREENSHOT FOR FAILED TEST ANNOTATIONS
        //DRIVER.quit()
    }
    @AfterClass
    public void AfterClass(){
        System.out.println("AfterClass");
    }
    @AfterTest
    public void AfterTest(){
        System.out.println("After Test");
    }
    @AfterSuite
    public void AfterSuite(){
        System.out.println("After suite");
    }
}

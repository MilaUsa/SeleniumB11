package com.test.orangehrm.pages.tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.test.orangehrm.pages.TestBase;
import com.test.orangehrm.pages.LoginPage;
import com.test.orangehrm.pages.MainPage;
import com.test.orangehrm.pages.PimPage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PimTest extends TestBase {
    LoginPage loginPage;
    MainPage mainPage;
    PimPage pimPage;
    @BeforeMethod
    public void initiliazingPages(){
        /* LoginPage*/loginPage=new LoginPage(driver);
       /* MainPage*/ mainPage=new MainPage(driver);
        /*PimPage*/ pimPage= new PimPage(driver);
    }
    @Test
    public void validatePimPage() throws InterruptedException {
       // LoginPage loginPage=new LoginPage(driver);
        loginPage.login("Admin","admin123");
       // MainPage mainPage = new MainPage(driver);
        mainPage.clickPIMButton();
      // PimPage pimPage= new PimPage(driver);
        pimPage.addEmployeeForPIM("Mila","Miller","1994","/Users/milanausekeeva/Desktop/usa.png");
        Assert.assertEquals(pimPage.ValidateFirstName(),"Mila");
        Assert.assertEquals(pimPage.validateLastName(),"Miller");
        Assert.assertTrue(pimPage.validateEmployeeId("1994"));


    }
    @Test
    public void validatePersonalDetails() throws InterruptedException {
        loginPage.login("Admin","admin123");
        mainPage.clickPIMButton();
        pimPage.addEmployeeForPIM("Mila","Miller","1994","/Users/milanausekeeva/Desktop/usa.png");
     pimPage.editPersonalDetails("Kyrgyz","1990-04-02","Married");
        Assert.assertEquals(pimPage.ValidateTheNationality(),"Kyrgyz");
    }




}
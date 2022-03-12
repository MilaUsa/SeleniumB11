package com.test.orangehrm.pages.tests;

import Utils.ConfigReader;
import com.test.orangehrm.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AdminTest extends TestBase {
    AdminPage adminPage;
    @BeforeMethod
    public void initiliazePages(){
        adminPage = new AdminPage(driver);
    }

    @Test
    public void validateTheCreationOfEmployeeMessage() throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("Admin","admin123");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickAdminButton();
       // AdminPage adminPage = new AdminPage(driver);
        adminPage.sendingAllInformationForEmployee();
        adminPage.ValidationTheEmployeeIsCreated("milanewoldon");



    }
    @Test(dataProvider = "UserRoles",dataProviderClass = DataForLoginNegativeTest.class)
    public void ValidateTheSelectRoleFunctions(String roleName){
        //public void ValidateTheSelectRoleFunctions(String roleName){
            MainPage mainPage=new MainPage(driver);
            mainPage.clickAdminButton();
            AdminPage adminPage=new AdminPage(driver);
            adminPage.selectUserRole(roleName,driver);
            adminPage.selectUserRole(roleName,driver);//Admin //ESS
            Assert.assertTrue(adminPage.validateAdminUserRoleText(roleName));
        }

//    @DataProvider(name="UserRoles")
//    public Object[][] getUserRolesData() {
//        return new Object[][]{
//                {"Admin"},
//                {"EEC"}
//        };
//    }
//    @Test(dataProvider = "UserRoles")
//    public void ValidateTheSelectRoleFiunctions(){
//        LoginPage loginPage= new LoginPage(driver);
//        loginPage.login(ConfigReader.readProperty("orangehrmusername"),ConfigReader.readProperty("orangehrmpassword"));
//                MainPage mainPage=new MainPage(driver);
//                mainPage.clickAdminButton();
//                AdminPage adminPage=new AdminPage(driver);
////                adminPage.selectUserRole(rolename,driver);
////        Assert.assertTrue(adminPage.validateAdminUserRoleText(rolename));
//    }
    @Test
    public void ValidateTheSelectRoleFiunctions2(){
        LoginPage loginPage= new LoginPage(driver);
        loginPage.login(ConfigReader.readProperty("orangehrmusername"),ConfigReader.readProperty("orangehrmpassword"));
        MainPage mainPage=new MainPage(driver);
        mainPage.clickAdminButton();
        AdminPage adminPage=new AdminPage(driver);
//        adminPage.selectUserRole(rolename,driver);
//        Assert.assertTrue(adminPage.validateAdminUserRoleText(rolename));
    }
}

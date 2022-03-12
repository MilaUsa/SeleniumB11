package com.test.orangehrm.pages.tests;

import TESTNG.DataForNames;
import Utils.ConfigReader;
import com.test.orangehrm.pages.DataForLoginNegativeTest;
import com.test.orangehrm.pages.LoginPage;
import com.test.orangehrm.pages.TestBase;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataForLogin extends TestBase {
//    @DataProvider(name="LoginNegativeTestScenario")
//    public Object[][] getNegativeData(){
//        return new Object[][]{
//
//                {"Admin,","gygug","Invalid credentials"},
//                {"wrongUsername","wrongPassword","Invalid credentials"},
//                {"wrongusername","admin123","Invalid credentials"}
//
//        };
   // }
//
@DataProvider(name = "LoginNegativeTestScenario")
public Object[][] getNegativeScenarioData(){
    return new Object[][]{
            {"Admin","wrongPassword","Invalid credentials"},
            {"wrongUsername","admin123","Invalid credentials"},
            {"wrongUsername","wrongpassword","Invalid credentials"}
    };
}
    @DataProvider(name = "UserRoles")
    public Object [][] getUserRolesData(){
        return new Object[][]{
                {"Admin"},
                {"ESS"}
        };
    }


}

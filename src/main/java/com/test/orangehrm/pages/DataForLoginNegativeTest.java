package com.test.orangehrm.pages;

import org.testng.annotations.DataProvider;

public class DataForLoginNegativeTest {
    @DataProvider(name = "LoginNegativeTestScenario")
    public Object[][] getNegativeData() {
        return new Object[][]{

                {"Admin,", "gygug", "Invalid credentials"},
                {"wrongUsername", "wrongPassword", "Invalid credentials"},
                {"wrongusername", "admin123", "Invalid credentials"}

        };
    }
}

package com.test.etsy.tests;

import com.test.etsy.pages.MainPageEtsy;
import com.test.orangehrm.pages.TestBase;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestEtsy extends TestBaseEtsy {
    @Parameters("itemSearch")
    @Test
    public void EtsySearchTest(String item){
        MainPageEtsy mainPageEtsy= new MainPageEtsy(driver);
        mainPageEtsy.searchItem(item);
    Assert.assertTrue(mainPageEtsy.validateHeader());

    }
}

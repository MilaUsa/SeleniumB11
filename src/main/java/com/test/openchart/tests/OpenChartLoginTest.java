package com.test.openchart.tests;

import com.test.openchart.Pages.OpenChartCustomerPage;
import com.test.openchart.Pages.OpenChartLoginPage;
import com.test.openchart.Pages.OpenChartMainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenChartLoginTest extends TestBaseOpenChart{

  @Test
  public void ValidateMainPage() throws InterruptedException {
    OpenChartMainPage openChartMainPage= new OpenChartMainPage(driver);
    System.out.println(openChartMainPage.ValidateFirstNumber());
    Assert.assertEquals(openChartMainPage.ValidateFirstNumber(),"12K");
    System.out.println(openChartMainPage.ValidateSecondNumber());
    Assert.assertEquals(openChartMainPage.ValidateSecondNumber(),"11.8M");
    System.out.println(openChartMainPage.ValidateThirdNumber());
    Assert.assertEquals(openChartMainPage.ValidateThirdNumber(),"144.8K");

  }
  @Test
  public void getAllInfoOfCustomerPage() throws InterruptedException {

    OpenChartCustomerPage openChartCustomerPage=new OpenChartCustomerPage(driver);
    openChartCustomerPage.clickCustomerButtons();
    openChartCustomerPage.AllCustomerInfo("Alisa","Singer","alisa@gmail.com","9299271121","mika999");
    Assert.assertEquals(openChartCustomerPage.ValidateAffterAddCustomerText(),"Warning: You do not have permission to modify customers!\n" +
            "×");
    Assert.assertEquals(openChartCustomerPage.ValidateColorAffterAddCustomerText(),"rgba(199, 47, 29, 1)");
  }

}

package com.test.openchart.Pages;

import Utils.Browserutils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenChartMainPage {
    public OpenChartMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
   @FindBy(xpath = "//h2[.='12K']")
    WebElement firstNumber;

    @FindBy(xpath = "//h2[.='11.8M']")
    WebElement secondNumber;

    @FindBy(xpath = "//h2[.='144.8K']")
    WebElement thirdNumber;

    public String ValidateFirstNumber(){
        return firstNumber.getText().trim();
    }
    public String ValidateSecondNumber() throws InterruptedException {
        Thread.sleep(1000);
        return secondNumber.getText().trim();
    }
    public String ValidateThirdNumber() throws InterruptedException {
       // Thread.sleep(1000);
        return thirdNumber.getText().trim();

    }

}

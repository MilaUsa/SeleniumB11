package com.test.openchart.Pages;

import Utils.Browserutils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OpenChartCustomerPage {
    public OpenChartCustomerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
   @FindBy(xpath = "//li[@id='menu-customer']//a[@class='parent collapsed']")
    WebElement CustomersButton;

    @FindBy(xpath = "//a[.='Customers']")
    WebElement CustomersByCustomersButton;

    @FindBy(xpath = "//a[@data-original-title='Add New']")
    WebElement plusSignButton;

    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement firstName;

    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement lastName;

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement email;

    @FindBy(xpath = "//input[@id='input-telephone']")
    WebElement phoneNumber;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement password;

    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement confirmPassword;

    @FindBy(xpath = "//i[@class='fa fa-save']")
    WebElement saveButton;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement validText;



    public String ValidateAffterAddCustomerText(){
        return Browserutils.getTextMethod(validText);
    }
    public String ValidateColorAffterAddCustomerText(){
        return validText.getCssValue("color");
    }



    public void clickCustomerButtons() throws InterruptedException {
        Thread.sleep(1000);
        CustomersButton.click();
        Thread.sleep(1000);
        CustomersByCustomersButton.click();
        plusSignButton.click();


    }
    public void AllCustomerInfo(String name, String lastname, String email, String telephone,String passWord){
        this.firstName.sendKeys(name);
        this.lastName.sendKeys(lastname);
        this.email.sendKeys(email);
        phoneNumber.sendKeys(telephone);
        password.sendKeys(passWord);
        confirmPassword.sendKeys(passWord);
        saveButton.click();





    }
}

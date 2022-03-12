package com.test.orangehrm.pages;

import Utils.Browserutils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdminPage {
    public AdminPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "btnAdd")
    WebElement addButton;

    @FindBy(id = "systemUser_userType")
    WebElement userRoles;

    @FindBy(id = "systemUser_employeeName_empName")
    WebElement employeeName;

    @FindBy(xpath = "//input[@id='systemUser_userName']")
    WebElement userName;

    @FindBy(name = "systemUser[status]")
    WebElement status;

    @FindBy(name = "systemUser[password]")
    WebElement password;

    @FindBy(name = "systemUser[confirmPassword]")
    WebElement confirmPassword;

    @FindBy(className = "addbutton")
    WebElement saveButton;

    @FindBy(xpath = "//tr//a[contains(@href,'saveSystemUser')]")
    List<WebElement> allNames;
    @FindBy(xpath = "//select[@id='searchSystemUser_userType']")
    WebElement userRoleBox;
    @FindBy(id = "searchBtn")
    WebElement searchButton;

    @FindBy(xpath = "//td[3]")
    List<WebElement> allTheRoles;


    public void sendingAllInformationForEmployee() throws InterruptedException {

        addButton.click();
        Browserutils.selectBy(userRoles, "Admin", "text");
        employeeName.sendKeys("Alice Duval");
        userName.sendKeys("milanewoldon");
        Browserutils.selectBy(status, "0", "value");
        password.sendKeys("Omuka135$$$");
        confirmPassword.sendKeys("Omuka135$$$");
        Thread.sleep(1000);
        saveButton.click();
        Thread.sleep(1000);
    }

    public boolean ValidationTheEmployeeIsCreated(String Username) {
        for (WebElement name : allNames) {
            if (name.getText().trim().equals(Username)) {
                return true;
            }
        }
        return false;

    }

    public void selectUserRole(String roleName, WebDriver driver) {
        Browserutils.selectBy(userRoleBox, roleName, "text");
        Browserutils.ClickWithJS(driver, searchButton);
        // searchButton.click();
    }


    public boolean validateAdminUserRoleText(String rolename){
        for(WebElement role:allTheRoles){
            if(!role.getText().trim().equals(rolename)){
                return false;
            }
        }
        return  true;

    }
}


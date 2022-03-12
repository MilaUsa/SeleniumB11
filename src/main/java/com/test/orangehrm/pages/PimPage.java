package com.test.orangehrm.pages;

import Utils.Browserutils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PimPage extends TestBase {

    public PimPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    /*
    10click PIM on the mainpage
    20 click add button under PIM
    3) Fill the boxes
    40 click save Button
    5) wait for the next direction
     */


        @FindBy(id = "btnAdd")
        WebElement addButton;


        @FindBy(id = "firstName")
        WebElement firstName;

        @FindBy(id = "lastName")
        WebElement lastName;

        @FindBy(xpath = "//input[@id='employeeId']")
        WebElement employeeId;

        @FindBy(xpath = "//input[@id='photofile']")
        WebElement chooseFile;

//        @FindBy(xpath = "//input[@id='chkLogin']")
//        WebElement checkButton;


        @FindBy(xpath = "//input[@id='btnSave']")
        WebElement saveButton;

        @FindBy(name = "personal[txtEmpFirstName]")
        WebElement ValidationFirstName;

        @FindBy(name = "personal[txtEmpLastName]")
        WebElement ValidationLastName;

        @FindBy(name = "personal[txtEmployeeId]")
        WebElement ValidationEmployeeId;

        @FindBy(xpath = "//input[@id='btnSave']")
        WebElement editButton;

        @FindBy(id = "personal_optGender_2")
        WebElement genderBox;

        @FindBy(id="personal_cmbMarital")
        WebElement maritalStatus;

        @FindBy(id="personal_cmbNation")
        WebElement nationality;

        @FindBy(xpath = "//input[@id='personal_DOB']")
        WebElement dob;




        public void addEmployeeForPIM(String name,String lastame, String employeeid, String uploadFile) throws InterruptedException {
            addButton.click();
            this.firstName.sendKeys(name);
            this.lastName.sendKeys(lastame);
            this.employeeId.sendKeys(employeeid);
            this.chooseFile.sendKeys(uploadFile);
            Thread.sleep(1000);
            saveButton.click();

        }

    public String ValidateFirstName()
    {
         return ValidationFirstName.getAttribute("value");
        }
        public String validateLastName(){
            return ValidationLastName.getAttribute("value");
        }
        public boolean validateEmployeeId(String employeeId){
            return ValidationEmployeeId.getAttribute("value").endsWith(employeeId);
        }
        public void editPersonalDetails(String nation,String dateOfBird,String maritualStatus){
         editButton.click();
         genderBox.click();
            Browserutils.selectBy(nationality,nation,"text");
            dob.clear();
            this.dob.sendKeys(dateOfBird);
            Browserutils.selectBy(maritalStatus,maritualStatus,"text");
            saveButton.click();
        }
        public String ValidateTheNationality(){
            Select select = new Select(nationality);
            return select.getFirstSelectedOption().getText().trim();
        }

    }




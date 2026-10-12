package com.pages;

import com.util.ReadProperty;
import com.util.Utility;
import com.util.WebUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.Read;

public class RegisterPage {

    private WebDriver driver;

    private WebUtil webUtil;

    private Utility utility;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
        this.webUtil = new WebUtil(driver);
        this.utility = new Utility();
    }

    public void fillFieldWithText(String fieldName, String text){
        if(text.equals("RandomEmail")){
            text = utility.getRandomEmail();
        }
        if(text.equals("Random first name")){
            text = utility.getRandomFirstName();
        }
        if(text.equals("Random last name")){
            text = utility.getRandomLastName();
        }
        if(text.equals("RandomMobile")){
            text = utility.getRandomMobileNumber();
        }
        webUtil.input(By.xpath(ReadProperty.propertyReader("inputIdValue").replace("value",fieldName)),text);
    }

    public void selectFieldWithText(String textToBeSelected){
        WebElement element = webUtil.getElement(By.xpath(ReadProperty.propertyReader("selectFor")));
        webUtil.selectDropdownByText(element,textToBeSelected);
    }

    public void clickOptionOnRadioButton(String optionName){
        webUtil.click(By.xpath(ReadProperty.propertyReader("radioButtons").replace("value1",optionName)));
    }

    public void checkTheCheckbox(String checkOrUncheck, String fieldName){
        webUtil.click(By.xpath(ReadProperty.propertyReader("checkbox").replace("value",fieldName)));
    }

    public void clickTheButton(String buttonName){
        webUtil.click(By.xpath(ReadProperty.propertyReader("inputIdValue").replace("value",buttonName)));
    }

    public boolean visibilityOfHeading(String headingName){
        return webUtil.isElementVisible(By.xpath(ReadProperty.propertyReader("headingOne").replace("value",headingName)));
    }

    public void fillFirstNameLastNameUseremailAndUsermobileWithRelevantRandoms() {
        String firstName = utility.getRandomFirstName();
        String lastName = utility.getRandomLastName();
        String email = firstName + "." + lastName + "@gmail.com";
        String mobile = utility.getRandomMobileNumber();
        fillFieldWithText("firstName",firstName);
        fillFieldWithText("lastName",lastName);
        fillFieldWithText("userEmail",email);
        fillFieldWithText("userMobile", mobile);
    }
}

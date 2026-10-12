package com.pages;

import com.util.ReadProperty;
import com.util.Utility;
import com.util.WebUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.Read;

public class LoginPage{

    private WebDriver driver;

    private WebUtil webUtil;

    private Utility utility;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.webUtil = new WebUtil(driver);
        this.utility = new Utility();
    }

    public void goToTheLoginPage(String url){
        webUtil.navigateToUrl(url);
    }

    public String getLoginPageTitle(){
       return webUtil.getPageTitle();
    }

    public void enterUsername(String usernameToEnter){
        webUtil.input(By.xpath(ReadProperty.propertyReader("loginPageEmail")), usernameToEnter);
    }

    public void enterPassword(String passwordToEnter){
        webUtil.input(By.xpath(ReadProperty.propertyReader("inputIdValue").replace("value","userPassword")),passwordToEnter);
    }

    public void clickLoginButton(){
        webUtil.click(By.xpath(ReadProperty.propertyReader("loginButton")));
    }

    public boolean forgotPasswordLinkIsVisible(){
       return webUtil.isElementVisible(By.xpath(ReadProperty.propertyReader("forgotPasswordLink")));
    }

    public void clickOnRegisterHereLink(String linkText){
        webUtil.click(By.xpath(ReadProperty.propertyReader("registerHere").replace("value",linkText)));
    }
}
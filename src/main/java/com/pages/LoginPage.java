package com.pages;

import com.util.ReadProperty;
import com.util.WebUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.Read;

public class LoginPage{

    private WebDriver driver;

    private WebUtil webUtil;

    private By forgotPwdLink = By.linkText("Forgot your password?");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.webUtil = new WebUtil(driver);
    }

    public void goToTheLoginPage(String url){
        webUtil.navigateToUrl(url);
    }

    public String getLoginPageTitle(){
       return webUtil.getPageTitle();
    }

    public boolean isForgotPwdLinkExist() {
        return driver.findElement(forgotPwdLink).isDisplayed();
    }

    public void enterUsername(String usernameToEnter){
        webUtil.input(By.xpath(ReadProperty.propertyReader("loginPageEmail")), usernameToEnter);
    }

    public void enterPassword(String passwordToEnter){
        webUtil.input(By.xpath(ReadProperty.propertyReader("loginPagePassword")),passwordToEnter);
    }

    public void clickLoginButton(){
        webUtil.click(By.xpath(ReadProperty.propertyReader("loginButton")));
    }

    public boolean forgotPasswordLinkIsVisible(){
       return webUtil.isElementVisible(By.xpath(ReadProperty.propertyReader("forgotPasswordLink")));
    }
}
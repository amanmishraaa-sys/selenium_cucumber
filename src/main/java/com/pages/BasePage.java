package com.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {

    private WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage loginPage(){ return new LoginPage(this.driver); }

    public RegisterPage registerPage(){ return new RegisterPage(this.driver); }
}

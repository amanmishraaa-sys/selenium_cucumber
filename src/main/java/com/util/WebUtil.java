package com.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebUtil {

    WebDriver driver;

    public WebUtil(WebDriver driver){
        this.driver = driver;
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public void navigateToUrl(String url){
        driver.get(url);
    }

    public void input(By locator, String value){
        driver.findElement(locator).sendKeys(value);
    }

    public String getPageTitle(){
        return driver.getTitle();
    }
}

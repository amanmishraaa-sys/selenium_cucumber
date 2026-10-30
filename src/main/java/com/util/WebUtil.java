package com.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebUtil {

    WebDriver driver;

    WebElement element;

    public WebUtil(WebDriver driver){
        this.driver = driver;
    }

    public void click(By locator){
        element = waitForElementToBeVisible(locator);
        element.click();
    }

    public void clear(By locator) {
        element = waitForElementToBeVisible(locator);
        element.clear();
    }

    public void navigateToUrl(String url){
        driver.get(url);
    }

    public void input(By locator, String value){
        element = waitForElementToBeVisible(locator);
        element.sendKeys(value);
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public boolean isElementVisible(By locator){
        element = waitForElementToBeVisible(locator);
        return element.isDisplayed();
    }

    public WebElement waitForElementToBeVisible(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public boolean isEnabled(By locator){
        element = waitForElementToBeVisible(locator);
        return element.isEnabled();
    }

    public boolean isSelected(By locator){
        element = waitForElementToBeVisible(locator);
        return element.isSelected();
    }

    public String getText(By locator){
        element = waitForElementToBeVisible(locator);
        return element.getText();
    }

    public String getAttribute(By locator, String key){
        element = waitForElementToBeVisible(locator);
        return element.getAttribute(key);
    }

    public WebElement getElement(By locator){
        return waitForElementToBeVisible(locator);
    }

    public void selectDropdownByText(WebElement element, String textToBeSelected){
        Select select = new Select(element);
        select.selectByVisibleText(textToBeSelected);
    }
}

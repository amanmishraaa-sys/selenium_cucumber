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

    public WebUtil(WebDriver driver){
        this.driver = driver;
    }

    public void click(By locator){
        waitForElementToBeVisible(locator);
        driver.findElement(locator).click();
    }

    public void clear(By locator) {
        waitForElementToBeVisible(locator);
        driver.findElement(locator).clear();
    }

    public void navigateToUrl(String url){
        driver.get(url);
    }

    public void input(By locator, String value){
        waitForElementToBeVisible(locator);
        driver.findElement(locator).sendKeys(value);
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public boolean isElementVisible(By locator){
        waitForElementToBeVisible(locator);
        return driver.findElement(locator).isDisplayed();
    }

    public void waitForElementToBeVisible(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public boolean isEnabled(By locator){
        waitForElementToBeVisible(locator);
        return driver.findElement(locator).isEnabled();
    }

    public boolean isSelected(By locator){
        waitForElementToBeVisible(locator);
        return driver.findElement(locator).isSelected();
    }

    public String getText(By locator){
        waitForElementToBeVisible(locator);
        return driver.findElement(locator).getText();
    }

    public String getAttribute(By locator, String key){
        waitForElementToBeVisible(locator);
        return driver.findElement(locator).getAttribute(key);
    }

    public WebElement getElement(By locator){
        waitForElementToBeVisible(locator);
        return driver.findElement(locator);
    }

    public void selectDropdownByText(WebElement element, String textToBeSelected){
        Select select = new Select(element);
        select.selectByVisibleText(textToBeSelected);
    }
}

package com.pages;

import com.util.ReadProperty;
import com.util.Utility;
import com.util.WebUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.Read;

public class CommonPage {

    private WebDriver driver;

    private WebUtil webUtil;

    private Utility utility;

    public CommonPage(WebDriver driver){
        this.driver = driver;
        this.webUtil = new WebUtil(driver);
        this.utility = new Utility();
    }

    public boolean verifyToastMessage(String messageText){
        webUtil.waitForElementToBeVisible(By.xpath(ReadProperty.propertyReader("toastMessage")));
        return webUtil.getText(By.xpath(ReadProperty.propertyReader("toastMessage"))).equals(messageText);
    }

}

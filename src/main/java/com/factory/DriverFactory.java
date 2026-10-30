package com.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    /**
     * This method is used to initialize the threadlocal driver on the basis of given browser
     * @param browser
     * @param headless
     * @return
     */
    public WebDriver init_driver(String browser, boolean headless){
        System.out.println("Browser: "+browser);
        System.out.println("Headless: "+headless);

        if (browser.equalsIgnoreCase("chrome")){
            ChromeOptions options = new ChromeOptions();
            if(headless){
                options.addArguments("--headless=new");
            }
            tlDriver.set(new ChromeDriver(options));
        }
        else if(browser.equalsIgnoreCase("firefox")){
            FirefoxOptions options = new FirefoxOptions();
            if(headless) {
                options.addArguments("-headless");
            }
            tlDriver.set(new FirefoxDriver(options));
        }
        else if(browser.equalsIgnoreCase("edge")){
            EdgeOptions options = new EdgeOptions();
            if(headless){
                options.addArguments("--headless=new");
            }
            tlDriver.set(new EdgeDriver(options));
        }
        else {
            System.out.println("Please pass the correct browser value: "+browser);
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().setSize(new Dimension(1920,1080));
        return getDriver();
    }

    /**
     * this is used to get the driver with ThreadLocal
     * @return
     */
    public static synchronized WebDriver getDriver(){
        return tlDriver.get();
    }
}

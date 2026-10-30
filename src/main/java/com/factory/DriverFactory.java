package com.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
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
     * @return
     */
    public WebDriver init_driver(String browser, boolean headless){
        System.out.println("Browser value is: "+browser);

        if (browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            if(headless){
                options.addArguments("--headless=new");
            }
            tlDriver.set(new ChromeDriver(options));
        }
        else if(browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            if(headless) {
                options.addArguments("-headless");
            }
            tlDriver.set(new FirefoxDriver(options));
        }
        else if(browser.equals("edge")){
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            if(headless){
                options.addArguments("--headless=new");
            }
            tlDriver.set(new EdgeDriver());
        }
        else {
            System.out.println("Please pass the correct browser value: "+browser);
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
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

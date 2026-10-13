package com.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    public WebDriver driver;

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    /**
     * This method is used to initialize the threadlocal driver on the basis of given browser
     * @param browser
     * @return
     */
    public WebDriver init_driver(String browser){
        System.out.println("Browser value is: "+browser);

        if (browser.equals("chrome")){
            ChromeOptions options = new ChromeOptions();

            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--force-device-scale-factor=1");

            tlDriver.set(new ChromeDriver(options));
        }
        else if(browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();

            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--width=1920");
            options.addArguments("--height=1080");
            tlDriver.set(new FirefoxDriver(options));
        }
        else if(browser.equals("edge")){
            WebDriverManager.edgedriver().setup();

            EdgeOptions options = new EdgeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
            tlDriver.set(new EdgeDriver(options));
        }
        else {
            System.out.println("Please pass the correct browser value: "+browser);
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().setSize(
                new Dimension(1920, 1080)
        );
//        try {
//            getDriver().manage().window().maximize();
//        } catch (Exception e){
//            System.out.println(
//                    "Could not maximize browser window: "
//                            + e.getMessage());
//        }
        System.out.println(
                "Browser window size: "
                        + getDriver().manage().window().getSize());
        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        System.out.println(
                "Viewport size: "
                        + js.executeScript(
                        "return window.innerWidth + 'x' + window.innerHeight"));
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

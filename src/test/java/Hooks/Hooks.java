package Hooks;

import com.factory.DriverFactory;
import io.cucumber.java.Scenario;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.util.ConfigReader;

import java.util.Properties;

public class Hooks {

    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    Properties prop;

    @Before(order = 0)
    public void getProperty() {
        configReader = new ConfigReader();
        prop = configReader.init_prop();
    }

    @Before(order = 1)
    public void launchBrowser(){
       String broswerName =  prop.getProperty("browser");
       boolean headless = Boolean.parseBoolean(prop.getProperty("headless"));
       driverFactory  = new DriverFactory();
         driver = driverFactory.init_driver(broswerName, headless);
    }

    @After(order = 0)
    public void quitBrowser(){
        if (driver != null) {
            driver.quit();
        }
    }

    @After(order = 1)
    public void tearDown(Scenario scenario){
        try {
            // take screenshot
            String screenshotName = scenario.getName().replaceAll("[^a-zA-Z0-9.-]", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

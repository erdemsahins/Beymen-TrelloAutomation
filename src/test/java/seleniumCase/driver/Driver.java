package seleniumCase.driver;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class Driver {

    public static WebDriver webDriver;
    public static WebDriverWait webDriverWait;
    public final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeMethod
    public static void initializeDriver() {
        webDriver = DriverFactory.getDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        BasicConfigurator.configure();
    }

    @AfterMethod
    public static void closeDriver() {
        webDriver.quit();
    }

}

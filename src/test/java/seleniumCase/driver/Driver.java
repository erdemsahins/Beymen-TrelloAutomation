package seleniumCase.driver;

import org.apache.log4j.BasicConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class Driver {

    public static WebDriver webDriver;

    @Before
    public void initializeDriver(){
        BasicConfigurator.configure();
        webDriver = DriverFactory.getDriver();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void closeDriver(){
        webDriver.quit();
    }


}

package seleniumCase.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    public static WebDriver getDriver() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("start-maximized");

        return new ChromeDriver(options);
    }
}


package seleniumCase.base;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import seleniumCase.driver.Driver;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BasePage extends Driver {

    public String productDescription;
    String productPrice;


    public void getUrl(String url) {
        webDriver.get(url);
        logger.info(url + "Url page opened.");
    }

    public static void waitUntilPresenceOfElementLocatedBy(By by) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void waitUntilVisibilityOfElementLocatedBy(By by) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitUntilClickableOfElementLocatedBy(By by) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
    }


    public WebElement findElement(By by) {
        waitUntilVisibilityOfElementLocatedBy(by);
        waitUntilPresenceOfElementLocatedBy(by);
        return webDriver.findElement(by);
    }

    public void clickElement(By by) {
        waitUntilClickableOfElementLocatedBy(by);
        Actions action = new Actions(webDriver);
        action.moveToElement(findElement(by));
        action.click();
        action.build().perform();
    }

    public void sendKey(By by, Keys keys) {
        waitUntilClickableOfElementLocatedBy(by);
        Actions action = new Actions(webDriver);
        action.moveToElement(findElement(by));
        action.click();
        action.sendKeys(keys);
        action.build().perform();
    }

    public void writeText(By by, String text) {
        waitUntilVisibilityOfElementLocatedBy(by);
        WebElement element = findElement(by);
        Actions action = new Actions(webDriver);
        action.moveToElement(findElement(by));
        element.sendKeys(text);
        action.build().perform();
    }

    public void selectByValue(By by, String value) {
        waitUntilClickableOfElementLocatedBy(by);
        WebElement selectElement = findElement(by);
        Select select = new Select(selectElement);
        select.selectByValue(value);

    }

    public String getText(By by) {
        return findElement(by).getText();
    }

    public void isElementDisplayed(By by) {
        findElement(by).isDisplayed();
    }

    public void assertEquals(String actualText, String expectedText) {
        logger.info("actualText: " + actualText + " expectedText: " + expectedText);
        Assert.assertTrue(actualText.contains(expectedText));
    }

    public void wait(int seconds) throws InterruptedException {
        TimeUnit.SECONDS.sleep(seconds);
    }

    public void assertFail() {
        Assert.fail();
    }

    public String getExcelRow(int i) {
        Workbook workbook = null;
        try {
            workbook = new XSSFWorkbook("input.xlsx");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(0);
        String temp = String.valueOf(row.getCell(i));

        logger.info(temp + " read information from excel");
        return temp;
    }

    public void randomSelect(By by) {
        waitUntilVisibilityOfElementLocatedBy(by);
        waitUntilClickableOfElementLocatedBy(by);
        List<WebElement> pageResult = webDriver.findElements(by);
        Random random = new Random();
        pageResult.get(random.nextInt(pageResult.size())).click();
        logger.info("A random element is selected.");
    }

    public void getProductDetailAndSave(By desc, By price) {
        productDescription = webDriver.findElement(desc).getText();
        productPrice = webDriver.findElement(price).getText();
        logger.info("product Description: '" + productDescription + "' - productPrice: " + productPrice + "'");

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt", true));
            writer.append("product Description: '" + productDescription + "' - productPrice: " + productPrice + "'");
            writer.append("\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String priceFormat(String t1) {
        t1 = t1.replace("TL", "");
        t1 = t1.replace(" ", "");
        t1 = t1.replace(",00", "");
        return t1;
    }

    public void assertEqualsPrice(String actualText, String expectedText) {
        logger.info("actualText: " + actualText + " expectedText: " + expectedText);
        Assert.assertTrue(priceFormat(actualText).contains(priceFormat(expectedText)));
    }

}

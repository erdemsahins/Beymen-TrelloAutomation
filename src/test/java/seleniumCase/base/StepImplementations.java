package seleniumCase.base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class StepImplementations extends BasePage {

    public void click(By by) {
        try {
            clickElement(by);
            logger.info("Clicked element: " + by);
        } catch (Exception e) {
            logger.error("Can not clicked element: " + by);
            assertFail();
        }
    }

    public void setText(By by, String text) {
        try {
            writeText(by, text);
            logger.info("Written element: " + by);
        } catch (Exception e) {
            logger.error("Can not write element: " + by);
            assertFail();
        }
    }

    public void selectValue(By by, String value) {
        try {
            selectByValue(by, value);
            logger.info("Selected element: " + by);
        } catch (Exception e) {
            logger.error("Could not select item: " + by);
            assertFail();
        }
    }

    public void verifyText(By by, String text) {
        try {
            assertEquals(getText(by), text);
            logger.info(by + " text is checked successfully");
        } catch (Exception e) {
            logger.error(by + " text is not checked successfully");
            assertFail();
        }
    }

    public void verifyPrice(By by) {
        try {
            isElementDisplayed(by);
            assertEqualsPrice(getText(by), productPrice);
            logger.info(by + " price checked successfully");
        } catch (Exception e) {
            logger.error(by + " price not checked successfully");
            assertFail();
        }
    }

    public void isDisplayed(By by) {
        try {
            isElementDisplayed(by);
            logger.info("Element is displayed successfully");
        } catch (Exception e) {
            logger.error("Element is not displayed successfully");
            assertFail();
        }
    }

    public void verifyTitle(String text) {
        try {
            assertEquals(webDriver.getTitle(), text);
            logger.info("title checked successfully");
        } catch (Exception e) {
            logger.error("title not checked successfully");
            assertFail();
        }
    }

    public void clear(By by) {
        try {
            WebElement toClear = webDriver.findElement(by);
            toClear.clear();
            toClear.sendKeys(Keys.CONTROL + "a");
            toClear.sendKeys(Keys.DELETE);
            logger.info(by + " Element field has been cleared.");
        } catch (Exception e) {
            logger.error(by + " Element field has not been cleared.");
            assertFail();
        }
    }

    public void sendKeys(By by,Keys keys) {
        try {
            sendKey(by,keys);
            logger.info(keys.toString() + "Key applied to Element field." + by);
        } catch (Exception e) {
            logger.error(keys.toString() + "Key not applied to Element field. " + by);
            assertFail();
        }
    }

    public void saveProductDescAndPrice(By desc,By price) {
        try {
            getProductDetailAndSave(desc,price);
            logger.info("Save operation successful");
        } catch (Exception e) {
            logger.error("Save failed");
            assertFail();
        }
    }
}

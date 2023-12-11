package seleniumCase;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import seleniumCase.driver.Driver;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class BaseTest extends Driver{

    public final Logger logger = LogManager.getLogger(this.getClass());

    String StringPrice;
    String StringBasketPrice;


    public void getUrl(String url) {
        webDriver.get(url);
        logger.info("Url sayfasi acildi.");
    }

    public String getExcelRow(int i)  {
        Workbook workbook = null;
        try {
            workbook = new XSSFWorkbook("input.xlsx");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(0);
        String temp = String.valueOf(row.getCell(i));

        logger.info("Excelden "+ temp +" bilgisi okundu.");
        return temp;
    }
    private static String clearData(String data) {
        data = data.replaceAll("\n", "");
        data = data.replaceAll("TL", "");
//        data = data.replaceAll(",", "");
        data = data.replaceAll("\\.", "");
        data = data.trim();
        return data;

    }


    public String getTitle() {
        logger.info("Title bilgisi getirildi.");
        return webDriver.getTitle();
    }

    public void clickByText(String text) {
        webDriver.findElement(By.xpath("//*[text()='" + text + "']")).click();
        logger.info("Text: " + text + " olan elemente tıklandı.");
    }

    public void clickByLintext(String linkText) {
        webDriver.findElement(By.linkText(linkText)).click();
        logger.info("linktext: '" + linkText + "' olan elemente tıklandı.");
    }

    public void sendById(String id, String value) {
        webDriver.findElement(By.id(id)).sendKeys(value);
        logger.info("id bilgisi '" + id + "' olan elemente '" + value + "' değeri yazıldı.");
    }

    public void sendByName(String name, String value) {
        webDriver.findElement(By.name(name)).sendKeys(value);
        logger.info("Name bilgisi '" + name + "' olan elemente '" + value + "' değeri yazıldı.");
    }

    public void sendByNameAndEnter(String name, String value) {
        webDriver.findElement(By.name(name)).sendKeys(value,Keys.ENTER);
//        webDriver.findElement(By.name(name)).sendKeys(Keys.ENTER);
        logger.info("Name bilgisi '" + name + "' olan elemente '" + value + "' değeri yazıldı.");
    }

    public void clearByName(String name) {
        WebElement toClear = webDriver.findElement(By.name(name));
        toClear.clear();
        toClear.sendKeys(Keys.CONTROL + "a");
        toClear.sendKeys(Keys.DELETE);
        logger.info("Name bilgisi '" + name + "' olan element text alani temizlendi.'");
    }

    public void clickById(String id) {
        webDriver.findElement(By.id(id)).click();
        logger.info("id bilgisi '" + id + "' olan elemente tıklandı.");
    }

    public void clickByName(String name) {
        webDriver.findElement(By.name(name)).click();
        logger.info("name bilgisi '" + name + "' olan elemente tıklandı.");
    }

    public void clickByXpath(String xpath) {
        webDriver.findElement(By.xpath(xpath)).click();
        logger.info("xpath: '" + xpath + "' olan elemente tıklandı.");

    }

    public void callHomePage() {
        webDriver.get("https://www.gittigidiyor.com/");
        logger.info("Ana Sayfa çağırıldı.");
    }

    public void clickByClassName(String className) {
        webDriver.findElement(By.className(className));
        logger.info("Class Name: '" + className + "' olan elemente tıklandı.");

    }

    public void selectById(String id, String value) {
        new Select(webDriver.findElement(By.id(id))).selectByValue(value);
        logger.info("id: '" + id + "' olan select de '" + value + "' değeri seçildi.");
    }

    public void selectByXpath(String xpath, String value) {
        new Select(webDriver.findElement(By.xpath(xpath))).selectByValue(value);
        logger.info("xpath: '" + xpath + "' olan select de '" + value + "' değeri seçildi.");
    }

    public void clickByDataCy(String dataCy) {
        webDriver.findElement(By.xpath("//*[@data-cy='" + dataCy + "']")).click();
    }

    public void sendByDataCy(String dataCy, String value) {
        webDriver.findElement(By.xpath("//*[@data-cy='" + dataCy + "']")).clear();
        webDriver.findElement(By.xpath("//*[@data-cy='" + dataCy + "']")).sendKeys(value);
        logger.info("data-cy: '" + dataCy + "' olan elemente '" + value + "' değeri yazıldı.");

    }

    public void randomSelectXpath(String xpath) {
        webDriver.navigate().refresh();
        List<WebElement> pageResult = webDriver.findElements(By.xpath(xpath));
        Random random = new Random();
        pageResult.get(random.nextInt(pageResult.size())).click();
        logger.info("Random fonksiyonu çalıştırılarak bir ürün seçilir.");
    }

    public void getByIdAndSave(String id) {
        String text = webDriver.findElement(By.id(id)).getText();
        logger.info("kaydedilen text: '" + text + "'");

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt", true));
            writer.append(text + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getItemPrice() {
        StringPrice = webDriver.findElement(By.id("sp-price-highPrice")).getText();
        StringPrice = clearData(StringPrice);
    }

    public void getBasketItemPrice() {
        StringBasketPrice = webDriver.findElement(By.xpath("//*[@class='total-price']")).getText();
        StringBasketPrice = clearData(StringBasketPrice);
        boolean check = StringBasketPrice.equals(StringPrice);
        Assert.assertTrue(check);
        logger.info("Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır.");

    }


}

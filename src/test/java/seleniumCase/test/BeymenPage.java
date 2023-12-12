package seleniumCase.test;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import seleniumCase.base.StepImplementations;
import seleniumCase.constants.HomePageConstants;
import seleniumCase.elements.HomePageElements;

public class BeymenPage extends StepImplementations {

    @Test(testName = "Search by reading data from Excel")
    public void search_by_reading_data_from_excel() throws InterruptedException {
        getUrl(HomePageElements.URL);
        verifyTitle(HomePageConstants.TITLE);

        isElementDisplayed(HomePageElements.GENDER_POPUP);
        isElementDisplayed(HomePageElements.CLOSE_GENDER_POPUP);
        click(HomePageElements.CLOSE_GENDER_POPUP);

        isElementDisplayed(HomePageElements.REEJECT_COKKIES);
        click(HomePageElements.REEJECT_COKKIES);

        isDisplayed(HomePageElements.BEYMEN_LOGO);
        setText(HomePageElements.SEARCH_INPUT_AREA, getExcelRow(0));
        wait(2); //added wait for visibility

        clear(HomePageElements.SEARCH_SUGGESTION_INPUT_AREA);
        setText(HomePageElements.SEARCH_SUGGESTION_INPUT_AREA, getExcelRow(1));
        sendKeys(HomePageElements.SEARCH_SUGGESTION_INPUT_AREA, Keys.ENTER);
//        wait(2); //added wait for visibility

        randomSelect(HomePageElements.PRODUCT_LIST);
//        wait(2); //added wait for visibility

        saveProductDescAndPrice(HomePageElements.PRODUCT_DETAIL, HomePageElements.PRODUCT_PRICE);
        click(HomePageElements.CHOOSE_FIRST_VARIATION);
        click(HomePageElements.ADD_BASKET);
//        click(HomePageElements.MY_CART);
        click(HomePageElements.GO_TO_MY_CART);

        isElementDisplayed(HomePageElements.REMOVE_CART_ITEM);
        isDisplayed(HomePageElements.REMOVE_CART_ITEM);
        isElementDisplayed(HomePageElements.SALE_PRICE);
        verifyPrice(HomePageElements.SALE_PRICE);
        click(HomePageElements.QUANTITY_SELECT);
        selectValue(HomePageElements.QUANTITY_SELECT, "2");
        verifyText(HomePageElements.QUANTITY_SELECT, "2 adet");
//        wait(5); //added wait for visibility
        isDisplayed(HomePageElements.REMOVE_CART_ITEM);
        click(HomePageElements.REMOVE_CART_ITEM);
        isDisplayed(HomePageElements.REMOVE_CART_ITEM);
        click(HomePageElements.REMOVE_CART_ITEM);
        wait(5); //added wait for visibility

    }

}

package com.Test;

import com.pages.HomePage;
import com.utills.BaseClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductFilterTest extends BaseClass {
    private HomePage homePage;

    @BeforeClass
    public void initPageObjects() {
        homePage = new HomePage(driver);
    }

    @Test
    public void launchBrowser() {
        driver.get("https://www.douglas.de/de");
        waitTill(5);
    }
}

  /*  @Test(dataProvider = "filterData")
    public void testFilterProducts(String criteria, String brand, String type, String giftFor, String forWhom) {
        driver.get("https://www.douglas.de/de");
       homePage.handleCookies();

        homePage.clickParfum();

        if ("Sale".equalsIgnoreCase(criteria)) {
            homePage.applySaleFilter();
        } else if ("Neu".equalsIgnoreCase(criteria)) {
            homePage.applyNewFilter();
        }

  @DataProvider(name = "filterData")
    public Object[][] getData() {

        return new Object[][]{
                {"Sale", "Brand1", "Type1", "-", "Anyone"},
                {"Neu", "-", "Type2", "-", "Anyone"},

        };
    }*/


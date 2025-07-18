package tests;

import io.qameta.allure.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPage;
import utils.PropertiesLoader;

import java.io.IOException;
import java.util.List;

@Epic("Regression Tests")
@Feature("Search")

public class TestCase9 extends TestBasic {
    static String search;

    static {
        try {
            search = PropertiesLoader.loadProperty("search.product.input");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(description = "Test Case 9: Search Product")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Search Product")
    @Description("""
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Click on 'Products' button
            5. Verify user is navigated to ALL PRODUCTS page successfully
            6. Enter product name in search input and click search button
            7. Verify 'SEARCHED PRODUCTS' is visible
            8. Verify all the products related to search are visible""")
    public void searchProduct() {
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        TestCase8.verifyThatDetailDetailIsVisible();
        verifyAllTheProductsRelatedToSearchAreVisible();
        verifySearchedProductsIsVisible();


    }

    @Step("Verify all the products related to search are visible")
    public static void verifyAllTheProductsRelatedToSearchAreVisible() {
        String searchedProductsText = new ProductsPage(getDriver())
                .fillSearchProductInput(search)
                .getTitleTextCenter()
                .getText();
        Assert.assertEquals(searchedProductsText,"SEARCHED PRODUCTS","Verify all the products related to search are visible");
    }

    @Step("Verify 'SEARCHED PRODUCTS' is visible")
    public static List<String> verifySearchedProductsIsVisible() {
        List<String> productsNames = new ProductsPage(getDriver()).getProductsSearchNames();
        for(int i = 0; i<productsNames.size();i++){
            Assert.assertTrue(productsNames.get(i).toLowerCase().contains(search.toLowerCase()));
            System.out.println(i + ". " + productsNames.get(i) + " - contain: " + search);
        }
        return productsNames;


    }
}

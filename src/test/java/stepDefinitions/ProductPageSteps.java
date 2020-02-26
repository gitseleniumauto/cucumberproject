package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import cucumber.TestContext;
import cucumber.api.java.en.When;
import enums.Context;
import pageObjects.ProductListingPage;

public class ProductPageSteps {

    TestContext testContext;
    ProductListingPage productListingPage;

    public ProductPageSteps(TestContext context) {
        testContext = context;
        productListingPage = testContext.getPageObjectManager().getProductListingPage();
    }

    @When("^choose to buy the first item$")
    public void choose_to_buy_the_first_item() {
        String productName = productListingPage.getProductName(1);
        testContext.getScenarioContext().setContext(Context.PRODUCT_NAME, productName);
        productListingPage.select_Product(1);
        productListingPage.select_Color(1);
        productListingPage.select_Size(1);
        productListingPage.clickOn_AddToCart();
    }
}
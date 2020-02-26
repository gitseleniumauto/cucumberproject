package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.When;
import managers.FileReaderManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.CheckoutPage;
import testDataTypes.Customer;

import java.util.List;

public class CheckoutPageSteps {
    TestContext testContext;
    CheckoutPage checkoutPage;

    public CheckoutPageSteps(TestContext context) {
        testContext = context;
        checkoutPage = testContext.getPageObjectManager().getCheckoutPage();
    }

    @When("^enter \\\"(.*)\\\" personal details on checkout page$")
    public void enter_personal_details_on_checkout_page(String customerName){
        Customer customer = FileReaderManager.getInstance().getJsonReader().getCustomerByName(customerName);
        checkoutPage.fill_PersonalDetails(customer);
    }

    @When("^select same delivery address$")
    public void select_same_delivery_address(){
        checkoutPage.check_ShipToDifferentAddress(false);
    }

    @When("^select payment method as \"([^\"]*)\" payment$")
    public void select_payment_method_as_payment(String arg1){
          checkoutPage.select_PaymentMethod("CheckPayment");
//        List<WebElement> paymentMethod = driver.findElements(By.cssSelector("ul.wc_payment_methods li"));
//        paymentMethod.get(0).click();
    }

    @When("^place the order$")
    public void place_the_order() {
        checkoutPage.check_TermsAndCondition(true);
        checkoutPage.clickOn_PlaceOrder();
    }

}
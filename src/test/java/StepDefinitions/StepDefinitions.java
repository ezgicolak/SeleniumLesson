package StepDefinitions;

import POM.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;
import java.util.List;


public class StepDefinitions extends E20_1_CreateBaseTest {

    public E19_1_POM_LoginPage loginPage;
    public E19_2_POM_ProductCatalog productCatalog;

    public E19_5_POM_CartPage cartPage;
    public E19_6_POM_CheckOutPage checkOutPage;


    public   E19_7_POM_ConfirmPage confirmPage;


    @Given("^I landed on Ecomerce Page")
    public void I_landed_on_Ecomerce_Page() throws IOException {
        loginPage = launchApplication();
    }

    @Given("Logged in with username (.+) and password (.+)$")
    public void Logged_in_with_username_and_password (String username , String password) {
        loginPage.login(username,password);
    }

    @When("I add product to cart")
    public void I_add_product_to_Cart() throws InterruptedException {
        productCatalog.addProductToCart();
        productCatalog.goToCartPage();
    }

    @When("Checkout  and submit the orders")
    public void checkout_submit_order() throws InterruptedException {


        cartPage.goToCheckOut();
        checkOutPage.selectCounrty("India");
        checkOutPage.placeOrder();
    }

    @Then("{string} massage is displayed on ConfirmationPage")
    public void massage_is_displayed_on_ConfirmationPage(String string) {

        String confirmMassage =   confirmPage.getConfirmMassage();
        Assert.assertTrue(confirmMassage.equalsIgnoreCase(string));
    }




}

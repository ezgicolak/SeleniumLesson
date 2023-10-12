package StepDefinitions;

import POM.E19_1_POM_LoginPage;
import POM.E19_3_POM_AbstractComponents;
import POM.E20_1_CreateBaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class ErrorValidationsStepDefinitions extends E20_1_CreateBaseTest {
    public E19_1_POM_LoginPage loginPage;

    private WebDriver driver;



    @Given("I landed on Login Page")
    public void i_landed_on_login_page() throws IOException {
        loginPage = launchApplication();
    }

    @When("Enter with username {string} and password {string}")
    public void enter_with_username_and_password(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);

        // Şifre alanına veriyi gir
        driver.findElement(By.id("password")).sendKeys(password);

        // Giriş butonuna tıkla
        driver.findElement(By.id("login-button")).click();
    }

    @Then("the user should see the error message {string}")
    public void the_user_should_see_the_error_message(String errorMessage) {
        Assert.assertEquals(errorMessage, loginPage.getErrorMassage());
    }
}
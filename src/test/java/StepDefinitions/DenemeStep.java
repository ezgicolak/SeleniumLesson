package StepDefinitions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class DenemeStep {
    WebDriver driver;

    @Given("User is on the login page")
    public void user_is_on_login_page() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/client/auth/login");
    }

    @When("User enters {string} into the {string} field")
    public void user_enters_value_into_field(String value, String field) {
        WebElement inputField = driver.findElement(By.id(field));
        inputField.sendKeys(value);
    }

    @And("User clicks the {string} button")
    public void user_clicks_button(String buttonName) {
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='" + buttonName + "']"));
        loginButton.click();
    }

    @Then("User should see an error message")
    public void user_should_see_an_error_message() {
        // Hata mesajını doğrulama
        WebElement errorMessage = driver.findElement(By.className("alert-danger"));
        if (errorMessage.isDisplayed()) {
            System.out.println("Giriş denemesi başarısız oldu. Hata mesajı görüntülendi.");
        } else {
            System.out.println("Hata mesajı görüntülenmedi.");
        }
        driver.quit();
    }
}
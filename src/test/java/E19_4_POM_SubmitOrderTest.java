import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class E19_4_POM_SubmitOrderTest {

    @Test
    public void test() throws IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        E19_1_POM_LoginPage loginPage = new E19_1_POM_LoginPage(driver);
        loginPage.goTo();
        loginPage.login("anshika@gmail.com","Iamking@000");
        E19_2_POM_ProductCatalog productCatalog = new E19_2_POM_ProductCatalog(driver);
        productCatalog.addProductToCart();
        productCatalog.goToCartPage();
       E19_5_POM_CartPage cartPage = new E19_5_POM_CartPage(driver);
       cartPage.goToCheckOut();
       E19_6_POM_CheckOutPage checkOutPage=new E19_6_POM_CheckOutPage(driver);
       checkOutPage.selectCounrty("India");
       checkOutPage.placeOrder();
       E19_7_POM_ConfirmPage confirmPage = new E19_7_POM_ConfirmPage(driver);
       String confirmMassage =   confirmPage.getConfirmMassage();
       Assert.assertTrue(confirmMassage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));














    }

}

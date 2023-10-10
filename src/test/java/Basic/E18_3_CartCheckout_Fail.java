package Basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class E18_3_CartCheckout_Fail {

    @Test
    public void test() throws IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/client");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@id=\"userEmail\"]"))
                .sendKeys("anshika@gmail.com");

        driver.findElement(By.xpath("//*[@id=\"userPassword\"]"))
                .sendKeys("Iamking@000");

        driver.findElement(By.xpath("//*[@id=\"login\"]"))
                .click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"products\"]/div[1]/div[2]/div[1]/div/div/button[2]")));


        driver.findElement(By.xpath("//*[@id=\"products\"]/div[1]/div[2]/div[1]/div/div/button[2]")).click();



        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"toast-container\"]")));



        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));


        driver.findElement(By.xpath("/html/body/app-root/app-dashboard/app-sidebar/nav/ul/li[4]/button")).click();

        String productname = "ZARA COAT 3" ;

        List<WebElement> cartproducts = driver.findElements(By.xpath("/html/body/app-root/app-profile/div/div[2]"));



       boolean match = cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productname));
       Assert.assertTrue(match);

       driver.findElement(By.xpath("/html/body/app-root/app-profile/div/div[3]/ul/li[3]/button")).click();








    }
}

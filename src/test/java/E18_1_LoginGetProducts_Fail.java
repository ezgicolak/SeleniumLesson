import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.List;

public class E18_1_LoginGetProducts_Fail {

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


        List<WebElement> products = driver.
                findElements(By.cssSelector(".mb-3"));


        WebElement prod = products.stream().filter(product ->product.findElement(By.cssSelector("b")).getText()
                .equals("zara coat 3")).findFirst().orElse(null);
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();





    }



    }

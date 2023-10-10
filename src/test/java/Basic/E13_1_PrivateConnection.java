package Basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class E13_1_PrivateConnection {


    @Test

    public void test() {

        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());

        driver.close();



    }
}

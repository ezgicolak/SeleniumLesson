package Basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.List;

public class E13_3_BrokenLinkFind {

    @Test

    public void test() throws IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

        List<WebElement> links=   driver.findElements(By.cssSelector("li[class='gf-li'] a"));

        SoftAssert a =new SoftAssert();



        for(WebElement link : links)

        {



            String url= link.getAttribute("href");



            HttpURLConnection   conn= (HttpURLConnection)new URL(url).openConnection();

            conn.setRequestMethod("HEAD");

            conn.connect();

            int respCode = conn.getResponseCode();

            System.out.println(respCode);

            a.assertTrue(respCode<400, "The link with Text"+link.getText()+" is broken with code" +respCode);





        }



        a.assertAll();
        driver.quit();




    }

    }

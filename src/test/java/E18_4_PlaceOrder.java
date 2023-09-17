import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class E18_4_PlaceOrder {
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

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-profile/div/div[3]/ul/li[3]/button")));
        driver.findElement(By.xpath("/html/body/app-root/app-profile/div/div[3]/ul/li[3]/button")).click();

        Actions a = new Actions(driver);

        a.sendKeys(driver.findElement(By.xpath("/html/body/app-root/app-order/section/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div[1]/div/input"))
                ,"India").build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-order/section/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div[1]/div/section/button[1]/span")));


        driver.findElement(By.xpath("/html/body/app-root/app-order/section/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div[1]/div/section/button[1]/span")).click();

        driver.findElement(By.xpath("/html/body/app-root/app-order/section/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div[2]/a")).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"htmlData\"]/tbody/tr[4]/td/table/tbody/tr/td/table/tbody/tr[1]/td/h1")));
        String confirmMassage = driver.findElement(By.cssSelector(".hero-primary")).getText();

        System.out.println(confirmMassage);

        Assert.assertTrue(confirmMassage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));










    }
}

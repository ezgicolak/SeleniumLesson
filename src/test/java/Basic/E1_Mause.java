package Basic;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;

public class E1_Mause {

    @Test

    public void test(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com.tr/?&tag=trtxtgoabkde-21&ref=pd_sl_7r6v9rntlw_e&adgrpid=119366379979&hvpone=&hvptwo=&hvadid=542862704348&hvpos=&hvnetw=g&hvrand=498880168624042916&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9056872&hvtargid=kwd-10573980&hydadcr=12932_2246093&language=tr_TR");
        driver.manage().window().maximize();

        WebElement move = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"));

        Actions a = new Actions(driver);

        a.moveToElement(driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
        a.moveToElement(move).contextClick().build().perform();


    }
}





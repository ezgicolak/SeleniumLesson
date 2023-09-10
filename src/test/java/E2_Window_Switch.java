import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class E2_Window_Switch {

    @Test

    public void test(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("/html/body/a")).click();

        Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId]

        Iterator<String>it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);

        System.out.println(driver.findElement(By.xpath("//*[@id=\"interview-material-container\"]/div/div[2]/p[2]")).getText());



    }

}

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.sql.SQLOutput;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class E5_Frame_Advenced {

    @Test

    public void test(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

        // 1. Give me a count of links this page

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("the number of links is " + links.size());

        // 2. Give me a count of links in footer

        WebElement footerdriver = driver.findElement(By.xpath("//*[@id=\"gf-BIG\"]"));
        List<WebElement> footerdriverlinks = footerdriver.findElements(By.tagName("a"));
        System.out.println("the number of footerdriverlinks is " + footerdriverlinks.size());

        // 3. Give me a count of links in footer first column

        WebElement footerdrivercolumn  = driver.findElement(By.xpath("//*[@id=\"gf-BIG\"]/table/tbody/tr/td[1]/ul"));
        List<WebElement> footerdrivercolumnlinks = footerdrivercolumn.findElements(By.tagName("a"));
        System.out.println("the number of footerdrivercolumnlinks is " + footerdrivercolumnlinks.size());

        // 4. Click on each link and check if the pages are opening

        for(int i=1; i<footerdrivercolumnlinks.size();i++){

            String clickonlinktab = Keys.chord(Keys.CONTROL, Keys.ENTER);

            footerdrivercolumnlinks.get(i).sendKeys(clickonlinktab);



            //* 5. Get site titles ---ÇALIŞMIYOR ----
            //  Set<String> abc = driver.getWindowHandles();
            //  Iterator<String> it =abc.iterator();
            //
            // while(it.hasNext()){
            //
            //  driver.switchTo().window(it.next());
            //  System.out.println(driver.getTitle());
            //  }







        }












    }




}

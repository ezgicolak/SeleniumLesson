import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

public class E14_Streams2_TableSorting {

    @Test
    public void test(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.manage().window().maximize();

        //click on column
        driver.findElement(By.xpath("//tr/th[1]")).click();

        //capture all web elements into list
        List<WebElement> elementlist = driver.findElements(By.xpath("//tr/td[1]"));

        //capture text of all web elements into new(original) list
        List<String> originallist = elementlist.stream().map(s->s.getText()).collect(Collectors.toList());

        //sort on the original list of step 3 -> sorted list
        List<String>sortedList = originallist.stream().sorted().collect(Collectors.toList());

        //compare original list vs sorted list
        Assert.assertTrue(originallist.equals(sortedList));




    }



}

package Basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

public class E14_Streams3_GetPrice {
    @Test
    public void test() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.manage().window().maximize();

        //scan the  anem column with get Text -- Beans --- print the price of the Rice

        driver.findElement(By.xpath("//tr/th[1]")).click();
        List<WebElement> elementlist = driver.findElements(By.xpath("//tr/td[1]"));

        List<String> price = elementlist.stream().filter(s -> s.getText().contains("Beans"))
                .map(s -> getPriceVeggie(s)).collect(Collectors.toList());

        price.forEach(a->System.out.println(a));


    }

    private static String getPriceVeggie(WebElement s) {

        String pricevalue= s.findElement(By.xpath("following-sibling::td[1]"))
                .getText();

        return pricevalue ;


    }
}




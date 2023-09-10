import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class E4_Frame {
    @Test

    public void test(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"content\"]/iframe")));
        Actions a = new Actions(driver);
        WebElement source = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
        WebElement target = driver.findElement(By.xpath("//*[@id=\"droppable\"]"));

        a.dragAndDrop(source,target).build().perform();





    }


}

package Basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class E15_3_ElementScreenshot {

    @Test
    public void test() throws IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.manage().window().maximize();


        //Switching Window

        driver.switchTo().newWindow(WindowType.WINDOW);

        Set<String> handles=driver.getWindowHandles();

        Iterator<String> it=handles.iterator();

        String parentWindowId = it.next();

        String childWindow =it.next();

        driver.switchTo().window(childWindow);

        driver.get("https://rahulshettyacademy.com/");

        String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))

                .get(1).getText();

        driver.switchTo().window(parentWindowId);

        WebElement name=driver.findElement(By.cssSelector("[name='name']"));

        name.sendKeys(courseName);

//Screenshot

        File file=name.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(file, new File("logo.png"));

//driver.quit();


    }



    }
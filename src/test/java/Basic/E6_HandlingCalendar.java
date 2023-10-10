package Basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.sql.Time;
import java.util.List;

public class E6_HandlingCalendar {

    @Test

    public void test(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.path2usa.com/travel-companions");
        driver.manage().window().maximize();

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,750)");


        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException ie){
        }


        //April 23
        WebElement date =  driver.findElement(By.xpath("//*[@id=\"travel_comp_form\"]/div/div[3]"));

        Actions actions = new Actions(driver);

        actions.moveToElement(date).click().perform();


        //while(!driver.findElement(By.xpath("/html/body/div[10]/div[1]/div/span")).getText().contains("May"))
        //{
         //   driver.findElement(By.xpath("/html/body/div[10]/div[1]/span[2]")).click();
        //}


        String day = "20";

        String month_name = "";




        while(!month_name.equals("October")){
            driver.findElement(By.xpath("/html/body/div[10]/div[1]/span[2]")).click();
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException ie){
            }
            WebElement current_month = driver.findElement(By.xpath("/html/body/div[10]/div[1]/div/span"));
            month_name = current_month.getText();
            System.out.println(month_name);

        }

        List<WebElement> dates= driver.findElements(By.className("day"));
        //Grab common attribute//Put into list and iterate
        int count=driver.findElements(By.className("day")).size();

        for(int i=0;i<count;i++)
        {
            String text=driver.findElements(By.className("day")).get(i).getText();
            if(text.equalsIgnoreCase("21"))
            {
                driver.findElements(By.className("day")).get(i).click();
                break;
            }

        }









    }
}

import java.util.List;

import java.util.stream.Collectors;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;



public class E14_Streams5_FilterTheWebTable {



    @Test
    public void test() {

// TODO Auto-generated method stub

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.manage().window().maximize();


        driver.findElement(By.id("search-field")).sendKeys("Rice");

        List<WebElement> veggies=driver.findElements(By.xpath("//tr/td[1]"));

        //1 results

        List<WebElement> filteredList= veggies.stream().filter(veggie->veggie.getText().contains("Rice")).

                collect(Collectors.toList());

        //1 result

        Assert.assertEquals(veggies.size(), filteredList.size());


    }



}



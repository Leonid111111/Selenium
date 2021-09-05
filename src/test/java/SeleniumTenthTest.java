import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;



public class SeleniumTenthTest {




    @Test
    public void checkOrangSmiles(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://www.seleniumeasy.com/test/");


        try {
            WebElement closeWindowButton = driver.findElement((By.xpath("//a[@id='at-cv-lightbox-close']")));
            closeWindowButton.click();
        } catch (Exception e) {
            System.out.println("Windows not found");
        }

        WebElement tableClick = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']//*[contains(text(),'Table')]"));
        tableClick.click();

        WebElement tableFilterClick = driver
                .findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]//a[contains(text(), 'Table Filter ')]"));
        tableFilterClick.click();

        WebElement orangeButtonClick = driver
                .findElement(By.xpath("//button[@class='btn btn-warning btn-filter']"));
        orangeButtonClick.click();

        String getColor =driver.findElement(By.xpath("//span[@class='pull-right pendiente']")).getText();
        String getColor2 = driver.findElement(By.xpath("(//span[@class='pull-right pendiente'])[2]")).getText();

        System.out.println(getColor);
        System.out.println(getColor2);

        Assert.assertTrue(getColor.contains("Orange"));
        Assert.assertTrue(getColor2.contains("Orange"));

        driver.quit();







    }


}

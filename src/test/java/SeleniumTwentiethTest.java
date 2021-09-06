import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class SeleniumTwentiethTest {


    @Test
    public void checkOptionsWithText() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

        driver.get("https://www.seleniumeasy.com/test/");

        try {
            WebElement closeWindowButton = driver.findElement((By.xpath("//a[@id='at-cv-lightbox-close']")));
            closeWindowButton.click();

        } catch (Exception e) {
            System.out.println("Window not found");
        }

        WebElement listBoxClick = driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right']/li[3]"));
        listBoxClick.click();

        WebElement bootstrapListBox = driver
                .findElement(By.xpath("//div[@id=\"navbar-brand-centered\"]//a[contains(text(), 'Bootstrap List Box')]"));
        bootstrapListBox.click();

        String desiredValue = driver.findElement(By.xpath("//ul[@class='list-group']//li[3]")).getText();
        System.out.println(desiredValue);

        WebElement selectOption = driver.findElement(By.xpath("//ul[@class='list-group']//li[3]"));
        selectOption.click();

        WebElement rightButtonClick = driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-chevron-right']"));
        rightButtonClick.click();

        String extractText = driver.findElement(By.xpath("(//ul[@class='list-group'])[2]")).getText();

        String [] text = extractText.split("\n");


        int count = 0;
        for(String word:text) {
            if (word.equals(desiredValue)) {
                count++;
            }
        }



        Assert.assertEquals(count, "2");




        driver.quit();


    }


}

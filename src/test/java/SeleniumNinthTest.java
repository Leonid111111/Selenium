import com.sun.deploy.util.Waiter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SeleniumNinthTest {


    @Test
    public void TestNinthSolution() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.seleniumeasy.com/test/");

        try {
            WebElement closeWindowButton = driver.findElement((By.xpath("//a[@id='at-cv-lightbox-close']")));
            closeWindowButton.click();

        } catch (Exception e) {
            System.out.println("Window not found");
        }

        WebElement tableClick = driver
                .findElement(By.xpath("//ul[@class='nav navbar-nav']//*[contains(text(),'Table')]"));
        tableClick.click();

        WebElement tableDataSearchClick = driver
                .findElement(By.xpath("//*[contains(text(),'Table Data Search')]"));
        tableDataSearchClick.click();

        WebElement enterEmiliJohn = driver
                .findElement(By.xpath("//*[@id='task-table-filter']"));
        enterEmiliJohn.sendKeys("Emily John");



    }

}

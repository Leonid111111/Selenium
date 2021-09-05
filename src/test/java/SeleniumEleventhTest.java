import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SeleniumEleventhTest {




    @Test
    public void checkTestAppears() throws InterruptedException {
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

        WebElement alertModalsClick = driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right']/li[2]"));
        alertModalsClick.click();

        WebElement javascriptAlertClick = driver
                .findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right']//*[contains(text(),'Javascript Alerts')]"));
        javascriptAlertClick.click();

        WebElement javaScriptConfirmBoxClick = driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']"));
        javaScriptConfirmBoxClick.click();

        Alert alert = driver.switchTo().alert();
//        String alertMassege = driver.switchTo().alert().getText();
        Thread.sleep(3000);
        alert.dismiss();
//        System.out.println(alertMassege);

        String cheackText = driver.findElement(By.xpath("//p[contains(text(), 'You pressed Cancel!')]")).getText();

        Assert.assertEquals(cheackText, "You pressed Cancel!");



        driver.quit();




    }
}

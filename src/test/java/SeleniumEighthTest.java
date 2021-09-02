import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import sun.util.resources.LocaleData;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class SeleniumEighthTest {

    @Test
    public void checkTheDate() {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 3);

        driver.get("https://www.seleniumeasy.com/test/");

        try {
            WebElement popUpClose = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//*[@id='at-cv-lightbox-close']")));
            popUpClose.click();


        } catch (Exception e) {
            System.out.println("Pop-up window not detected");

        }

        WebElement datePickersClick = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//*[@id='navbar-brand-centered']/descendant::a[9]")));
        datePickersClick.click();

        WebElement bootstrapDateClick = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//*[contains(text(),'Bootstrap Date Picker')]")));
        bootstrapDateClick.click();

        WebElement dateExampleSelect = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//*[@class='input-group-addon']/preceding-sibling::input")));
        dateExampleSelect.click();


        LocalDate yesterday = LocalDate.now().minusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formatedDate = yesterday.format(formatter);

        System.out.println(formatedDate);

//        WebElement justClick = driver.findElement(By.xpath("//*[contains(text(),'Date Example :')]"));
//        justClick.click();


        dateExampleSelect.sendKeys(formatedDate);

        String yesterdayDate = driver.findElement(By.xpath("//*[@placeholder='dd/mm/yyyy']"))
                .getAttribute("value");

        System.out.println(yesterdayDate);
        Assert.assertTrue(yesterdayDate.equals(formatedDate));

        driver.quit();





    }


}

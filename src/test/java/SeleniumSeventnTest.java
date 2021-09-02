import com.sun.javafx.css.converters.ColorConverter;
import org.jsoup.select.Evaluator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.time.Instant;
import java.util.Arrays;

public class SeleniumSeventnTest extends ParentClass {


    @Test
    public void seven() {

        WebDriverWait wait = new WebDriverWait(driver, 3);

        WebElement ajaxFormSubmitClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='dropdown-menu']//li[6]")));
        ajaxFormSubmitClick.click();

        WebElement ajaxFormClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='btn-submit']")));
        ajaxFormClick.click();

        String colorBorderField = driver.findElement(By.xpath("//*[@class='form-control']")).getCssValue("border");
        System.out.println(colorBorderField);


        Assert.assertTrue(colorBorderField.contains("255, 0, 0"));









    }

}







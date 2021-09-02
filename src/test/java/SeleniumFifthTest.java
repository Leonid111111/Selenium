import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.List;
import java.util.Set;

public class SeleniumFifthTest {




    @Test
    public void daySelectFriday(){
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/");

        WebDriverWait wait = new WebDriverWait(driver,5);

        try{
            WebElement closeWindowsButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='at-cv-lightbox-close']")));
            closeWindowsButton.click();
        }catch (Exception e){
            System.out.println("Window not found");
        }

        WebElement inputFormsClick = wait
                .until(ExpectedConditions
                        .elementToBeClickable(By.xpath("//li[@class='dropdown']//a[contains(text(),'Input Forms')]")));
        inputFormsClick.click();

        WebElement selectDropdownList = wait
                .until(ExpectedConditions
                        .elementToBeClickable(By.xpath("//ul[@class='dropdown-menu']//li[4]")));
        selectDropdownList.click();

        WebElement selectListDemoClickOnFriday = wait
                .until(ExpectedConditions
                        .elementToBeClickable(By.xpath("//option[@value='Friday']")));
        selectListDemoClickOnFriday.click();

        String actualTextFriday = driver.findElement(By.xpath("//p[@class='selected-value']")).getText();
        Assert.assertTrue(actualTextFriday.contains("Friday"));


        driver.quit();

    }






}

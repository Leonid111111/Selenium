import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class SeleniumSixthTest {


    @Test
    public static void ModuleCheckOptionsSelected() {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/");

        WebDriverWait wait = new WebDriverWait(driver, 2);

        try {
            WebElement closePopup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='at-cv-lightbox-close']")));
            closePopup.click();
        } catch (Exception e) {
            System.out.println("Windows not found");
        }

        WebElement inputFormClick = wait
                .until(ExpectedConditions
                        .elementToBeClickable(By.xpath("//li[@class='dropdown']//a[contains(text(),'Input Forms')]")));
        inputFormClick.click();

        WebElement selectDropdownList =
                wait.until(ExpectedConditions
                        .elementToBeClickable(By.xpath("//ul[@class='dropdown-menu']//li[4]")));
        selectDropdownList.click();

        WebElement multiSelectListNY = driver
                .findElement(By.xpath("//option[@value='New York']"));
        WebElement multiSelectListFlorida = driver
                .findElement(By.xpath("//option[@value='Florida']"));

        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL)
                .click(multiSelectListNY)
                .click(multiSelectListFlorida)
                .keyUp(Keys.CONTROL)
                .build()
                .perform();


//
//        Actions action = new Actions(driver);
//        action.keyDown(Keys.CONTROL).click(multiSelectListNY).
//                click(multiSelectListFlorida).keyUp(Keys.CONTROL).
//        build().perform();
        




//        action.moveToElement(multiSelectListNY).keyDown(Keys.CONTROL).click().
//                moveToElement(multiSelectListFlorida).click().build().perform();

//        WebElement select = driver.findElement(By.xpath("//*[@id='multi-select']"));
//        List<WebElement> options = new ArrayList<>();


//        System.out.println(options.size());

//        WebElement multiSelectListDemo1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[@value='New York']")));
//        ctrl.keyDown(Keys.CONTROL).build().perform();
//        multiSelectListDemo1.click();




//        WebElement multiSelectListDemo1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[@value='New York']")));
//        action.keyDown(Keys.CONTROL).build().perform();
//        multiSelectListDemo1.click();
//
////
//        WebElement multiSelectListDemo2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[@value='Florida']")));
//        multiSelectListDemo2.click();

//        action.keyUp(Keys.CONTROL);

        WebElement getAllSelected = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='printAll']")));
        getAllSelected.click();



        WebElement getValue = driver.findElement(By.xpath("//p[@class='getall-selected']"));
        String getValue1 = getValue.getText();
        System.out.println(getValue1);
//
//        WebElement getValue2 = driver.findElement(By.xpath("//*[@id='multi-select']"));
//        String getAllValue = getValue2.getText();
//        System.out.println(getAllValue);



    }


}




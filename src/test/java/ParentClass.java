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


public class ParentClass {


    WebDriver driver;


    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/");

        WebDriverWait wait = new WebDriverWait(driver, 5);

        try {
            WebElement closeWindowButton = wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//a[@id='at-cv-lightbox-close']"))));
            closeWindowButton.click();
        } catch (Exception e) {
            System.out.println("Window not found");
        }

        WebElement inputForms = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='dropdown']//a[contains(text(),'Input Forms')]")));
        inputForms.click();


    }
//        @AfterMethod
        public void exitMethod() {
        driver.quit();
        }

}
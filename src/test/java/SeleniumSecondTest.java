import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumSecondTest extends SeleniumFirstTest {

    @Test
    public void SeleniumSecondTest() {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/");

        WebDriverWait wait = new WebDriverWait(driver, 5);

        try {
            WebElement closeWindowButton = wait.until(ExpectedConditions
                    .elementToBeClickable((By.xpath("//a[@id='at-cv-lightbox-close']"))));
            closeWindowButton.click();
        } catch (Exception e) {
            System.out.println("Window not found");
        }

        WebElement inputForms = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[@class='dropdown']//a[contains(text(),'Input Forms')]")));
        inputForms.click();


        WebElement simpleFormDemo = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//ul[@class='dropdown-menu']//li[1]")));
        simpleFormDemo.click();

        WebElement enterValue = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//*[@id='sum1']")));
        enterValue.click();

        enterValue.findElement(By.xpath("//*[@id='sum1']")).sendKeys("20");

        WebElement enterValue2 = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//*[@id='sum2']")));
        enterValue2.click();

        enterValue2.findElement(By.xpath("//*[@id='sum2']")).sendKeys("30");

        WebElement getTotal = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//button[@onclick='return total()']")));
        getTotal.click();

        String totalAB = driver.findElement(By.xpath("//span[@id='displayvalue']")).getText();
        Assert.assertEquals(totalAB, "50");

        driver.quit();

    }


}

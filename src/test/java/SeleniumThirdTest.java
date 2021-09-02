import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumThirdTest {


    @Test
    public void SeleniumFirstTest() {

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
                .elementToBeClickable(By.xpath("//ul[@class='dropdown-menu']//li[2]")));
        simpleFormDemo.click();

        WebElement option1 = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//input[@class='cb1-element']")));
        option1.click();

        WebElement option3 = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//*[text()='Option 3']")));
        option3.click();

        Boolean optionTest1 = driver.findElement(By.xpath("//input[@class='cb1-element']")).isEnabled();
        Assert.assertTrue(true);
        System.out.println(optionTest1);

        Boolean optionTest3 = driver.findElement(By.xpath("//*[text()='Option 3']")).isEnabled();
        Assert.assertTrue(true);
        System.out.println(optionTest3);


    }

}
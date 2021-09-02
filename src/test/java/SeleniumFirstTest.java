import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.Assert;

public class SeleniumFirstTest {

    @Test
    public void SeleniumFirstTest() {

    WebDriverManager.chromedriver().setup();

    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.seleniumeasy.com/test/");

    WebDriverWait wait = new WebDriverWait(driver, 5);


        try{
            WebElement closeWindowButton = wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//a[@id='at-cv-lightbox-close']"))));
            closeWindowButton.click();
        }catch (Exception e){
            System.out.println("Window not found");
        }

        WebElement inputForms = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='dropdown']//a[contains(text(),'Input Forms')]")));
        inputForms.click();


        WebElement simpleFormDemo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='dropdown-menu']//li[1]")));
        simpleFormDemo.click();

        WebElement enterMessage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='user-message']")));
        enterMessage.click();

        enterMessage.findElement(By.xpath("//input[@id='user-message']")).sendKeys("Hello, my name is");

        WebElement showMessageButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-default'][contains(text(),'Show Message')]")));
        showMessageButton.click();

        String actualText = driver.findElement(By.xpath("//span[@id='display']")).getText();
        Assert.assertEquals(actualText, "Hello, my name is");




        driver.quit();



    }

}

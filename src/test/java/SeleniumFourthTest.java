import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumFourthTest {

    @Test
    public void SeleniumFourthTest() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 2);

        driver.get("https://www.seleniumeasy.com/test/");

        try {
            WebElement closeWindowsButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='at-cv-lightbox-close']")));
            closeWindowsButton.click();
        } catch (Exception e) {
            System.out.println("Window not found");
        }

        WebElement inputForm = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='dropdown']//a[contains(text(),'Input Forms')]")));
        inputForm.click();

        WebElement ratioButtonDemo = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='dropdown-menu']//li[3]")));
        ratioButtonDemo.click();

        WebElement clickOnButtonSex = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'panel-default')][2]//*[@value='Female']")));
        clickOnButtonSex.click();

        WebElement clickOnButtonAge = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@value='15 - 50']")));
        clickOnButtonAge.click();

        WebElement getValueButton = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-default'][contains(text(),'Get values')]")));
        getValueButton.click();


        WebElement getValue = driver.findElement(By.xpath("//*[@class='groupradiobutton']"));
        String getValueText = getValue.getText();
        System.out.println(getValueText);

        String getValue1 = driver.findElement(By.xpath("//*[@class='groupradiobutton']")).getText();
        Assert.assertEquals(getValue1, "Sex : Female\n" +
                "Age group: 15 - 50");


    }


}

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class SeleniumFourteenthTest {


    @Test
    public void cheackOptionsDualListBox() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

        driver.get("https://www.seleniumeasy.com/test/");

        try {
            WebElement closeWindowButton = driver.findElement((By.xpath("//a[@id='at-cv-lightbox-close']")));
            closeWindowButton.click();
        } catch (Exception e) {
            System.out.println("Window not found");
        }

        WebElement listBoxClick = driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right']/li[3]"));
        listBoxClick.click();

        WebElement jQweryListBoxClick = driver.findElement(By.xpath("//a[contains(text(), 'JQuery List Box')]"));
        jQweryListBoxClick.click();

        WebElement aliceAdd = driver.findElement(By.xpath("//option[contains(text(), 'Alice')]"));
        String alice = aliceAdd.getText();

        WebElement lauraAdd = driver.findElement(By.xpath("//option[contains(text(), 'Laura')]"));
        String laura = lauraAdd.getText();

        WebElement giovannaAdd = driver.findElement(By.xpath("//option[contains(text(), 'Giovanna')]"));
        String giovanna = giovannaAdd.getText();


        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL);
        aliceAdd.click();
        lauraAdd.click();
        giovannaAdd.click();
        action.keyUp(Keys.CONTROL)
                .build()
                .perform();

        WebElement addClick = driver.findElement(By.xpath("//button[@class='pAdd btn btn-primary btn-sm']"));
        addClick.click();

        String rightSideCheck = driver
                .findElement(By.xpath("//select[@class='form-control pickListSelect pickListResult']")).getText();

        String[] rightOptions = rightSideCheck.split("\n");
        Arrays.sort(rightOptions);
        for (int i = 0; i < rightOptions.length; i++) {
        }


        String[] movedItems = {alice, laura, giovanna};
        Arrays.sort(movedItems);
        for (int j = 0; j < movedItems.length; j++) {
        }

        Arrays.equals(rightOptions, movedItems);


        driver.quit();


    }


}

//public class FirstTest {
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.Test;
//
//    public class FirstTest {
//
//        WebDriver driver;
//
//        @Test
//        public void testFirst() throws InterruptedException {
//
//            WebDriverManager.chromedriver().setup();
//
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
//            driver.get("https://novaposhta.ua/");
//
//            WebDriverWait wait = new WebDriverWait(driver, 5);
//            WebElement enterButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='logo_in']//span")));
//            enterButton.click();
//
//            WebElement signUpButton = wait.until(ExpectedConditions
//                    .elementToBeClickable(By.xpath("//a//span[@class='mat-button-wrapper']")));
//            signUpButton.click();
//
//            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='selectIcon']")))
//                    .click();
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Русский']")))
//                    .click();
//
//            String actualText = driver.findElement(By.xpath("//h1[@class='infoScreen_title']")).getText();
//
//            Assert.assertEquals(actualText, "Welcome to Nova Poshta");
//
//        }
//
//        @AfterMethod(alwaysRun = true)
//        public void after() {
//            driver.quit();
//        }
//
//    }
//
//
//}
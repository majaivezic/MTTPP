import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/*****************************************************************************
 * Author: Maja Ivezic
 * Description: This is the first Selenium TestNG test.
 * It opens automationpractice homepage, login and check is it Sign out btn visible.
 *******************************************************************************/
public class FirstTest {
    //-----------------------------------Global Variables-----------------------------------
    //Declare a Webdriver variable
    public WebDriver driver;
    //Declare a test URL variable
    public String testURL = "https://www.wish.com/";
    //-----------------------------------Test Setup-----------------------------------
    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        //Create a new ChromeDriver
        driver = new ChromeDriver();

        driver.navigate().to(testURL);
    }
    @Test
    public void loginFail() throws  InterruptedException {
        WebElement loginBox = driver.findElement(By.xpath("//*[@id=\"signup-form\"]/div[4]"));
        loginBox.click();
        Thread.sleep(1000);
        WebElement email = driver.findElement(By.xpath("//*[@id=\"test-le\"]"));
        email.sendKeys("jdemail@gmail.com");
        Thread.sleep(1000);
        WebElement pass = driver.findElement(By.xpath("//*[@id=\"test-lp\"]"));
        pass.sendKeys("pass123");
        Thread.sleep(1000);
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"test-elf\"]/button"));
        loginButton.click();
        Thread.sleep(1000);

    }
    @Test
    public void loginSuccess() throws  InterruptedException {
        WebElement loginBox = driver.findElement(By.xpath("//*[@id=\"signup-form\"]/div[4]"));
        loginBox.click();
        Thread.sleep(1000);
        WebElement email = driver.findElement(By.xpath("//*[@id=\"test-le\"]"));
        email.sendKeys("jdemail@gmail.com");
        Thread.sleep(1000);
        WebElement pass = driver.findElement(By.xpath("//*[@id=\"test-lp\"]"));
        pass.sendKeys("pass123janedoe");
        Thread.sleep(1000);
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"test-elf\"]/button"));
        loginButton.click();
        Thread.sleep(5000);

    }
    @Test void search() throws InterruptedException {
        loginSuccess();
        Thread.sleep(1000);
        WebElement search = driver.findElement(By.xpath("//*[@id=\"react-app\"]/div/div[1]/div[1]/div/div[2]/div[1]/div[1]/input"));
        search.sendKeys("watch");
        Thread.sleep(1000);

    }
    @Test void clickBuyNow() throws InterruptedException {
        loginSuccess();
        Thread.sleep(5000);
        WebElement search2 = driver.findElement(By.xpath("//*[@id=\"react-app\"]/div/div[4]/div/div/div/div[1]/div/div[4]/div[3]"));
        search2.click();
        Thread.sleep(5000);
    }
    @Test void AddList() throws InterruptedException {
        clickBuyNow();
        Thread.sleep(5000);
        WebElement search2 = driver.findElement(By.xpath("//*[@id=\"react-app\"]/div/div[1]/div[1]/div/div[2]/div[2]/div"));
        search2.click();
        Thread.sleep(5000);
        WebElement click = driver.findElement(By.xpath("//*[@id=\"react-app\"]/div/div[1]/div[3]/div/div/div[2]/div[1]/div[2]"));
        click.click();
        WebElement newList = driver.findElement(By.xpath("//*[@id=\"react-app\"]/div/div[2]/div/div/div/div[2]/div[2]/div[1]/div/input"));
        newList.sendKeys("newlist");
        Thread.sleep(2000);
        WebElement click2 = driver.findElement(By.xpath("//*[@id=\"react-app\"]/div/div[2]/div/div/div/div[2]/div[2]/div[2]"));
        click2.click();
        Thread.sleep(2000);
    }
    //-----------------------------------Test TearDown-----------------------------------
    @AfterMethod
    public void teardownTest(){
        //Close browser and end the session
        driver.quit();
    }
}

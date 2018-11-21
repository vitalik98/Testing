package tests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SearchPage;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class CheckTest {

    public static WebDriver driver;
    public static SearchPage page;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        page = new SearchPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.pobeda.aero/");
    }
    @Test
    public void checkSeatAmount() throws InterruptedException {
        page.seatAmount.clear();
        page.seatAmount.sendKeys("0");
        sleep(10000);
        Assert.assertEquals(page.searchButton.getAttribute("disabled"), "true");
    }
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}

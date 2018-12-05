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

    private static WebDriver driver;
    private static SearchPage page;

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
        page.getSeatAmount().clear();
        page.getSeatAmount().sendKeys("0");
        sleep(1000);
        Assert.assertTrue(page.searchButtonIsDisabled());
    }
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}

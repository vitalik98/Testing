package by.bsu.mazanik;

import by.bsu.mazanik.pages.SearchPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Tests {
    WebDriver driver;
    SearchPage sPage;

    @Before
    public void openPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox"); // Bypass OS security model
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.pobeda.aero/");
        sPage = new SearchPage(driver);
    }

    //TODO @Tests
    @Test
    public void checkMinimumSeatAmount() {
        sPage.fillSeatAmount("0");
        Assert.assertTrue(sPage.searchButtonIsDisabled());
    }

    @Test
    public void checkMaximumSeatAmount() {
        sPage.fillSeatAmount("100");
        Assert.assertEquals("9", sPage.getSeatAmountValue());
    }

    @After
    public void close() {
        driver.quit();
        driver = null;
    }
}

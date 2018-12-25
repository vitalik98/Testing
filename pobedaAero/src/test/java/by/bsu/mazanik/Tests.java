package by.bsu.mazanik;

import by.bsu.mazanik.pages.RoutePage;
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
    RoutePage rPage;

    @Before
    public void openPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.pobeda.aero/");
        sPage = new SearchPage(driver);
        rPage = new RoutePage(driver);
    }

    //TODO @Tests
    @Test
    public void checkMinimumSeatAmount() {
        sPage.fillSeatAmount("0");
        Assert.assertTrue(sPage.searchButtonIsDisabled());
    }

    @Test
    public void checkHotelSearchChanges(){
        sPage.fillArrivalStation("Калининград");
        Assert.assertEquals("НАЙТИ ОТЕЛЬ В Г. КАЛИНИНГРАД", sPage.getHotelLabelValue());
    }

    @Test
    public void checkWrongArrivalStation(){
        sPage.fillArrivalStation("example");
        sPage.getHotelCheckBox().click();
        sPage.getSearchButton().click();
        Assert.assertEquals("Москва (Внуково)АланияМосква (Внуково)", rPage.getPathValue());
    }

    @Test
    public void checkWrongDepartureStation(){
        sPage.fillDepartureStation("example");
        sPage.getHotelCheckBox().click();
        sPage.getSearchButton().click();
        Assert.assertEquals("Москва (Внуково)АланияМосква (Внуково)", rPage.getPathValue());
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

package by.bsu.mazanik;

import by.bsu.mazanik.pages.InfoPage;
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
    InfoPage iPage;

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
        rPage = new RoutePage(driver);
        iPage = new InfoPage(driver);
    }

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
    public void checkAccompaniment(){
        sPage.closeBackdrop();
        sPage.getHotelCheckBox().click();
        sPage.clickSearch();
        rPage.clickContinue();
        iPage.fillDayOfBirth("1");
        iPage.fillMonthOfBirth("январь");
        iPage.fillYearOfBirth("2003");
        Assert.assertEquals("СОПРОВОЖДЕНИЕ РЕБЁНКА (5-16 ЛЕТ) ВО ВРЕМЯ ПОЛЁТА", iPage.getAccompanimentLabelValue());
    }

    @Test
    public void checkWrongDepartureStation(){
        sPage.fillDepartureStation("example");
        sPage.closeBackdrop();
        sPage.getHotelCheckBox().click();
        sPage.clickSearch();
        Assert.assertEquals("Москва (Внуково)АланияМосква (Внуково)", rPage.getPathValue());
    }

    @Test
    public void checkMaximumSeatAmount() {
        sPage.fillSeatAmount("100");
        Assert.assertEquals("9", sPage.getSeatAmountValue());
    }

    @Test
    public void checkPassengerLastName(){
        sPage.closeBackdrop();
        sPage.getHotelCheckBox().click();
        sPage.clickSearch();
        rPage.clickContinue();
        iPage.fillFirstName("Иван");
        Assert.assertEquals("", iPage.getFirstNameValue());
    }

    @Test
    public void checkPassengerFirstName(){
        sPage.closeBackdrop();
        sPage.getHotelCheckBox().click();
        sPage.clickSearch();
        rPage.clickContinue();
        iPage.fillLastName("Иванов");
        Assert.assertEquals("", iPage.getLastNameValue());
    }

    @After
    public void close() {
        driver.quit();
        driver = null;
    }
}

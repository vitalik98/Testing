package by.bsu.mazanik.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SearchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(className = "input-seats")
    private WebElement seatAmount;

    @FindBy(id = "searchButton")
    private WebElement searchButton;

    @FindBy(id = "nameDepartureStation")
    private WebElement departureStation;

    @FindBy(id = "nameArrivalStation")
    private WebElement arrivalStation;

    @FindBy(className = "thirdParties-label")
    private WebElement hotelLabel;

    @FindBy(name = "endDate")
    private WebElement endDate;

    @FindBy(id = "label-thirdParties-IntentMedia")
    private WebElement hotelCheckBox;

    @FindBy(className = "backdrop-close")
    private WebElement backdropClose;

    public SearchPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
    }

    public WebElement getBackdropClose(){
        return backdropClose;
    }

    public WebElement getHotelCheckBox(){
        return hotelCheckBox;
    }

    public WebElement getEndDate(){
        return endDate;
    }

    public WebElement getHotelLabel(){
        return hotelLabel;
    }

    public WebElement getDepartureStation(){
        return departureStation;
    }

    public WebElement getArrivalStation() {
        return arrivalStation;
    }

    public WebElement getSeatAmount() {
        return seatAmount;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public boolean searchButtonIsDisabled(){
        checkVisibility(getSeatAmount());
        checkVisibility(getSearchButton());
        return getSearchButton().getAttribute("disabled").equals("true");
    }

    public String getHotelLabelValue(){
        return checkVisibility(getHotelLabel()).getText();
    }

    public void closeBackdrop(){
        checkVisibility(getBackdropClose()).click();
    }

    public void clickSearch(){
        /*wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("searchButton")));*/
        checkVisibility(getSearchButton()).click();
    }

    public void fillDepartureStation(String city){
        checkVisibility(getDepartureStation());
        getDepartureStation().clear();
        getDepartureStation().sendKeys(city);
    }

    public void fillArrivalStation(String city){
        checkVisibility(getArrivalStation());
        getArrivalStation().clear();
        getArrivalStation().sendKeys(city);
    }

    public void fillSeatAmount(String amount){
        checkVisibility(getSeatAmount()).clear();
        getSeatAmount().sendKeys(amount);
    }

    public String getSeatAmountValue(){
        return checkVisibility(getSeatAmount()).getAttribute("value");
    }

    public WebElement checkVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}

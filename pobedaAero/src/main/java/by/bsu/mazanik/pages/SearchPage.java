package by.bsu.mazanik.pages;

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

    public SearchPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
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

    public void fillSeatAmount(String amount){
        checkVisibility(getSeatAmount()).clear();
        getSeatAmount().sendKeys(amount);
    }

    public String getSeatAmountValue(){
        return checkVisibility(getSeatAmount()).getAttribute("value");
    }

    private WebElement checkVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    private WebDriver driver;

    public SearchPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy(className = "input-seats")
    private WebElement seatAmount;

    public WebElement getSeatAmount() {
        return seatAmount;
    }

    @FindBy(id = "searchButton")
    private WebElement searchButton;

    public WebElement getSearchButton() {
        return searchButton;
    }

    public boolean searchButtonIsDisabled(){
         return searchButton.getAttribute("disabled").equals("true");
    }
}

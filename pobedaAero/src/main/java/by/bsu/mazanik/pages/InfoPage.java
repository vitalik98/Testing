package by.bsu.mazanik.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InfoPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "passengerDayOfBirth0_chzn")
    private WebElement dayOfBirth;

    @FindBy(id = "passengerMonthOfBirth0_chzn")
    private WebElement monthOfBirth;

    @FindBy(id = "passengerYearOfBirth0_chzn")
    private WebElement yearOfBirth;

    @FindBy(id = "passengerLastName0")
    private WebElement lastName;

    @FindBy(id = "passengerFirstName0")
    private WebElement firstName;

    @FindBy(className = "float-left formLine w100 hiddenContainer")
    private WebElement accompanimentLabel;

    public InfoPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public void fillLastName(String name){
        checkVisibility(getLastName()).sendKeys(name);
    }

    public void fillFirstName(String name){
        checkVisibility(getFirstName()).sendKeys(name);
    }

    public String getLastNameValue(){
        return checkVisibility(getLastName()).getAttribute("value");
    }

    public String getFirstNameValue(){
        return checkVisibility(getFirstName()).getAttribute("value");
    }

    public WebElement getAccompanimentLabel(){
        return accompanimentLabel;
    }

    public String getAccompanimentLabelValue(){
        return checkVisibility(getAccompanimentLabel()).getText();
    }

    public void fillDayOfBirth(String day){
        checkVisibility(getDayOfBirth()).sendKeys(day);
    }

    public void fillMonthOfBirth(String month){
        checkVisibility(getMonthOfBirth()).sendKeys(month);
    }

    public void fillYearOfBirth(String year){
        checkVisibility(getYearOfBirth()).sendKeys(year);
    }

    public WebElement getDayOfBirth() {
        return dayOfBirth;
    }

    public WebElement getMonthOfBirth() {
        return monthOfBirth;
    }

    public WebElement getYearOfBirth() {
        return yearOfBirth;
    }

    public WebElement checkVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

}

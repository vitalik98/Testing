package by.bsu.mazanik.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RoutePage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(className = "path")
    private WebElement path;

    @FindBy(className = "btn float-right")
    private WebElement continueButton;

    public RoutePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
    }

    public WebElement getContinueButton(){
        return continueButton;
    }

    public WebElement getPath(){
        return path;
    }

    public String getPathValue(){
        return checkVisibility(getPath()).getText();
    }

    public void clickContinue(){
        checkVisibility(getContinueButton()).click();
    }

    private WebElement checkVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}

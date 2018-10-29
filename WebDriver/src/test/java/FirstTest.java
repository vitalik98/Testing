import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class FirstTest {

    @Test()
    public void Test () throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "C://chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.pobeda.aero/");
        sleep(10000);
        WebElement hotelLabel = driver.findElement(By.cssSelector("label[id='label-thirdParties-Hotels']"));
        hotelLabel.click();
        sleep(10000);
        WebElement searchButton = driver.findElement(By.cssSelector("button[id='searchButton']"));
        searchButton.click();
        sleep(10000);
        WebElement tablePrice = driver.findElement(By.cssSelector(".date.active.enabled div div .price"));
        WebElement totalPrice = driver.findElement(By.cssSelector(".total .right .amountDue"));
        Assert.assertEquals(tablePrice.getText(),totalPrice.getText());
        driver.close();
    }

}

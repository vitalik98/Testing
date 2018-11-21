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
        driver.manage().window().maximize();
        driver.get("https://www.pobeda.aero/");
        sleep(1000);
        WebElement destCityInput = driver.findElement(By.className("input-seats"));
        destCityInput.sendKeys("10");
        sleep(1000);
        Assert.assertEquals(destCityInput.getAttribute("value"),"9");
        driver.close();
    }

}

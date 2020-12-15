import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class AddToCart {
    private WebDriver driver;
    private WebElement addCartButton;

    @BeforeClass
    public void setUpDriverAndClickFavoritesButton() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.get("https://oz.by/pens/more10558337.html");
        addCartButton = driver.findElement(By.xpath("//*[@id=\"top-page\"]/div[3]/div/div[1]/div/div[2]/div[3]/div/div[1]/div[2]/div/div[1]/form/button/span[1]/span[2]"));
        addCartButton.click();
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
        driver = null;
        addCartButton = null;
    }

    @Test
    public void favoritesButtonTextChangedTest() {
        WebElement addCartButtonChanged = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"top-page\"]/div[3]/div/div[1]/div/div[2]/div[3]/div/div[1]/div[2]/div/div[1]/a/span/span[2]")));
        String expectedTextButton = "Уже в корзине";
        String actualTextButton = addCartButtonChanged.getText();
        Assert.assertEquals(expectedTextButton, actualTextButton);
    }

    @Test
    public void favoritesButtonTextColorChangedTest(){
        WebElement addCartButtonChanged = (new WebDriverWait(driver, 10))
            .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"top-page\"]/div[3]/div/div[1]/div/div[2]/div[3]/div/div[1]/div[2]/div/div[1]/a/span/span[2]")));
        String expectedColor = "rgb(205, 69, 0)";
        String actualColor = addCartButtonChanged.getCssValue("color");
        Assert.assertEquals(expectedColor, actualColor);
    }

    @Test
    public void favoritesCounterChangedTest(){
        WebElement favoritesCounter = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"top-page\"]/div[1]/div[2]/div/ul/li[3]/a/span")));
        String expectedCount = "1";
        String actualCount = favoritesCounter.getText();
        Assert.assertEquals(expectedCount, actualCount);
    }

}
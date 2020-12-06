package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {

    public WebDriver driver;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = "//*[@class=\"l-col-3-i\"]/ul[1]/li[1]/a")
    private WebElement menuPage;

    @FindBy(xpath = "//*[@class=\"c-gray f11 filter-items cfix\"]/li[3]/a")
    private WebElement profilePage;

    @FindBy(xpath = "//html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[3]/a[1]/span[1]")
    private WebElement changePasswordPageButton;

    @FindBy(name = "old_psw")
    private WebElement oldPasswordInput;

    @FindBy(name = "new_psw1")
    private WebElement newPasswordInput;

    @FindBy(name = "new_psw2")
    private WebElement newPasswordConfirmInput;

    @FindBy(className = "b-bn")
    private WebElement changePasswordButton;

    public ProfilePage openMenuPage() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"l-col-3-i\"]/ul[1]/li[1]/a")));
        menuPage.click();
        return this;
    }

    public ProfilePage openProfilePage() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"c-gray f11 filter-items cfix\"]/li[3]/a")));
        profilePage.click();
        return this;
    }


    public ProfilePage openChangePasswordPage() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"b-bn\"]")));
        changePasswordPageButton.click();
        return this;
    }

    public ProfilePage fillChangePasswordInputs(String oldPassword, String newPassword) {
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(125))
                .withMessage("Element was not found")
                .until(ExpectedConditions.elementToBeClickable(oldPasswordInput))
                .sendKeys(oldPassword);
        newPasswordInput.sendKeys(newPassword);
        newPasswordConfirmInput.sendKeys(newPassword);
        changePasswordButton.click();
        return this;
    }
}


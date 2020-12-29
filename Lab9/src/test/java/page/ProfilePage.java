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

public class ProfilePage extends AbstractPage{

    private final String URL = "https://oz.by/personal/";

    @Override
    public ProfilePage openPage() {
        driver.navigate().to(URL);
        logger.info("Profile page opened");
        return this;
    }

    public ProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
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

    @FindBy(xpath = "//*[@class=\"l-row-user-name\"]/h1")
    private WebElement userName;

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

    public LoginPage fillChangePasswordInputs(String oldPassword, String newPassword) {
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(125))
                .withMessage("Element was not found")
                .until(ExpectedConditions.elementToBeClickable(oldPasswordInput))
                .sendKeys(oldPassword);
        newPasswordInput.sendKeys(newPassword);
        newPasswordConfirmInput.sendKeys(newPassword);
        changePasswordButton.click();
        logger.info("Changed password");
        return new LoginPage(driver);
    }

    public String getUserName() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"l-row-user-name\"]/h1")));
        return userName.getText();
    }
}


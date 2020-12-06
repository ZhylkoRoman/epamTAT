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

public class LoginPage{

    public WebDriver driver;

    private final String URL = "https://oz.by/personal/login.phtml";

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "loginPopupIntro")
    private WebElement loginHeader;

    @FindBy(id = "loginFormLoginEmailLink")
    private WebElement emailClick;

    @FindBy(xpath = "//*[@class='i-input i-input_full-width i-popup__input'][1]")
    private WebElement emailField;

    @FindBy(xpath = "//*[@class='i-input i-input_full-width i-input_with-padding i-popup__input'][1]")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@class='i-button i-button_full-width i-button_large i-button_primary i-popup__form-button'][1]")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@class=\"l-row-user-name\"]/h1")
    private WebElement userName;


    public LoginPage chooseInputByEmail() {
        emailClick.click();
        return this;
    }

    public LoginPage inputEmail(String email) {
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(125))
                .withMessage("Element was not found")
                .until(ExpectedConditions.elementToBeClickable(emailField))
                .sendKeys(email);
        return this;
    }

    public LoginPage inputPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }
    public LoginPage clickLoginButton() {
        loginButton.click();
        return this;
    }

    public String getUserName() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"l-row-user-name\"]/h1")));
        return userName.getText();
    }

    public String getLoginHeader() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"loginPopupIntro\"]")));
        return loginHeader.getText();
    }
}
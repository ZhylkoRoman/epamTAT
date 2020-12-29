package page;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends AbstractPage{

    private final String URL = "https://oz.by/personal/login.phtml";

    @Override
    public LoginPage openPage() {
        driver.navigate().to(URL);
        logger.info("Login page opened");
        return this;
    }

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(id = "loginFormLoginEmailLink")
    private WebElement emailClick;

    @FindBy(xpath = "//*[@class='i-input i-input_full-width i-popup__input'][1]")
    private WebElement emailField;

    @FindBy(xpath = "//*[@class='i-input i-input_full-width i-input_with-padding i-popup__input'][1]")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@class='i-button i-button_full-width i-button_large i-button_primary i-popup__form-button'][1]")
    private WebElement loginButton;



    public LoginPage chooseInputByEmail() {
        emailClick.click();
        return this;
    }

    public ProfilePage inputCredentials(User user) {
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(125))
                .withMessage("Element was not found")
                .until(ExpectedConditions.elementToBeClickable(emailField))
                .sendKeys(user.getEmail());
        passwordField.sendKeys(user.getPassword());
        loginButton.click();
        logger.info("Login user");
        return new ProfilePage(driver);
    }

    public String getInputType() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='i-input i-input_full-width i-popup__input'][1]")));
        return emailField.getAttribute("type");
    }
}
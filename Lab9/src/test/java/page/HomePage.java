package page;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage{

    private static final String URL = "https://oz.by/";

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public HomePage openPage() {
        driver.navigate().to(URL);
        logger.info("Home page opened");
        return this;
    }

    @FindBy(xpath = "//*[@class='top-panel__userbar__auth'][1]/span[1]")
    private WebElement loginButton;

    @FindBy(id = "loginFormLoginEmailLink")
    private WebElement chooseLoginByEmail;

    @FindBy(xpath = "//*[@class='i-input i-input_full-width i-popup__input'][1]")
    private WebElement emailField;

    @FindBy(xpath = "//*[@class='i-input i-input_full-width i-input_with-padding i-popup__input'][1]")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@class='i-button i-button_full-width i-button_large i-button_primary i-popup__form-button'][1]")
    private WebElement loginSubmitButton;

    @FindBy(className = "top-panel__userbar__user__name__inner")
    private WebElement profilePageButton;

    @FindBy(id = "top-s")
    private WebElement searchInput;

    @FindBy(className = "top-panel__search__btn")
    private WebElement searchButton;


    public HomePage openLoginWindow() {
        loginButton.click();
        chooseLoginByEmail.click();
        return this;
    }

    public HomePage login(User user) {
        emailField.sendKeys(user.getEmail());
        passwordField.sendKeys(user.getPassword());
        loginSubmitButton.click();
        logger.info("Login user");
        return this;
    }

    public ProfilePage openProfilePage() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='top-panel__userbar__user__name__inner']")));
        profilePageButton.click();
        return new ProfilePage(driver);
    }

    public SearchPage openSearchPage() {
        searchInput.sendKeys("pencil");
        searchButton.click();
        return new SearchPage(driver);
    }

    public String getUsername() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"top-panel__userbar__user__name__inner\"]")));
        return profilePageButton.getText();
    }
}

package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;
import java.util.List;

public class SearchPage extends AbstractPage {
    private final String URL = "https://oz.by/search/";

    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public AbstractPage openPage() {
        driver.navigate().to(URL);
        logger.info("Profile page opened");
        return this;
    }

    By elementsContainer = By.xpath("//li[@class='viewer-type-card__li ']");

    public List<WebElement> getElementsList() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        logger.info("Search elements");
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(elementsContainer));
    }

}

package test;

import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;
import page.ProfilePage;
import service.UserCreator;

import java.util.List;

public class OzbyTest extends CommonConditions{

    @Test
    public void passwordChangeTestSuccess() {
        User testUser = UserCreator.withCredentialsFromProperty();
        String result = new LoginPage(driver).openPage().chooseInputByEmail().inputCredentials(testUser)
                .openMenuPage()
                .openProfilePage()
                .openChangePasswordPage()
                .fillChangePasswordInputs(testUser.getPassword(), testUser.getPassword()).chooseInputByEmail().getInputType();
        Assert.assertEquals("email", result);
    }

    @Test
    public void searchElementTest() {
        List<WebElement> searchElements = new HomePage(driver).openPage()
                .openSearchPage()
                .getElementsList();
        Assert.assertFalse(searchElements.isEmpty());
    }
}
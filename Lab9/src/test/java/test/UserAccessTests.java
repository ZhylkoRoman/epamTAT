package test;

import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;
import service.UserCreator;

public class UserAccessTests extends CommonConditions{

    @Test
    public void loginFromMainPageTestSuccess() {
        User testUser = UserCreator.withCredentialsFromProperty();
        String username =  new HomePage(driver).openPage().
                openLoginWindow().
                login(testUser)
                .getUsername();
        Assert.assertEquals(username, testUser.getUsername());
    }

    @Test
    public void loginFromLoginPageTestSuccess() {
        User testUser = UserCreator.withCredentialsFromProperty();
        String username = new LoginPage(driver).openPage().
                chooseInputByEmail()
                .inputCredentials(testUser)
                .getUserName();
        Assert.assertEquals(username, testUser.getUsername());
    }
}

package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.LoginPage;
import page.ProfilePage;

public class OzbyTest {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;

    private final String email = "roman.zhilko@gmail.com";
    private final String password = "pVLm3P";
    private final String username = "oz25419120";

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        profilePage = new ProfilePage(driver);
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
        driver.get("https://oz.by/personal/login.phtml");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    public void loginTestSuccess() {
        String username = loginPage.chooseInputByEmail()
                .inputEmail(email)
                .inputPassword(password)
                .clickLoginButton()
                .getUserName();
        Assert.assertEquals(username, this.username);
    }

    @Test
    public void passwordChangeTestSuccess() {
        profilePage.openMenuPage()
                .openProfilePage()
                .openChangePasswordPage()
                .fillChangePasswordInputs(password, password);
        Assert.assertEquals("Вход", loginPage.getLoginHeader());
    }
}
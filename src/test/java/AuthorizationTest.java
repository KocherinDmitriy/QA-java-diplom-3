import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import unils.DeleteUser;
import unils.pageobjectmodels.ForgotPasswordPage;
import unils.pageobjectmodels.HomePage;
import unils.pageobjectmodels.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static unils.CreateUser.*;
import static com.codeborne.selenide.WebDriverConditions.*;

public class AuthorizationTest {


    @Before
    public void startTests() {
        createUserMethod();
    }


    @Test
    @DisplayName("Authorization from the Personal area page ")
    public void homePagePersonalAreaAuthorization() {
        HomePage homePage = open(HomePage.HOME_PAGE_URL, HomePage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        homePage.clickOnPersonalAreaButton();
        homePage.inputCredentials(0,getLogin());
        homePage.inputCredentials(1,getPassword());
        homePage.clickOnEnterButton();
        homePage.lableBurger.shouldBe(Condition.visible);
        Assert.assertEquals(HomePage.HOME_PAGE_URL, webdriver().driver().getCurrentFrameUrl());


    }

    @Test
    @DisplayName("Authorization from the Forgot password page ")
    public void forgotPageAuthorization() {
        ForgotPasswordPage forgotPasswordPage = open(ForgotPasswordPage.FORGOT_PASSWORD_PAGE_URL, ForgotPasswordPage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        forgotPasswordPage.clickOnEnterButtonForgot();
        forgotPasswordPage.inputCredentials(0,getLogin());
        forgotPasswordPage.inputCredentials(1,getPassword());
        forgotPasswordPage.clickOnEnterButton();
        webdriver().shouldHave(url(HomePage.HOME_PAGE_URL));

    }

    @Test
    @DisplayName("Authorization from the Registration page ")
    public void registrationPageAuthorization() {
        RegistrationPage registrationPage = open(RegistrationPage.REGISTRATION_PAGE_URL, RegistrationPage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        registrationPage.clickOnEnterButtonRegistration();
        registrationPage.inputCredentials(0,getLogin());
        registrationPage.inputCredentials(1,getPassword());
        registrationPage.clickOnEnterButton();
        webdriver().shouldHave(url(HomePage.HOME_PAGE_URL));

    }

    @Test
    @DisplayName("Authorization from the home page by button \"enter to account\"")
    public void homePageEnterButtonAuthorization() {
        HomePage homePage = open(HomePage.HOME_PAGE_URL, HomePage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        homePage.clickOnEnterAccount();
        homePage.inputCredentials(0,getLogin());
        homePage.inputCredentials(1,getPassword());
        homePage.clickOnEnterButton();
        homePage.lableBurger.shouldBe(Condition.visible);
        Assert.assertEquals(HomePage.HOME_PAGE_URL, webdriver().driver().getCurrentFrameUrl());

    }

    @After
    public void teardown() {
        Selenide.closeWindow();
        Selenide.closeWebDriver();
        DeleteUser.sendDeleteRequestUser();
    }
}

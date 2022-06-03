import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import unils.pageobjectmodels.ForgotPasswordPage;
import unils.pageobjectmodels.HomePage;
import unils.pageobjectmodels.RegistrationPage;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static unils.CreateUser.*;
import static com.codeborne.selenide.WebDriverConditions.*;

public class AuthorizationTest {

    @Test
    @DisplayName("Authorization from the Personal area page ")
    public void homePagePersonalAreaAuthorization() {
        createUserMethod();
        HomePage homePage = open (HomePage.HOME_PAGE_URL, HomePage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        homePage.personalArea.click();
        homePage.autorizationFields.get(0).setValue(getLogin());
        homePage.autorizationFields.get(1).setValue(getPassword());
        homePage.enterButtonAuth.click();
        homePage.lableBurger.shouldBe(Condition.visible);
        Assert.assertEquals(HomePage.HOME_PAGE_URL,webdriver().driver().getCurrentFrameUrl());

    }
    @Test
    @DisplayName("Authorization from the Forgot password page ")
    public void forgotPageAuthorization(){
        createUserMethod();
        ForgotPasswordPage forgotPasswordPage = open (ForgotPasswordPage.FORGOT_PASSWORD_PAGE_URL, ForgotPasswordPage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        forgotPasswordPage.enterButtonForgot.click();
        forgotPasswordPage.autorizationFields.get(0).setValue(getLogin());
        forgotPasswordPage.autorizationFields.get(1).setValue(getPassword());
        forgotPasswordPage.enterButtonAuth.click();
        webdriver().shouldHave(url(HomePage.HOME_PAGE_URL));

    }
    @Test
    @DisplayName("Authorization from the Registration page ")
    public void registrationPageAuthorization() {
        createUserMethod();
        RegistrationPage registrationPage = open (RegistrationPage.REGISTRATION_PAGE_URL, RegistrationPage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        registrationPage.enterButtonRegistration.click();
        registrationPage.autorizationFields.get(0).setValue(getLogin());
        registrationPage.autorizationFields.get(1).setValue(getPassword());
        registrationPage.enterButtonAuth.click();
        webdriver().shouldHave(url(HomePage.HOME_PAGE_URL));

    }
    @Test
    @DisplayName("Authorization from the home page by button \"enter to account\"")
    public void homePageEnterButtonAuthorization() {
        createUserMethod();
        HomePage homePage = open (HomePage.HOME_PAGE_URL, HomePage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        homePage.enterAccount.click();
        homePage.autorizationFields.get(0).setValue(getLogin());
        homePage.autorizationFields.get(1).setValue(getPassword());
        homePage.enterButtonAuth.click();
        homePage.lableBurger.shouldBe(Condition.visible);
        Assert.assertEquals(HomePage.HOME_PAGE_URL,webdriver().driver().getCurrentFrameUrl());

    }

    @After
    public void teardown() {
        Selenide.closeWindow();
        Selenide.closeWebDriver();
    }
}

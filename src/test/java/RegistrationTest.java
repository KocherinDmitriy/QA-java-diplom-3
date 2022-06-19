import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import unils.DeleteUserCreatedViaUI;
import unils.pageobjectmodels.RegistrationPage;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationTest {

    String email = String.format("%s@gmail.com", RandomStringUtils.randomAlphabetic(10));
    String password = RandomStringUtils.randomAlphabetic(10);
    String name = RandomStringUtils.randomAlphabetic(10);
    String incorrectPassword = RandomStringUtils.randomAlphabetic(4);

    @Test
    @DisplayName("Registration with incorrect password 5 symbols")
    @Description("4 symbols in the password/allowed 6")
    public void passwordValidation() {
        password = incorrectPassword;
        RegistrationPage registrationPage = open(RegistrationPage.REGISTRATION_PAGE_URL, RegistrationPage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        registrationPage.inputCredentialsRegistration(0, name);
        registrationPage.inputCredentialsRegistration(1, email);
        registrationPage.inputCredentialsRegistration(2, password);
        registrationPage.clickOnButtonRegistration();
        Assert.assertEquals(registrationPage.getTextErrorMessage(), "Некорректный пароль");
    }

    @Test
    @DisplayName("Registration HappyPath")
    @Description("All criteria ar met")
    public void confirmedRegistration() {


        RegistrationPage registrationPage = open(RegistrationPage.REGISTRATION_PAGE_URL, RegistrationPage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        registrationPage.inputCredentialsRegistration(0, name);
        registrationPage.inputCredentialsRegistration(1, email);
        registrationPage.inputCredentialsRegistration(2, password);
        registrationPage.clickOnButtonRegistration();
        registrationPage.inputCredentialsRegistration(0, email);
        registrationPage.inputCredentialsRegistration(1, password);
        registrationPage.clickOnButtonRegistration();
        registrationPage.visibleLableEnter();
        Assert.assertEquals(registrationPage.AUTH_PAGE_URL, webdriver().driver().getCurrentFrameUrl());


    }


    @After
    public void teardown() {
        Selenide.closeWindow();
        Selenide.closeWebDriver();
        new DeleteUserCreatedViaUI().sendDeleteRequestUserFromUI(email, password);

    }
}



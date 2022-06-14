package unils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.apache.commons.lang3.RandomStringUtils;
import unils.pageobjectmodels.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static unils.CreateUser.*;

public class AuthUser {

    static String name = RandomStringUtils.randomAlphabetic(10);

    public static String enterToPersonalAreaWithNewUser() {
        createUserMethod();
        RegistrationPage registrationPage = open(RegistrationPage.REGISTRATION_PAGE_URL, RegistrationPage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        registrationPage.inputCredentialsRegistration(0, name);
        registrationPage.inputCredentialsRegistration(1, getLogin());
        registrationPage.inputCredentialsRegistration(2, getPassword());
        registrationPage.clickOnEnterButtonRegistration();
        registrationPage.inputCredentialsRegistration(0, getLogin());
        registrationPage.inputCredentialsRegistration(1, getPassword());
        registrationPage.clickOnEnterButton();
        registrationPage.clickOnPersonalAreaButton();

        String url=webdriver().driver().getCurrentFrameUrl();
        return url;

    }
}

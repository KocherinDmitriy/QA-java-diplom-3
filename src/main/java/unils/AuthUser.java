package unils;

import com.codeborne.selenide.WebDriverRunner;
import unils.pageobjectmodels.RegistrationPage;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;

public class AuthUser {
    public AuthUser() {
    }

    public String enterToPersonalAreaWithNewUser(String login, String password, String name) {
        ArrayList<String> createUser = new CreateUser().createUserMethod(login, password, name);
        RegistrationPage registrationPage = open(RegistrationPage.REGISTRATION_PAGE_URL, RegistrationPage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        registrationPage.inputCredentialsRegistration(0, name);
        registrationPage.inputCredentialsRegistration(1, createUser.get(0));
        registrationPage.inputCredentialsRegistration(2, createUser.get(1));
        registrationPage.clickOnEnterButtonRegistration();
        registrationPage.inputCredentialsRegistration(0, createUser.get(0));
        registrationPage.inputCredentialsRegistration(1, createUser.get(1));
        registrationPage.clickOnEnterButton();
        registrationPage.clickOnPersonalAreaButton();

        String url = webdriver().driver().getCurrentFrameUrl();
        return url;

    }
}

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
        registrationPage.registrationFields.get(0).setValue(name);
        registrationPage.registrationFields.get(1).setValue(getLogin());
        registrationPage.registrationFields.get(2).setValue(getPassword());
        registrationPage.enterButtonRegistration.click();
        registrationPage.autorizationFields.get(0).shouldBe(Condition.visible).setValue(getLogin());
        registrationPage.autorizationFields.get(1).setValue(getPassword());
        registrationPage.enterButtonAuth.click();
        registrationPage.personalArea.click();

        String url=webdriver().driver().getCurrentFrameUrl();
        return url;

    }
}

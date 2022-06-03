import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import unils.pageobjectmodels.RegistrationPage;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTest {



    @Test
    @DisplayName("Registration with incorrect password 5 symbols")
    @Description("4 symbols in the password/allowed 6")
    public void passwordValidation(){
        String email = String.format("%s@gmail.com", RandomStringUtils.randomAlphabetic(10));
        String name = RandomStringUtils.randomAlphabetic(10);
        String incorrectPassword = RandomStringUtils.randomAlphabetic(4);
        RegistrationPage registrationPage= open (RegistrationPage.REGISTRATION_PAGE_URL,RegistrationPage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        registrationPage.nameAndEmail.get(0).shouldBe(Condition.visible).setValue(name);
        registrationPage.nameAndEmail.get(1).shouldBe(Condition.visible).setValue(email);
        registrationPage.nameAndEmail.get(2).shouldBe(Condition.visible).setValue(incorrectPassword);
        registrationPage.buttonRegistration.click();
        registrationPage.errorMessage.shouldBe(Condition.text("Некорректный пароль"));

    }

    @Test
    @DisplayName("Registration HappyPath")
    @Description("All criteria ar met")
    public void confirmedRegistration()  {

        String email = String.format("%s@gmail.com", RandomStringUtils.randomAlphabetic(10));
        String password = RandomStringUtils.randomAlphabetic(10);
        String incorrectPassword = RandomStringUtils.randomAlphabetic(5);
        String name = RandomStringUtils.randomAlphabetic(10);
        RegistrationPage registrationPage= open (RegistrationPage.REGISTRATION_PAGE_URL,RegistrationPage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        registrationPage.registrationFields.get(0).setValue(name);
        registrationPage.registrationFields.get(1).setValue(email);
        registrationPage.registrationFields.get(2).setValue(password);
        registrationPage.buttonRegistration.click();
        registrationPage.lableEnter.shouldBe(Condition.visible);
        Assert.assertEquals(registrationPage.AUTH_PAGE_URL,webdriver().driver().getCurrentFrameUrl());

    }



    @After
    public void teardown() {
        Selenide.closeWindow();
        Selenide.closeWebDriver();
    }
}



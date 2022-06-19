import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Test;
import unils.pageobjectmodels.AuthPage;
import unils.AuthUser;
import unils.DeleteUser;
import unils.pageobjectmodels.HomePage;
import unils.pageobjectmodels.PersonalAreaPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class EscapeFromPersonalAreaTest {
    String login = String.format("%s@gmail.com", RandomStringUtils.randomAlphabetic(10));
    String password = RandomStringUtils.randomAlphabetic(10);
    String name = RandomStringUtils.randomAlphabetic(10);


    @Test
    @DisplayName("Go to the home page by clicking the \"Constructor\" button")
    public void goToHomePageByButtonConstructor() {
        PersonalAreaPage personalAreaPage = open(new AuthUser().enterToPersonalAreaWithNewUser(login, password, name), PersonalAreaPage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        personalAreaPage.clickConstructorButton();
        webdriver().shouldHave(url(HomePage.HOME_PAGE_URL));
    }

    @Test
    @DisplayName("Go to the home page by clicking the Burger Label")
    public void goToHomePageByBurgerLabel() {

        PersonalAreaPage personalAreaPage = open(new AuthUser().enterToPersonalAreaWithNewUser(login, password, name), PersonalAreaPage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        personalAreaPage.clickBurgerLabel();
        webdriver().shouldHave(url(HomePage.HOME_PAGE_URL));


    }

    @Test
    @DisplayName("Sign out of your account using the \"Logout\" button")
    public void exitFromAccount() {

        PersonalAreaPage personalAreaPage = open(new AuthUser().enterToPersonalAreaWithNewUser(login, password, name), PersonalAreaPage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        personalAreaPage.clickExitButton();
        webdriver().shouldHave(url(AuthPage.AUTH_PAGE_URL));
    }

    @After
    public void teardown() {
        Selenide.closeWindow();
        Selenide.closeWebDriver();
        new DeleteUser().sendDeleteRequestUser(login, password);
    }
}

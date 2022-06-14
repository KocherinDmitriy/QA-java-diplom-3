import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import unils.CreateUser;
import unils.pageobjectmodels.AuthPage;
import unils.AuthUser;
import unils.DeleteUser;
import unils.pageobjectmodels.HomePage;
import unils.pageobjectmodels.PersonalAreaPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class EscapeFromPersonalAreaTest {

    @Test
    @DisplayName("Go to the home page by clicking the \"Constructor\" button")
    public void goToHomePageByButtonConstructor(){

        PersonalAreaPage personalAreaPage = open(AuthUser.enterToPersonalAreaWithNewUser(), PersonalAreaPage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        personalAreaPage.clickConstructorButton();
        webdriver().shouldHave(url(HomePage.HOME_PAGE_URL));
    }

    @Test
    @DisplayName("Go to the home page by clicking the Burger Label")
    public void goToHomePageByBurgerLabel(){

        PersonalAreaPage personalAreaPage = open(AuthUser.enterToPersonalAreaWithNewUser(), PersonalAreaPage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        personalAreaPage.clickBurgerLabel();
        webdriver().shouldHave(url(HomePage.HOME_PAGE_URL));
    }
    @Test
    @DisplayName("Sign out of your account using the \"Logout\" button")
    public void exitFromAccount (){

        PersonalAreaPage personalAreaPage = open(AuthUser.enterToPersonalAreaWithNewUser(), PersonalAreaPage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        personalAreaPage.clickExitButton();
        webdriver().shouldHave(url(AuthPage.AUTH_PAGE_URL));
    }
    @After
    public void teardown() {
        Selenide.closeWindow();
        Selenide.closeWebDriver();
        DeleteUser.sendDeleteRequestUser();
    }
}

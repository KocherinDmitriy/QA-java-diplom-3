import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import unils.CreateUser;
import unils.DeleteUser;
import unils.pageobjectmodels.HomePage;
import unils.pageobjectmodels.PersonalAreaPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class PersonalAreaTest {

    String login = String.format("%s@gmail.com", RandomStringUtils.randomAlphabetic(10));
    String password = RandomStringUtils.randomAlphabetic(10);
    String name = RandomStringUtils.randomAlphabetic(10);

    @Before
    public void startTest() {

        new CreateUser().createUserMethod(login, password, name);
    }

    @Test
    @DisplayName("Checking the opening of the page \"personal account\"")
    public void checkOpeningPersonalAccountPage() {
        HomePage homePage = open(HomePage.HOME_PAGE_URL, HomePage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        homePage.clickOnPersonalAreaButton();
        homePage.inputCredentials(0, login);
        homePage.inputCredentials(1, password);
        homePage.clickOnEnterButton();
        homePage.clickOnPersonalArea();
        webdriver().shouldHave(url(PersonalAreaPage.PERSONAL_AREA_PAGE_URL));
        System.out.println(login + " " + password);

    }

    @After
    public void teardown() {
        Selenide.closeWindow();
        Selenide.closeWebDriver();
        new DeleteUser().sendDeleteRequestUser(login, password);
    }
}

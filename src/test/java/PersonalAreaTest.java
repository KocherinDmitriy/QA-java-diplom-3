import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import unils.DeleteUser;
import unils.pageobjectmodels.HomePage;
import unils.pageobjectmodels.PersonalAreaPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static unils.CreateUser.*;

public class PersonalAreaTest {
    @Before
    public void startTest(){
        createUserMethod();
    }

    @Test
    @DisplayName("Checking the opening of the page \"personal account\"")
    public void checkOpeningPersonalAccountPage() {
        HomePage homePage = open(HomePage.HOME_PAGE_URL, HomePage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        homePage.clickOnPersonalAreaButton();
        homePage.inputCredentials(0,getLogin());
        homePage.inputCredentials(1,getPassword());
        homePage.clickOnEnterButton();
        homePage.personalArea.shouldBe(Condition.visible).click();
        webdriver().shouldHave(url(PersonalAreaPage.PERSONAL_AREA_PAGE_URL));
    }
    @After
    public void teardown() {
        Selenide.closeWindow();
        Selenide.closeWebDriver();
        DeleteUser.sendDeleteRequestUser();
    }
}

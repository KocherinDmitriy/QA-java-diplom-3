import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import unils.pageobjectmodels.HomePage;
import unils.pageobjectmodels.PersonalAreaPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static unils.CreateUser.*;

public class PersonalAreaTest {
    @Test
    @DisplayName("Checking the opening of the page \"personal account\"")
    public void checkOpeningPersonalAccountPage() {
        createUserMethod();
        HomePage homePage = open(HomePage.HOME_PAGE_URL, HomePage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        homePage.personalArea.click();
        homePage.autorizationFields.get(0).setValue(getLogin());
        homePage.autorizationFields.get(1).setValue(getPassword());
        homePage.enterButtonAuth.click();
        homePage.personalArea.shouldBe(Condition.visible).click();
        webdriver().shouldHave(url(PersonalAreaPage.PERSONAL_AREA_PAGE_URL));
    }
}

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;

import org.junit.Test;

import unils.pageobjectmodels.HomePage;

import static com.codeborne.selenide.Selenide.open;


public class BurgerConstructorTest {
    @Test
    @DisplayName("Checking the list of fillings on the home page")
    public void checkDisplayListOfFillings() {
        HomePage homePage = open(HomePage.HOME_PAGE_URL, HomePage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        homePage.сonstructorHeader.get(2).shouldBe(Condition.visible).shouldBe(Condition.text("Начинки")).click();
        homePage.labelListOfConstituting.get(2).shouldBe(Condition.visible).shouldBe(Condition.text("Начинки"));

    }

    @Test
    @DisplayName("Checking the list of souses on the home page")
    public void checkDisplayListOfSauces() {
        HomePage homePage = open(HomePage.HOME_PAGE_URL, HomePage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        homePage.сonstructorHeader.get(2).click();
        homePage.сonstructorHeader.get(1).shouldBe(Condition.visible).shouldBe(Condition.text("Соусы")).click();
        homePage.labelListOfConstituting.get(1).shouldBe(Condition.visible).shouldBe(Condition.text("Соусы"));
    }


    @Test
    @DisplayName("Checking the list of buns on the home page")
    public void checkDisplayListOfBuns() {
        HomePage homePage = open(HomePage.HOME_PAGE_URL, HomePage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        homePage.сonstructorHeader.get(2).click();
        homePage.сonstructorHeader.get(0).shouldBe(Condition.visible).shouldBe(Condition.text("Булки")).click();
        homePage.labelListOfConstituting.get(0).shouldBe(Condition.visible).shouldBe(Condition.text("Булки"));

    }
}

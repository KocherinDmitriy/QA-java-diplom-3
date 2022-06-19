import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import unils.pageobjectmodels.HomePage;

import static com.codeborne.selenide.Selenide.open;


public class BurgerConstructorTest {
    @Test
    @DisplayName("Checking the list of fillings on the home page")
    public void checkDisplayListOfFillings() {
        HomePage homePage = open(HomePage.HOME_PAGE_URL, HomePage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        Assert.assertTrue(homePage.isBunPressed());//Проверяем что прожаты "булки", где находимся
        homePage.clickOnConstructorHeader(2);
        Assert.assertTrue(homePage.isFillingsPressed());
        Assert.assertFalse(homePage.isBunPressed());
        Assert.assertFalse(homePage.isSaucesPressed());
        Assert.assertEquals(homePage.getTextOnConstructorHeader(2), "Начинки");

    }

    @Test
    @DisplayName("Checking the list of souses on the home page")
    public void checkDisplayListOfSauces() {
        HomePage homePage = open(HomePage.HOME_PAGE_URL, HomePage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        Assert.assertTrue(homePage.isBunPressed());//Проверяем что прожаты "булки", где находимся
        homePage.clickOnConstructorHeader(1);
        Assert.assertTrue(homePage.isSaucesPressed());
        Assert.assertFalse(homePage.isFillingsPressed());
        Assert.assertFalse(homePage.isBunPressed());
        Assert.assertEquals(homePage.getTextOnConstructorHeader(1), "Соусы");

    }


    @Test
    @DisplayName("Checking the list of buns on the home page")
    public void checkDisplayListOfBuns() {
        HomePage homePage = open(HomePage.HOME_PAGE_URL, HomePage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        Assert.assertTrue(homePage.isBunPressed());//Проверяем что прожаты "булки", где находимся
        homePage.clickOnConstructorHeader(2);//Переключились на начинки
        homePage.clickOnConstructorHeader(0);//Вернулись к булкам
        Assert.assertTrue(homePage.isBunPressed());
        Assert.assertFalse(homePage.isSaucesPressed());
        Assert.assertFalse(homePage.isFillingsPressed());
        Assert.assertEquals(homePage.getTextOnConstructorHeader(0), "Булки");
    }
}

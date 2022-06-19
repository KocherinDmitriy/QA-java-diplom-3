package unils.pageobjectmodels;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends AuthPage {

    public static final String HOME_PAGE_URL = "https://stellarburgers.nomoreparties.site/";

    //Личный кабинет
    @FindBy(how = How.XPATH, using = "//*[.='Личный Кабинет']")
    private SelenideElement personalArea;

    @FindBy(how = How.XPATH, using = "//*[.='Соберите бургер']")
    private SelenideElement lableBurger;

    //Войти в аккаунт
    @FindBy(how = How.XPATH, using = "//*[.='Войти в аккаунт']")
    private SelenideElement enterAccount;

    //Херед конструктора
    @FindAll(@FindBy(how = How.XPATH, using = "//div[contains(@class, 'tab_tab__1SPyG')]"))
    private ElementsCollection сonstructorHeader;
    //Наимонование блока в списке составляющих
    @FindAll(@FindBy(how = How.XPATH, using = "//h2[contains(@class, 'text_type_main-medium')]"))
    private ElementsCollection labelListOfConstituting;

    @FindBy(how = How.CLASS_NAME, using = "BurgerIngredients_ingredients__menuContainer__Xu3Mo")
    private SelenideElement blockWithIngridients;

    @FindAll(@FindBy(how = How.CLASS_NAME, using = "BurgerIngredient_ingredient__text__yp3dH"))
    private ElementsCollection burgerIngredientsList;


    public void clickOnPersonalAreaButton() {
        personalArea.click();
    }

    public void clickOnEnterAccount() {
        enterAccount.click();
    }

    public void clickOnPersonalArea() {
        personalArea.click();
    }

    public Boolean lableBurgerIsVisible() {
        lableBurger.shouldBe(Condition.visible);
        return true;
    }

    public void clickOnConstructorHeader(int number) {
        сonstructorHeader.get(number).click();
    }

    public String getTextOnConstructorHeader(int number) {
        return сonstructorHeader.get(number).getText();
    }
    /* Тут наверно можно было бы сделать красивше и использовать один метод, для определения того, где находимся, передавая в него
    значения, но для тестов, посчитал, что будет нагляднее методы с неймингом. */
    public boolean isBunPressed() {
        String className = String.valueOf(сonstructorHeader.get(0).getAttribute("class"));
        if (className.contains("tab_tab_type_current__2BEPc") && сonstructorHeader.get(0).getText().contains("Булки")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFillingsPressed() {
        String className = String.valueOf(сonstructorHeader.get(2).getAttribute("class"));
        if (className.contains("tab_tab_type_current__2BEPc") && сonstructorHeader.get(2).getText().contains("Начинки")) {
            return true;
        } else {
            return false;
        }

    }

    public boolean isSaucesPressed() {
        String className = String.valueOf(сonstructorHeader.get(1).getAttribute("class"));
        if (className.contains("tab_tab_type_current__2BEPc") && сonstructorHeader.get(1).getText().contains("Соусы")) {
            return true;
        } else {
            return false;
        }
    }

}

package unils.pageobjectmodels;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends AuthPage {

    public  static final String HOME_PAGE_URL="https://stellarburgers.nomoreparties.site/";

    //Личный кабинет
    @FindBy(how = How.XPATH, using = "//*[.='Личный Кабинет']")
    public SelenideElement personalArea;

    @FindBy(how = How.XPATH, using = "//*[.='Соберите бургер']")
    public SelenideElement lableBurger;

    //Войти в аккаунт
    @FindBy(how = How.XPATH, using = "//*[.='Войти в аккаунт']")
    public SelenideElement enterAccount;

    @FindBy(how = How.XPATH, using = "//*[.='ente1rAccount']")
    public SelenideElement ente1rAccount;
    //Херед конструктора
    @FindAll(@FindBy(how = How.XPATH, using = "//div[contains(@class, 'tab_tab__1SPyG')]"))
    public ElementsCollection сonstructorHeader;
    //Наимонование блока в списке состовляющих
    @FindAll(@FindBy(how = How.XPATH, using = "//h2[contains(@class, 'text_type_main-medium')]"))
    public ElementsCollection labelListOfConstituting;

    @FindBy(how = How.CLASS_NAME, using = "BurgerIngredients_ingredients__menuContainer__Xu3Mo")
    public SelenideElement blockWithIngridients;

    @FindAll(@FindBy(how = How.CLASS_NAME, using = "BurgerIngredient_ingredient__text__yp3dH"))
    public ElementsCollection burgerIngredientsList;




    public  void clickOnPersonalAreaButton() {
        personalArea.click();
    }

    public void clickOnEnterAccount(){
        enterAccount.click();
    }

}

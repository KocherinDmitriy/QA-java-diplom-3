package unils.pageobjectmodels;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PersonalAreaPage{
    public  static final String PERSONAL_AREA_PAGE_URL="https://stellarburgers.nomoreparties.site/account/profile";

    //Текст "В этом разделе вы можете изменить свои персональные данные"
    @FindBy(how = How.XPATH, using = "//p[contains(@class, 'Account_text__fZAIn')]")
    private SelenideElement blockWithText;
    //Иконка бургера
    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'AppHeader_header__logo__2D0X2')]")
    private SelenideElement burgerLabel;
    //Кнопка "Конструктор"
    @FindBy(how = How.XPATH, using = "//*[.='Конструктор']")
    private SelenideElement constructorButton;
    //Кнопка "Выход"
    @FindBy(how = How.XPATH, using = "//li[@class='Account_listItem__35dAP']/button[text()='Выход']")
    private SelenideElement exitButton;

    public void clickExitButton(){
        exitButton.click();
    }
    public void clickBurgerLabel(){
        burgerLabel.click();
    }
    public void clickConstructorButton(){
        constructorButton.click();
    }


}

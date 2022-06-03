package unils.pageobjectmodels;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AuthPage {
    public  static final String AUTH_PAGE_URL="https://stellarburgers.nomoreparties.site/login";

    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'Auth_login__3hAey')]/h2[text() ='Вход']")
    public SelenideElement lableEnter;

    //Список полей для регистрации
    @FindAll(@FindBy(how = How.CLASS_NAME,using = "input__textfield"))
    public ElementsCollection autorizationFields;

    @FindBy(how = How.CLASS_NAME, using = "button_button__33qZ0")
    public SelenideElement enterButtonAuth;

}

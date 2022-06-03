package unils.pageobjectmodels;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage extends AuthPage {

    public  static final String REGISTRATION_PAGE_URL="https://stellarburgers.nomoreparties.site/register";

    //Кнопка "Зарегестрироваться"
    @FindBy(how = How.XPATH, using = "//button[contains(@class,'button_button__33qZ0 ')]")
    public SelenideElement buttonRegistration;

    //Список полей для регистрации
    @FindAll(@FindBy(how = How.CLASS_NAME,using = "input__textfield"))
    public ElementsCollection registrationFields;
    //Сообщение об ошибке
    @FindBy(how = How.CLASS_NAME,using = "input__error")
    public SelenideElement errorMessage;

    //Сообщение об ошибке
    @FindBy(how = How.CLASS_NAME,using = "Auth_link__1fOlj")
    public SelenideElement enterButtonRegistration;

    //Личный кабинет
    @FindBy(how = How.XPATH, using = "//*[.='Личный Кабинет']")
    public SelenideElement personalArea;
    //Личный кабинет
    @FindAll(@FindBy(how = How.XPATH, using = "//div[contains(@class, 'input__container')]//input[contains(@class, 'input__textfield')]"))
    public ElementsCollection nameAndEmail;

  /*  //Пароль
    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'input_type_password')]/input[contains(@class, 'input__textfield')]")
    public SelenideElement passwordField;*/


}

package unils.pageobjectmodels;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage extends AuthPage {

    public static final String REGISTRATION_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";

    //Кнопка "Зарегестрироваться"
    @FindBy(how = How.XPATH, using = "//button[contains(@class,'button_button__33qZ0 ')]")
    private SelenideElement buttonRegistration;

    //Список полей для регистрации
    @FindAll(@FindBy(how = How.CLASS_NAME, using = "input__textfield"))
    private ElementsCollection registrationFields;
    //Сообщение об ошибке
    @FindBy(how = How.CLASS_NAME, using = "input__error")
    private SelenideElement errorMessage;

    //Сообщение об ошибке
    @FindBy(how = How.CLASS_NAME, using = "Auth_link__1fOlj")
    private SelenideElement enterButtonRegistration;

    //Личный кабинет
    @FindBy(how = How.XPATH, using = "//*[.='Личный Кабинет']")
    private SelenideElement personalArea;
    //Личный кабинет
    @FindAll(@FindBy(how = How.XPATH, using = "//div[contains(@class, 'input__container')]//input[contains(@class, 'input__textfield')]"))
    private ElementsCollection nameAndEmail;

  /*  //Пароль
    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'input_type_password')]/input[contains(@class, 'input__textfield')]")
    public SelenideElement passwordField;*/

    public void clickOnEnterButtonRegistration() {
        enterButtonRegistration.click();
    }

    public void inputCredentialsRegistration(Integer num, String credential) {
        registrationFields.get(num).setValue(credential);
    }

    public void clickOnButtonRegistration() {
        buttonRegistration.click();
    }
    public String getTextErrorMessage() {
        String text=errorMessage.getText();
        return text;
    }

    public  void clickOnPersonalAreaButton() {
        personalArea.click();
    }
}


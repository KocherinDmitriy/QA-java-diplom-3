package unils.pageobjectmodels;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPage extends AuthPage {

    public  static final String FORGOT_PASSWORD_PAGE_URL="https://stellarburgers.nomoreparties.site/forgot-password";

    @FindBy(how = How.CLASS_NAME,using = "Auth_link__1fOlj")
    private SelenideElement enterButtonForgot;

    public void clickOnEnterButtonForgot() {
        enterButtonForgot.click();
    }

}

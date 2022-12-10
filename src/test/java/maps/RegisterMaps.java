package maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterMaps {

    @FindBy(css = "#menu-item-50 > a") public WebElement linkMyAccount;
    @FindBy(css = "#reg_email") public WebElement inputEmail;
    @FindBy(css = "#reg_password") public WebElement inputPassword;
    @FindBy(css = "*[name='register']") public WebElement submitRegister;
    @FindBy(css = ".page-content") public WebElement errorMessage;

}
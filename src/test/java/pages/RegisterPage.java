package pages;

import core.Driver;
import maps.RegisterMap;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    RegisterMap registerMap;

    public RegisterPage() {
        registerMap = new RegisterMap();
        PageFactory.initElements(Driver.getDriver(), registerMap);
    }

    public void setEmailAdress(String email) {
        Driver.visibilityOf(registerMap.inputEmail);
        if (email != null) {
            registerMap.inputEmail.sendKeys(email);
        }
    }

    public void setPassword(String password) {
        Driver.visibilityOf(registerMap.inputPassword);
        if (password != null) {
            registerMap.inputPassword.sendKeys(password);
        }
    }

    public void clickRegister() {
        Driver.visibilityOf(registerMap.submitRegister);
        registerMap.submitRegister.click();
    }

    public String getErrorMessage() {
        Driver.visibilityOf(registerMap.errorMessage);
        return registerMap.errorMessage.getText();
    }
}

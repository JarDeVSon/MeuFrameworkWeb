package pages;

import core.Driver;
import maps.RegisterMaps;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    RegisterMaps registerMaps;

    public RegisterPage() {
        registerMaps = new RegisterMaps();
        PageFactory.initElements(Driver.getDriver(), registerMaps);
    }

    public void clickMyAccount() {
        Driver.visibilityOf(registerMaps.linkMyAccount);
        registerMaps.linkMyAccount.click();
    }

    public void setEmailAdress(String email) {
        if (email != null) {
            registerMaps.inputEmail.sendKeys(email);
        }
    }

    public void setPassword(String password) {
        if (password != null) {
            registerMaps.inputPassword.sendKeys(password);
        }
    }

    public void clickRegister() {
        Driver.visibilityOf(registerMaps.submitRegister);
        registerMaps.submitRegister.click();
    }

    public String getErrorMessage() {
        Driver.visibilityOf(registerMaps.errorMessage);
        return registerMaps.errorMessage.getText();
    }
}

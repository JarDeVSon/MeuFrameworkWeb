package pages;

import core.Driver;
import maps.Register2Map;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Register2Page {
    Register2Map register2Map;

    public Register2Page(){
        register2Map = new Register2Map();
        PageFactory.initElements(Driver.getDriver(), register2Map);
    }
    public void setSelectCountry1(String country){
        Driver.visibilityOf(register2Map.select2Country);
        Select select = new Select(register2Map.select2Country);
        select.selectByVisibleText(country);
    }

    public void setSelectCountry2(String country){
        Driver.visibilityOf(register2Map.select2Country);
        Select select = new Select(register2Map.select2Country);
        select.selectByVisibleText(country);
    }

}

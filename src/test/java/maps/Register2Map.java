package maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Register2Map {

    @FindBy(css = "#countries")
    public WebElement select1Country;

    @FindBy(css = "#country")
    public WebElement select2Country;

}

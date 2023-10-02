package maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DatepickerMap {
    @FindBy(css = "#datepicker1")
    public WebElement datePickerDisabled;

    @FindBy(css = "#datepicker2")
    public WebElement datePickerEnabled;


}

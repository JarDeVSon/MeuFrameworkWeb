package pages;

import core.Driver;
import maps.DatepickerMap;
import org.openqa.selenium.support.PageFactory;

public class DatepickerPage {
    DatepickerMap datepickerMap;

    public DatepickerPage() {
        datepickerMap = new DatepickerMap();
        PageFactory.initElements(Driver.getDriver(), datepickerMap);
    }

    public void setDatapickerDisabled(String date){
        Driver.visibilityOf(datepickerMap.datePickerDisabled);
        if(date != null){
            datepickerMap.datePickerDisabled.sendKeys(date);
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public void setDatepickerEnabled(String date){
        Driver.visibilityOf(datepickerMap.datePickerEnabled);
        if (date != null) {
            datepickerMap.datePickerEnabled.sendKeys(date);
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

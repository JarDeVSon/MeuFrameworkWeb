package steps;

import io.cucumber.java.en.When;
import pages.DatepickerPage;

import java.util.Map;

public class DatepickerSteps {

    DatepickerPage datepickerPage = new DatepickerPage();

    @When("i choose the following date in datepicker")
    public void iChooseTheFollowingDateInDatepicker(Map<String,String> map) {
        String datepickerdisabled = map.get("datepickerdisabled");
        String datepickerenabled = map.get("datepickerenabled");

        datepickerPage.setDatapickerDisabled(datepickerdisabled);
        datepickerPage.setDatepickerEnabled(datepickerenabled);

    }


}

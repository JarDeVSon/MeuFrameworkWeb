package steps;

import core.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.DatepickerPage;
import utils.PropertiesUtils;

import java.util.Map;

public class DatepickerSteps {

    DatepickerPage datepickerPage = new DatepickerPage();
    PropertiesUtils propertiesUtils = new PropertiesUtils();
    @When("i choose the following date in datepicker")
    public void iChooseTheFollowingDateInDatepicker(Map<String,String> map) {
        String datepickerdisabled = map.get("datepickerdisabled");
        String datepickerenabled = map.get("datepickerenabled");

        datepickerPage.setDatapickerDisabled(datepickerdisabled);
        datepickerPage.setDatepickerEnabled(datepickerenabled);

    }


    @Given("Open the browser and Enter the URL Datepicker")
    public void openTheBrowserAndEnterTheURLDatepicker() throws Exception {

        try {
            Driver.getDriver().get(propertiesUtils.getProperty("url_datepicker"));
            Driver.printScreenshot("Open the browser and Enter the URL Datepicker");
        } catch (Exception e) {
            throw new Exception("Not open the browser");
        }
    }
}

package steps;

import core.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.Register2Page;
import utils.PropertiesUtils;

import java.util.Map;

public class Register2Steps {

    Register2Page register2Page = new Register2Page();
    PropertiesUtils propertiesUtils = new PropertiesUtils();

    @When("I fill in the following information")
    public void i_fill_in_the_following_information(Map<String, String> map) throws Exception {
        try {
           // String country1 = map.get("country1");
            String country2 = map.get("country2");
           // register2Page.setSelectCountry1(country1);
            //System.out.println(country1);
            register2Page.setSelectCountry2(country2);
            System.out.println(country2);
            Driver.printScreenshot("I fill in the following information");
        } catch (Exception e) {
            throw new Exception("Error in fill information");
        }
    }


    @Given("Open the browser and Enter the URL Register")
    public void openTheBrowserAndEnterTheURLRegister() throws Exception {
        try {
            Driver.getDriver().get(propertiesUtils.getProperty("url_register"));
            Driver.printScreenshot("Open the browser and Enter the URL Register");
        } catch (Exception e) {
            throw new Exception("Not open the browser");
        }
    }
}

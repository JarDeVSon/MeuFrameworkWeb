package steps;

import core.Driver;
import io.cucumber.java.en.When;
import pages.Register2Page;

import java.util.Map;

public class Register2Steps {

    Register2Page register2Page = new Register2Page();

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


}

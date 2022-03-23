package steps;

import com.github.javafaker.Faker;
import core.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.RegisterPage;

import java.util.Map;


public class RegisterSteps {
    RegisterPage registerPage = new RegisterPage();
    Faker faker = new Faker();
    HomePage homePage = new HomePage();


    @Given("Open the browser and Enter the URL {string}")
    public void open_the_browser_and_enter_the_url(String string) throws Exception {
        try {
            Driver.getDriver().get(string);
            Driver.printScreenshot("Open the browser and Enter the URL");
        } catch (Exception e) {
            throw new Exception("Not open the browser");
        }

    }

    @When("Click on My Account Menu")
    public void click_on_my_account_menu() throws Exception {
        try {
            registerPage.clickMyAccount();
            Driver.printScreenshot("Click on My Account Menu");
        } catch (Exception e) {
            throw new Exception("Not Click on My Account Menu");
        }

    }

    @And("Enter registered Email Address in Email-Address textbox")
    public void enterRegisteredEmailAddressInEmailAddressTextbox() throws Exception {
        try {
            registerPage.setEmailAdress(faker.internet().emailAddress());
            Driver.printScreenshot("Enter registered Email Address in Email-Address textbox");
        } catch (Exception e) {
            throw new Exception("Not Enter your own password in password textbox");
        }
    }

    @And("Enter your own password in password textbox")
    public void enterYourOwnPasswordInPasswordTextbox() throws Exception {
        try {
            registerPage.setPassword(faker.internet().password(8, 15, true, true, true));
            Driver.printScreenshot("Enter your own password in password textbox");
        } catch (Exception e) {
            throw new Exception("Not Enter your own password in password textbox");
        }
    }


    @When("Click on Register button")
    public void click_on_register_button() throws Exception {

        try {
            registerPage.clickRegister();
            Driver.printScreenshot("Click on Register button");
        } catch (Exception e) {
            throw new Exception("Not Click on Register button");
        }
    }

    @Then("User will be registered successfully and will be navigated to the Home page")
    public void user_will_be_registered_successfully_and_will_be_navigated_to_the_home_page() throws Exception {

        try {
            String home = homePage.getTitleUser();
            Assert.assertEquals(homePage.getTitleUser(), home);
            Driver.printScreenshot("User will be registered successfully and will be navigated to the Home page");
        } catch (Exception e) {
            throw new Exception("Not User will be registered successfully and will be navigated to the Home page");
        }
    }

    @When("Enter Email Address in Email-Address textbox")
    public void enter_email_address_in_email_address_textbox(Map<String, String> map) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        try {
            registerPage.setEmailAdress(map.get("email"));
            Driver.printScreenshot("Enter Email Address in Email-Address textbox");
        } catch (Exception e) {
            throw new Exception("Error in Enter Email Address in Email-Address textbox");
        }
    }

    @When("Enter password in password textbox")
    public void enter_password_in_password_textbox(Map<String, String> map) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        try {
            registerPage.setPassword(map.get("password"));
            Driver.printScreenshot("Enter password in password textbox");
        } catch (Exception e) {
            throw new Exception("Error in Enter password in password textbox");
        }
    }

    @Then("Registration must fail with a warning message")
    public void registrationMustFailWithAWarningMessage() throws Exception {
        try {
            String error = registerPage.getErrorMessage();
            Assert.assertEquals(registerPage.getErrorMessage(), error);
            Driver.printScreenshot("Registration must fail with a warning message");
        } catch (Exception e) {
            throw new Exception("Error in Registration must fail with a warning message");
        }

    }

}



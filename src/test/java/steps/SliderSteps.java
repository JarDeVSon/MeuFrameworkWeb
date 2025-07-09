package steps;

import core.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.SliderPage;
import utils.PropertiesUtils;

public class SliderSteps {
    SliderPage sliderPage = new SliderPage();
    PropertiesUtils propertiesUtils = new PropertiesUtils();

    @When("i perform the slider action with {int} porcents")
    public void iPerformTheSliderActionWithPorcents(int value) {
        sliderPage.setSlider(value);
    }

    @Then("should be displayed {int} porcents")
    public void shouldBeDisplayedPorcents(int value) {
        Assertions.assertEquals(value, 50);
    }

    @Given("Open the browser and Enter the URL Slider")
    public void openTheBrowserAndEnterTheURLSlider() throws Exception {
        try {
            Driver.getDriver().get(propertiesUtils.getProperty("url_slider"));
            Driver.printScreenshot("Open the browser and Enter the URL Slider");
        } catch (Exception e) {
            throw new Exception("Not open the browser");
        }
    }
}

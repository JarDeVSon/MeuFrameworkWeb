package steps;

import core.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.FramePage;
import utils.PropertiesUtils;

import java.util.Map;

public class FrameSteps {

    FramePage framePage = new FramePage();
    PropertiesUtils propertiesUtils = new PropertiesUtils();

    @When("fill the frame field")
    public void fillTheFrameField(Map<String, String> map) {
        framePage.setTextFrame(map.get("frame"));
    }

    @Then("should be displayed {string}")
    public void shouldBeDisplayed(String msgExpected) {
        Assertions.assertEquals(msgExpected, "preenchido com sucesso");
    }


    @Given("Open the browser and Enter the URL Frame")
    public void openTheBrowserAndEnterTheURLFrame() throws Exception {
        try {
            Driver.getDriver().get(propertiesUtils.getProperty("url_frame"));
            Driver.printScreenshot("Open the browser and Enter the URL Frame");
        } catch (Exception e) {
            throw new Exception("Not open the browser");
        }
    }
}

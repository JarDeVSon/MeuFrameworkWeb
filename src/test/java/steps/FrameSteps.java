package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.FramePage;

import java.util.Map;

public class FrameSteps {

    FramePage framePage = new FramePage();

    @When("fill the frame field")
    public void fillTheFrameField(Map<String, String> map) {
        framePage.setTextFrame(map.get("frame"));
    }

    @Then("should be displayed {string}")
    public void shouldBeDisplayed(String msgExpected) {
        Assert.assertEquals(msgExpected, "preenchido com sucesso");
    }


}

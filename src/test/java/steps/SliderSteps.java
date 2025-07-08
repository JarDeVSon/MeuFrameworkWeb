package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.SliderPage;

public class SliderSteps {
    SliderPage sliderPage = new SliderPage();


    @When("i perform the slider action with {int} porcents")
    public void iPerformTheSliderActionWithPorcents(int value) {
        sliderPage.setSlider(value);
    }

    @Then("should be displayed {int} porcents")
    public void shouldBeDisplayedPorcents(int value) {
        Assertions.assertEquals(value, 50);
    }
}

package steps;

import core.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.DragDropPage;
import utils.PropertiesUtils;

public class DragDropSteps {
    DragDropPage dragDropPage = new DragDropPage();
    PropertiesUtils propertiesUtils = new PropertiesUtils();
    @When("i perform the drag drop action")
    public void iPerformTheDragDropAction() {
       dragDropPage.dragAndDrop();
    }

    @Given("Open the browser and Enter the URL Dragdrop")
    public void openTheBrowserAndEnterTheURLDragdrop() throws Exception {
        try {
            Driver.getDriver().get(propertiesUtils.getProperty("url_drag_drop"));
            Driver.printScreenshot("Open the browser and Enter the URL Slider");
        } catch (Exception e) {
            throw new Exception("Not open the browser");
        }

    }
}

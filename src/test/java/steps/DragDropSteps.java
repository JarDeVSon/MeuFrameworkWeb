package steps;

import io.cucumber.java.en.When;
import pages.DragDropPage;

public class DragDropSteps {
    DragDropPage dragDropPage = new DragDropPage();

    @When("i perform the drag drop action")
    public void iPerformTheDragDropAction() {
       dragDropPage.dragAndDrop();
    }
}

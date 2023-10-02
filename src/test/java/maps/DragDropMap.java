package maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DragDropMap {

    @FindBy(css = "#draggable")
    public WebElement itemDraggable;

    @FindBy(css = "#target")
    public WebElement targetDrop;

}

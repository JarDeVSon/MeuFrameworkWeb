package pages;

import core.Driver;
import maps.DragDropMap;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class DragDropPage {

    DragDropMap dragDropMap;

    public DragDropPage(){
        dragDropMap = new DragDropMap();
        PageFactory.initElements(Driver.getDriver(),dragDropMap);
    }

    public void dragAndDrop(){
        Driver.visibilityOf(dragDropMap.itemDraggable);
        Driver.visibilityOf(dragDropMap.targetDrop);
        Actions actions = new Actions(Driver.getDriver());
        int offset = 100;
        actions.dragAndDropBy(dragDropMap.itemDraggable,offset,0)
                .dragAndDropBy(dragDropMap.itemDraggable, 0, offset)
                .dragAndDropBy(dragDropMap.itemDraggable, -offset,0)
                .dragAndDropBy(dragDropMap.itemDraggable, 0,-offset)
                .build().perform();
        actions.dragAndDrop(dragDropMap.itemDraggable, dragDropMap.targetDrop).build().perform();


    }
}

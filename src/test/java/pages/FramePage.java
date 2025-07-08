package pages;

import core.Driver;
import maps.FrameMap;
import org.openqa.selenium.support.PageFactory;

public class FramePage {
    FrameMap frameMap;

    public FramePage(){
        frameMap = new FrameMap();
        PageFactory.initElements(Driver.getDriver(),frameMap);
    }

    public void setTextFrame(String text){
        Driver.getDriver().switchTo().frame(frameMap.iframe);
        frameMap.inputIframe.sendKeys(text);
    }
}

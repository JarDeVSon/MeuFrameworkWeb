package maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FrameMap {
    @FindBy(css = "#singleframe")
    public WebElement iframe;

    @FindBy(css = "div > input[type=text]")
    public WebElement inputIframe;

}

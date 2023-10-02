package pages;

import core.Driver;
import maps.SliderMap;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

public class SliderPage {

    SliderMap sliderMap;

    public SliderPage(){
        sliderMap = new SliderMap();
        PageFactory.initElements(Driver.getDriver(),sliderMap);
    }
    public int setSlider(int porcents){

        for (int i = 0; i < porcents; i++) {
            sliderMap.slider.sendKeys(Keys.ARROW_RIGHT);
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }
}

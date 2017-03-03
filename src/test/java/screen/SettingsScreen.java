package screen;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

/**
 * Created by josepforonda on 01/03/2017.
 */
public class SettingsScreen extends AbstractScreen{

    public SettingsScreen (AppiumDriver driver) {
        super(driver);
    }

    //@AndroidFindBy(xpath = "//*[@class='android.widget.TextView'][@text='Advanced settings']")
    //private MobileElement advancedButton;


    public void clickOnAdvancedSettings () {
        findElementWithTimeout(By.xpath("//*[@class='android.widget.TextView'][@text='Advanced settings']"), 1).click();
    }

}

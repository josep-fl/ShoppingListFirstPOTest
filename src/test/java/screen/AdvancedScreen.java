package screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

/**
 * Created by josepforonda on 01/03/2017.
 */
public class AdvancedScreen extends AbstractScreen {

    public AdvancedScreen (AppiumDriver driver) {
        super(driver);
    }


    //@AndroidFindBy(xpath = "//*[@class='android.widget.TextView'][@text='Not shown']")
    //private MobileElement priorityButton;

    //@AndroidFindBy(xpath = "//*[@class='android.widget.TextView']")
    //private MobileElement tickedButton;


    public void swipeDownFourTimes() {

        Dimension size;

        //Get the size of screen.
        size = driver.manage().window().getSize();
        //System.out.println(size);

        //Find swipe start and end point from screen's with and height.
        //Find starty point which is at bottom side of screen.
        int starty = (int) (size.height * 0.80);
        //Find endy point which is at top side of screen.
        int endy = (int) (size.height * 0.20);
        //Find horizontal point where you wants to swipe. It is in middle of screen width.
        int startx = size.width / 2;
        //System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);

        //Swipe from Bottom to Top three times
        driver.swipe(startx, starty, startx, endy, 3000);
        //Thread.sleep(2000);
        driver.swipe(startx, starty, startx, endy, 3000);
        //Thread.sleep(2000);
        driver.swipe(startx, starty, startx, endy, 3000);
        //Thread.sleep(2000);
        driver.swipe(startx, starty, startx, endy, 3000);
        //Thread.sleep(2000);

    }

    public void changePriority() {

        // click priority
        findElementWithTimeout(By.xpath("//*[@class='android.widget.TextView'][@text='Not shown']"), 1).click();

        // click priority 1
        findElementWithTimeout(By.xpath("//*[@class='android.widget.CheckedTextView'][@text='Priority 1']"), 1).click();

        // click ticked
        findElementWithTimeout(By.xpath("//*[@class='android.widget.TextView']"), 1).click();

    }



}

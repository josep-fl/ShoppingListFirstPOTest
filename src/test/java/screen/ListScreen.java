package screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

/**
 * Created by josepforonda on 01/03/2017.
 */
public class ListScreen extends AbstractScreen {

    @AndroidFindBy(id = "org.openintents.shopping:id/autocomplete_add_item")
    private MobileElement addField;

    @AndroidFindBy(id = "org.openintents.shopping:id/button_add_item")
    private MobileElement addButton;

    @AndroidFindBy(xpath = "//*[@class='android.widget.ImageButton'][@content-desc='More options']")
    private MobileElement moreButton;

    //@AndroidFindBy(xpath = "//*[@class='android.widget.TextView'][@text='Settings']")
    //private MobileElement settingsButton;

    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView'][@content-desc='Clean up list']")
    private MobileElement deleteButton;

    @AndroidFindBy(id = "org.openintents.shopping:id/check")
    private MobileElement selectItem;


    public ListScreen(AppiumDriver driver) {
        super(driver);
    }

    private String item1 = "edible stuff";
    private String item2 = "cleaning stuff";

    public void enterTwoShoppingItems() {
        addField.sendKeys(item1);
        addButton.click();
        addField.sendKeys(item2);
        addButton.click();
    }

    public void deleteOneItemFromList() {
        selectItem.click();
        deleteButton.click();
    }



    public boolean isResultCorrect() {
        try {
            //look for second item
            MobileElement item = (MobileElement) (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.id("org.openintents.shopping:id/name")));
            assertEquals(item.getText(), item2);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void clickOnSettings() {
        moreButton.click();
        findElementWithTimeout(By.xpath("//*[@class='android.widget.TextView'][@text='Settings']"), 1).click();
    }
}

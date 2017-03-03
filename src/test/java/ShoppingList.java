import io.appium.java_client.AppiumDriver;
import screen.AdvancedScreen;
import screen.ListScreen;
import screen.SettingsScreen;

/**
 * Created by josepforonda on 01/03/2017.
 */
public class ShoppingList {
    private final AppiumDriver driver;

    public ShoppingList(AppiumDriver driver) {
        this.driver = driver;
    }

    public ListScreen listScreen() { return new ListScreen(driver); }
    public SettingsScreen settingsScreen() { return new SettingsScreen(driver); }
    public AdvancedScreen advancedScreen() { return new AdvancedScreen(driver); }

}

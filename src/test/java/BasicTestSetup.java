import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testobject.appium.junit.TestObjectAppiumSuite;
import org.testobject.appium.junit.TestObjectTestResultWatcher;
import org.testobject.rest.api.appium.common.TestObject;


import java.io.File;
import java.net.URL;

import static org.junit.Assert.assertEquals;

/**
 * Created by josepforonda on 27/02/2017.
 */



public class BasicTestSetup extends AbstractTest{

    @Test
    public void addDeleteShoppingItems() {
        app.listScreen().enterTwoShoppingItems();
        app.listScreen().deleteOneItemFromList();
        app.listScreen().isResultCorrect();
    }

    @Test
    public void visitAdvancedSettings() {
        app.listScreen().clickOnSettings();
        app.settingsScreen().clickOnAdvancedSettings();
        app.advancedScreen().swipeDownFourTimes();
        app.advancedScreen().changePriority();
    }

}

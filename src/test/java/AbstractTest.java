import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testobject.appium.junit.TestObjectTestResultWatcher;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by josepforonda on 01/03/2017.
 */
public abstract class AbstractTest {


    // Sets the test name to the name of the test method.
    @Rule
    public TestName testName = new TestName();


    /* Set the test result watcher to send test results to TestObject. */
    @Rule
    public TestObjectTestResultWatcher resultWatcher = new TestObjectTestResultWatcher();



    private AppiumDriver driver;
    protected ShoppingList app;


    /* Establish a connection to TestObject, or to a local device test is local. */
    @Before
    public void connect() throws MalformedURLException {


        DesiredCapabilities capabilities = new DesiredCapabilities();


        // ONLY REMOTE - These are the capabilities we must provide to run our test on TestObject
        // environment variables!!
        capabilities.setCapability("testobject_api_key", System.getenv("TESTOBJECT_API_KEY"));
        capabilities.setCapability("testobject_device", System.getenv("TESTOBJECT_DEVICE"));


        // ONLY LOCAL
//        capabilities.setCapability("deviceName", "testDevice");
//        capabilities.setCapability(CapabilityType.PLATFORM, "Android");
//        capabilities.setCapability("platformVersion", "6");

//        File file = new File("/Users/josepforonda/Downloads", "OI-Shopping-List_1.7.0.5.apk");
//        capabilities.setCapability("app", file.getAbsolutePath());

        // The driver will take care of establishing the connection, so we must provide
        // it with the correct endpoint and the requested capabilities.
        driver = new AndroidDriver(new URL("http://appium.testobject.com/wd/hub"), capabilities); //remote
//        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities); //local



        resultWatcher.setAppiumDriver(driver);
        app = new ShoppingList(driver);

    }
}

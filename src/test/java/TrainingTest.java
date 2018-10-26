
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class TrainingTest {

    private String accessKey = "yourAccessKey";
    private String host = "https://yourURL";
    private Integer port = 443;
    protected IOSDriver<IOSElement> driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();
    @BeforeTest
    public void setUp() throws MalformedURLException
    {
        dc.setCapability("testName", "MyTest");
        dc.setCapability("accessKey", accessKey);
        dc.setCapability("deviceQuery", "@os='ios' and @category='PHONE'");
        dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
        driver = new IOSDriver<>(new URL("https://uscloud.experitest.com/wd/hub"), dc);

    }
    //You Task is the following:
    /*
    Go to https://www.premierleague.com/stats
    Find the name link to the top player.
    Navigate to the top Players page
    print out his age
    */

    @Test
    public void InccompleteTest() {
        driver.rotate(ScreenOrientation.PORTRAIT);
        //include the steps here:

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

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

    private String accessKey = "eyJ4cC51IjozLCJ4cC5wIjoyLCJ4cC5tIjoiTVRVeE5URXdNVFl4T0Rrd01RIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjE4NDc3MjA2MjAsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.iO3_E7cnbOwwK-6CfwoSCGTD_2XzTBlt47w_NG5ehks";
    private String host = "https://atb.experitest.com";
    private Integer port = 443;
    protected IOSDriver<IOSElement> driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();
    @BeforeTest
    public void setUp() throws MalformedURLException
    {
        dc.setCapability("testName", "MyTest");
        dc.setCapability("accessKey", accessKey);
        dc.setCapability("deviceQuery", "@os='ios' and @category='PHONE'");
        dc.setBrowserName("SAFARI");
        driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), dc);

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
        driver.get("https://www.premierleague.com/stats");
        driver.context("WEBVIEW_1");
        WebElement player = driver.findElement(By.xpath("//*[@text='EdenHazard']"));
        player.click();
        WebElement age = driver.findElement(By.xpath(("(//*/*[@text and @nodeName='DIV' and @width>0])[36]")));
        String result = age.getAttribute("text");
        System.out.println(result);

    }

    @AfterTest
    public void tearDown() {
        driver.quit();

    }
}
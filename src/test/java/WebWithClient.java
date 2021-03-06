import com.google.gson.JsonParser;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileBrowserType;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.json.simple.*;

import java.net.MalformedURLException;
import java.net.URL;

public class WebWithClient {

    private String accessKey = "eyJ4cC51IjozLCJ4cC5wIjoyLCJ4cC5tIjoiTVRVeE5URXdNVFl4T0Rrd01RIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjE4NDc3MjA2MjAsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.iO3_E7cnbOwwK-6CfwoSCGTD_2XzTBlt47w_NG5ehks";
    private String host = "https://uscloud.experitest.com";
    protected IOSDriver<IOSElement> driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();


    @BeforeTest
    public void setUp() throws MalformedURLException {
        dc.setCapability("testName", "Quick Start iOS Browser Demo");
        dc.setCapability("accessKey", accessKey);
        dc.setCapability("deviceQuery", "@os='ios' and @category='PHONE'");
        dc.setBrowserName(MobileBrowserType.SAFARI);
        driver = new IOSDriver<>(new URL("https://uscloud.experitest.com/wd/hub"), dc);
    }

    @Test
    public void quickStartiOSBrowserDemo() {
        driver.rotate(ScreenOrientation.PORTRAIT);
        driver.get("https://www.google.com");
        driver.context("WEBVIEW_1");
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".gLFyf")));
        WebElement searchBar = driver.findElement(By.cssSelector(".gLFyf"));
        searchBar.click();
        searchBar.sendKeys("Experitest");
        searchBar.sendKeys(Keys.ENTER);

        //See https://docs.experitest.com/display/TD/Additional+Commands
        driver.executeScript("experitest:client.install(\"cloud:com.experitest.ExperiBank\", \"true\", \"true\")");


    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

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

public class SimpleTest {

    private String accessKey = "eyJ4cC51IjozLCJ4cC5wIjoyLCJ4cC5tIjoiTVRVeE5URXdNVFl4T0Rrd01RIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjE4NDc3MjA2MjAsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.iO3_E7cnbOwwK-6CfwoSCGTD_2XzTBlt47w_NG5ehks";
    private String host = "https://uscloud.experitest.com/wd/hub";
    private Integer port = 443;
    protected IOSDriver<IOSElement> driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();


    @BeforeTest
    public void setUp() throws MalformedURLException
        {
            dc.setCapability("reportDirectory", "reports");
            dc.setCapability("reportFormat", "xml");
            dc.setCapability("testName", "SimpleTest");
            dc.setCapability("accessKey", accessKey);
            dc.setCapability("deviceQuery", "@os='ios' and @category='PHONE'");
            dc.setCapability("instrumented",true);
            dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank");
            dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
            driver = new IOSDriver<>(new URL(host), dc);
        }

    @Test
    public void quickStartiOSNativeDemo() {

        driver.rotate(ScreenOrientation.PORTRAIT);
        driver.findElement(By.xpath("//*[@id='usernameTextField']")).sendKeys("company");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//*[@id='passwordTextField']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@id='loginButton']")).click();
   /*     driver.findElement(By.xpath("//*[@id='makePaymentButton']")).click();
        driver.findElement(By.xpath("//*[@id='phoneTextField']")).sendKeys("0541234567");
        driver.findElement(By.xpath("//*[@id='nameTextField']")).sendKeys("Jon Snow");
        driver.findElement(By.xpath("//*[@id='amountTextField']")).sendKeys("50");
        driver.findElement(By.xpath("//*[@id='countryButton']")).click();
        driver.findElement(By.xpath("//*[@id='Switzerland']")).click();
        driver.findElement(By.xpath("//*[@id='sendPaymentButton']")).click();
        driver.findElement(By.xpath("//*[@id='Yes']")).click();*/
        driver.context("WEBVIEW_1"); //In Appium we don't need to switch to a selenium Driver: Appium already acts as one in the right context
        WebElement balanceStr = driver.findElement(By.cssSelector("[nodeName=H1]"));
        System.out.println(balanceStr.getText());
        Assert.assertEquals("Your balance is:  100.00$ ", balanceStr.getText());


    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
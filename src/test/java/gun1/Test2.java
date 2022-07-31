package gun1;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;

public class Test2 {

    AppiumDriverLocalService service;

    @Test
    public void test1() throws MalformedURLException {

        service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingAnyFreePort()
                .withLogFile(new File("appium.log"))
                .build();
        service.clearOutPutStreams(); //consola appium ciktilarini yazmaz.
        service.start();


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:udid", "emulator-5554");
        capabilities.setCapability("appium:version", "11");
        capabilities.setCapability("appium:deviceName", "SamsungEmulator");
        capabilities.setCapability("platformName", "Android");


        capabilities.setCapability("appium:appPackage", "io.appium.android.apis");
        capabilities.setCapability("appium:appActivity", "io.appium.android.apis.ApiDemos");

        // RemoteWebDriver -> WebDriver -> AppiumDriver --> (AndroidDriver, iOSDriver)

        AppiumDriver<MobileElement> driver;


        driver = new AndroidDriver<>(service.getUrl(), capabilities);

        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Accessibility']")).click();

        driver.closeApp();
        service.stop();

    }
}



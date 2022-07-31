package gun2;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.App;
import utils.Device;
import utils.Driver;
import utils.Utils;


public class Test01 {

    AppiumDriverLocalService service;
    AppiumDriver<?> driver;

    WebDriverWait wait;


    @Test
    public void runAppiumTest() {
        Driver.runAppium();

        Driver.stopAppium();
    }

    @Test
    public void testGetDriver() {
        Driver.runAppium();
        driver = Driver.getDriver(Device.PIXEL2, App.APIDEMO);

        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Accessibility']")).click();

        driver.closeApp();

        Driver.stopAppium();
    }

    @Test
    public void openAppTest(){
        By accessibility = By.xpath("//android.widget.TextView[@content-desc='Accessibility']");
        By customView = By.xpath("//android.widget.TextView[@content-desc='Custom View']");

        driver = Utils.openApp(Device.PIXEL2,App.APIDEMO);

        wait = new WebDriverWait(driver,20);

        wait.until(ExpectedConditions.elementToBeClickable(accessibility)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(customView));
        driver.navigate().back();
        driver.closeApp();
        Driver.stopAppium();
    }

}




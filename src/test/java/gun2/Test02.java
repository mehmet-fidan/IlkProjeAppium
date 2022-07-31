package gun2;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.App;
import utils.Device;
import utils.Driver;
import utils.Utils;

import java.net.URL;
import java.util.concurrent.LinkedBlockingDeque;

public class Test02 {

    AppiumDriver<?> driver;
    WebDriverWait wait;

    By accessibility = By.xpath("//android.widget.TextView[@content-desc='Accessibility']");
    By customView = By.xpath("//android.widget.TextView[@content-desc='Custom View']");

    @BeforeTest
    public void beforeTest() {

        driver = Utils.openApp(Device.PIXEL2, App.APIDEMO);
        wait = new WebDriverWait(driver, 20);
    }

    @Test
    public void test1() {

        wait.until(ExpectedConditions.elementToBeClickable(accessibility)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(customView));
        driver.navigate().back();
    }

    @Test
    public void test2(){
        By lApp = Utils.getXPathOfTextView("App");
        By lAlertDialoge = Utils.getXPathOfTextView("Alert Dialogs");
        By lAlertDialogeList = By.xpath("//android.widget.Button[@content-desc][1]");
        By lButtonOk = By.id("android:id/button1");

        click(lApp);
        click(lAlertDialoge);
        click(lAlertDialogeList);
        click(lButtonOk);

    }

    public void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void click(MobileElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    @AfterTest
    public void afterTest(){
        driver.closeApp();
        Driver.stopAppium();
    }
}

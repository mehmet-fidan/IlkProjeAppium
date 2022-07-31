package gun2;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import jdk.jshell.execution.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.App;
import utils.Device;
import utils.Driver;
import utils.Utils;

public class TestCalculator {

    AppiumDriver<?> driver;
    WebDriverWait wait;


    By lSifir = By.id("com.dencreak.dlcalculator:id/pad_btn_e_a");
    By lCiftSifir = By.id("com.dencreak.dlcalculator:id/pad_btn_e_b");
    By lNokta = By.id("com.dencreak.dlcalculator:id/pad_btn_e_c");
    By lEsit = By.id("com.dencreak.dlcalculator:id/pad_img_e_d");

    By lBir = By.id("com.dencreak.dlcalculator:id/pad_btn_d_a");
    By lIki = By.id("com.dencreak.dlcalculator:id/pad_btn_d_b");
    By lUc = By.id("com.dencreak.dlcalculator:id/pad_btn_d_c");
    By lToplam = By.id("com.dencreak.dlcalculator:id/pad_img_d_d");

    By lDort = By.id("com.dencreak.dlcalculator:id/pad_btn_c_a");
    By lBes = By.id("com.dencreak.dlcalculator:id/pad_btn_c_b");
    By lAlti = By.id("com.dencreak.dlcalculator:id/pad_btn_c_c");
    By lCikarma = By.id("com.dencreak.dlcalculator:id/pad_img_c_d");

    By lYedi = By.id("com.dencreak.dlcalculator:id/pad_btn_b_a");
    By lSekiz = By.id("com.dencreak.dlcalculator:id/pad_btn_b_b");
    By lDokuz = By.id("com.dencreak.dlcalculator:id/pad_btn_b_c");
    By lCarpma = By.id("com.dencreak.dlcalculator:id/pad_img_b_d");

    By lClear = By.id("com.dencreak.dlcalculator:id/pad_img_a_a");
    By lParantez = By.id("com.dencreak.dlcalculator:id/pad_img_a_b");
    By lYuzde = By.id("com.dencreak.dlcalculator:id/pad_img_a_c");
    By lBolme = By.id("com.dencreak.dlcalculator:id/pad_img_a_d");

    By lSonucEkrani = By.id("com.dencreak.dlcalculator:id/lay_normal_body_val");


    @BeforeTest
    public void beforeTest() {
        driver = Utils.openApp(Device.PIXEL2, App.CALCULATOR);
        wait = new WebDriverWait(driver, 20);
    }

    @Test
    public void sum1(){

        click(lIki);
        click(lBes);
        click(lCarpma);
        click(lUc);
        click(lBes);
        click(lEsit);

        System.out.println(getTextOf(lSonucEkrani));
        Assert.assertEquals(getTextOf(lSonucEkrani).replaceAll("[^0-9-,]",""),"875");

    }
    public void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public String getTextOf(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    @AfterTest
    public void afterTest(){
        driver.closeApp();
        Driver.stopAppium();
    }

    /*
        Cep Telefonu hesap makinesinde asagidaki islemleri yapiniz ve sonucu assert ediniz
        1+1 = 2
        123 + 435 = 558
        1,23 + 5,7 = 6,93
        34 - 12 = 22
        12 - 34 = -22
        25 x 35 = 900
        1,2 x 2,1 = 2,52
        10/4 = 2,5
        10/3 = 3.33333333
 */
}

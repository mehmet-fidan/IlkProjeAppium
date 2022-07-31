package gun3;

import io.appium.java_client.AppiumDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Driver;


import java.util.List;

public class CalculatorSteps {

   AppiumDriver<?> driver;
    WebDriverWait wait;

    {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, 20);
    }

    By lScreen = By.id("com.dencreak.dlcalculator:id/lay_normal_body_val");
    By lToplam =By.id("com.dencreak.dlcalculator:id/pad_img_d_d");
    By lEsit = By.id("com.dencreak.dlcalculator:id/pad_img_e_d");


    @Given("user on start page")
    public void userOnStartPage() {

        driver.resetApp();
      //  driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    @When("user sum the following numbers")
    public void userSumTheFollowingNumbers(DataTable table) {

        List<Integer> list = table.asList(Integer.class);
       int max = list.size();
        int i =1;
        for (Integer num : list) {
            click(num);
            if (i++ != max){
                click(lToplam);
            }
        }
        click(lEsit);
    }

    @Then("the result should be {int}")
    public void theResultShouldBe(int result) {

        Assert.assertTrue(driver.findElement(lScreen).getText().contains(result+""));
    // driver.rotate(ScreenOrientation.PORTRAIT);
    }

    public void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void click(int num){
        if (num>=0 && num<=9)
            click(By.xpath("//android.widget.Button[@text='" + num + "']"));

    }
}

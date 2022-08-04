package gun3;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.App;
import utils.Device;

import java.util.Arrays;

import static utils.Utils.openApp;

@CucumberOptions(

        features = {"src/test/java/gun3"},
        glue = {"gun3"},
        tags = "@Sum"

)

public class RunnerCalculator extends AbstractTestNGCucumberTests {
    @BeforeTest
    @Parameters({"device"})
    public void beforeTest(@Optional("a") String device){

        if (Arrays.toString(Device.values()).contains(device))
            openApp(Device.valueOf(device), App.CALCULATOR);
        else
            openApp(Device.PIXEL2, App.CALCULATOR);

    }
}

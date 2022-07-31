package gun3;

import io.cucumber.java.BeforeAll;
import utils.App;
import utils.Device;
import utils.Driver;
import utils.Utils;

import static utils.Utils.openApp;

public class Hooks {

    @BeforeAll
    public static void beforeAll() {
        if (Driver.getDriver() == null)
            openApp(Device.PIXEL2, App.CALCULATOR);
    }
}

package saudi.sfc;

import org.testng.annotations.Test;
import saudi.SaudiLocation;

public class SfcLocation extends SaudiLocation {
    @Test(dependsOnMethods={"addSuccessfully"})
    public void editSuccessfully() throws Exception {
        System.out.println("SFC Location [Test] -> editSuccessfully");
    }
}

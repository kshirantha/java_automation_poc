package saudi;

import core.CoreLocation;
import org.testng.annotations.Test;

public class SaudiLocation extends CoreLocation {
    @Test(dependsOnMethods={"addSuccessfully"})
    public void editSuccessfully() throws Exception {
        System.out.println("Saudi Location [Test] -> editSuccessfully");
    }

    @Test(dependsOnMethods={"editSuccessfully"})
    public void approveSuccessfully() throws Exception {
        System.out.println("Saudi Location [Test] -> approveSuccessfully");
    }

    @Test(dependsOnMethods={"approveSuccessfully"})
    public void verifyStatusHistorySuccessfully() throws Exception {
        System.out.println("Saudi Location [Test] -> verifyStatusHistorySuccessfully");
    }

    @Override
    public void beforeSaveLocation(){
        super.beforeSaveLocation();
        System.out.println("Saudi Location -> beforeSaveLocation");
    }
}

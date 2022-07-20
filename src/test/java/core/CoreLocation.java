package core;

import org.testng.annotations.Test;

public class CoreLocation extends BaseTest {
    @Test()
    public void addSuccessfully() throws Exception {
        System.out.println("Core Location [Test] -> addSuccessfully");
        beforeSaveLocation();
        saveLocation();
    }

    @Test(dependsOnMethods={"addSuccessfully"})
    public void editSuccessfully() throws Exception {
        System.out.println("Core Location [Test] -> editSuccessfully");
    }

    @Test(dependsOnMethods={"editSuccessfully"})
    public void approveSuccessfully() throws Exception {
        System.out.println("Core Location [Test] -> approveSuccessfully");
    }

    public void beforeSaveLocation(){
        System.out.println("Core Location -> beforeSaveLocation");
    }

    public void saveLocation(){
        System.out.println("Core Location -> saveLocation");
    }
}

package core;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CoreCity extends BaseTest {
    @Test()
    public void testCase1() throws Exception {
        System.out.println("Core City [Test] -> testCase1");
        driver.get("http://localhost:4200/");
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("kasun");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.id("app-login-button")).click();
    }

    @Test(dependsOnMethods={"testCase1"})
    public void testCase2() throws Exception {
        System.out.println("Core City [Test] -> testCase2");
    }

    @Test(dependsOnMethods={"testCase2"})
    public void testCase3() throws Exception {
        System.out.println("Core City [Test] -> testCase3");
    }
}

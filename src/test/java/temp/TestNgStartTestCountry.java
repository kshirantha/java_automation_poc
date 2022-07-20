package temp;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestNgStartTestCountry extends TestNgStartTest {
    @Test
    public void testCase() throws Exception {
        driver.get("http://localhost:4200/");
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("kasun");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.id("app-login-button")).click();
    }
}

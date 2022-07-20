package temp;

import org.junit.Test;
import org.openqa.selenium.By;

public class JunitStartTestCountry extends JunitStartTest {
    @Test
    @Override
    public void testCase1() throws Exception {
        System.out.println("Country Test Case");
        driver.get("http://localhost:4200/");
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("kasun");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.id("app-login-button")).click();
    }
}
package temp;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class JunitStartTest {
    protected static WebDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {
        System.out.println("Core Test setUp");
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chrome/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testCase0() throws Exception {
        System.out.println("Core Test Case 0");
    }

    @Test
    public void testCase1() throws Exception {
        System.out.println("Core Test Case 1");
        driver.get("http://192.168.14.214/");
        driver.findElement(By.xpath("/html/body/dfnat-root/div/ng-component/div/div/div/form/div/div/div[1]/dfnat-textinput/div/input")).click();
        driver.findElement(By.xpath("/html/body/dfnat-root/div/ng-component/div/div/div/form/div/div/div[1]/dfnat-textinput/div/input")).clear();
        driver.findElement(By.xpath("/html/body/dfnat-root/div/ng-component/div/div/div/form/div/div/div[1]/dfnat-textinput/div/input")).sendKeys("lakmal");
        driver.findElement(By.xpath("/html/body/dfnat-root/div/ng-component/div/div/div/form/div/div/div[2]/dfnat-passwordinput/input")).clear();
        driver.findElement(By.xpath("/html/body/dfnat-root/div/ng-component/div/div/div/form/div/div/div[2]/dfnat-passwordinput/input")).sendKeys("123");
        driver.findElement(By.xpath("/html/body/dfnat-root/div/ng-component/div/div/div/form/div/div/div[3]/div/div/div[1]/button")).click();
    }

    @Test
    public void testCase2() throws Exception {
        System.out.println("Core Test Case 2");
    }
}
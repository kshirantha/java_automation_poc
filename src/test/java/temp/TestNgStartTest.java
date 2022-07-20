package temp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNgStartTest {
    protected static WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chrome/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testCase() throws Exception {
        driver.get("http://192.168.14.214/");
        driver.findElement(By.xpath("/html/body/dfnat-root/div/ng-component/div/div/div/form/div/div/div[1]/dfnat-textinput/div/input")).click();
        driver.findElement(By.xpath("/html/body/dfnat-root/div/ng-component/div/div/div/form/div/div/div[1]/dfnat-textinput/div/input")).clear();
        driver.findElement(By.xpath("/html/body/dfnat-root/div/ng-component/div/div/div/form/div/div/div[1]/dfnat-textinput/div/input")).sendKeys("lakmal");
        driver.findElement(By.xpath("/html/body/dfnat-root/div/ng-component/div/div/div/form/div/div/div[2]/dfnat-passwordinput/input")).clear();
        driver.findElement(By.xpath("/html/body/dfnat-root/div/ng-component/div/div/div/form/div/div/div[2]/dfnat-passwordinput/input")).sendKeys("123");
        driver.findElement(By.xpath("/html/body/dfnat-root/div/ng-component/div/div/div/form/div/div/div[3]/div/div/div[1]/button")).click();
    }
}

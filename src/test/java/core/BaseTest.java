package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    protected static WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception {
        System.out.println("Base Test [Before Class] -> setUp");
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chrome/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterSuite
    public void close() throws Exception {
        driver.quit();
    }
}

package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import properties.loader.PropertyProvider;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeMethod
    public void driverSetUp() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        if (Boolean.parseBoolean(PropertyProvider.getProperty("test.remote.run"))) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("chrome");
            capabilities.setVersion("74.0");
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", false);

            driver = new RemoteWebDriver(URI.create("http://192.168.42.156:4444/wd/hub/").toURL(), capabilities);
        } else {
            driver = new ChromeDriver();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
}

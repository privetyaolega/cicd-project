import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URI;

public class BaseTest {

    protected WebDriver driver;

//    @BeforeMethod
//    public void setUpDriver() {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
//    }

    public void getPage(String url) {
        driver.get(url);
    }

    @BeforeMethod
    public void bla() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("74.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);

        driver = new RemoteWebDriver(
                URI.create("http://192.168.42.156:4444/wd/hub/").toURL(),
                capabilities
        );
        System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
        driver.manage().window().maximize();
    }
}

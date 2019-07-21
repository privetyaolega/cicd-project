package base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleMainPage extends BaseTest {

    @FindBy(xpath = "//div[@id = 'searchform']//input[@name = 'q']")
    private static WebElement searchTextBox;

    @FindBy(xpath = "//div[@class = 'FPdoLc VlcLAe']/center/input[contains(@value, 'Google')]")
    private static WebElement searchButton;

    public static void searchFor(String text) {
        PageFactory.initElements(driver, new GoogleMainPage());
        searchTextBox.sendKeys(text);
        searchTextBox.submit();
    }
}
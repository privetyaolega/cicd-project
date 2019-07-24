import base.GoogleMainPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestGoogleSearchFor extends GoogleMainPage {

    private String searchPhrase = "Hello World";

    @Test
    public void test() {
        driver.get("https://www.google.com");
        searchFor(searchPhrase);

        Assert.assertTrue(driver.getTitle().contains(searchPhrase));
    }
}
import base.GoogleMainPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestGoogleSearchFor extends GoogleMainPage {

    private String searchPhrase = "Hello World";

    @Test
    public void testPass() {
        driver.get("https://www.google.com");
        searchFor(searchPhrase);

        Assert.assertTrue(driver.getTitle().contains(searchPhrase));
    }

    @Test
    public void testFail() {
        driver.get("https://www.google.com");
        searchFor(searchPhrase);

        Assert.assertTrue(driver.getTitle().contains(searchPhrase + "123"));
    }

    @Test
    public void testPass1() {
        Assert.assertTrue(true);
    }

    @Test
    public void testFail1() {
        Assert.assertTrue(false);
    }
}
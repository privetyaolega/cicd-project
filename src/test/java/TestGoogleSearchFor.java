import base.GoogleMainPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;


public class TestGoogleSearchFor extends GoogleMainPage {

    private String searchPhrase = "Hello World";

    @Test
    public void test() {
        driver.get("https://www.google.com");
        searchFor(searchPhrase);

        Assertions.assertThat(driver.getTitle()).contains(searchPhrase);
    }
}
import org.testng.annotations.Test;

public class Test1 extends BaseTest {

    @Test
    public void test() {
        getPage("https://www.google.com");
        driver.get("https://www.google.com");

    }
}
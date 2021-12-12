import org.testng.annotations.Test;
import java.io.IOException;

public class HomePage extends BaseTest {

    @Test
    public void basePageNavigation() throws IOException, InterruptedException {
        driver = initializeDriver();
        driver.get("http://the-internet.herokuapp.com/");
    }
}

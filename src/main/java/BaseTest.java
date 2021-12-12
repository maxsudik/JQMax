import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    public void initializeDriver() throws IOException {

        //TODO add webdriver manager
        Properties properties = new Properties();
        FileInputStream file = new FileInputStream("src/main/resources/local.properties");
        properties.load(file);
        String browser = properties.getProperty("browser");

        if (browser.equals("chrome")) {

            //TODO define condition
        } else if (browser.equals("edge")) {
            //TODO define condition

        } else if (browser.equals("safari")) {
            //TODO define condition

        } else if (browser.equals("firefox")) {
            //TODO define condition

        }

    }
}

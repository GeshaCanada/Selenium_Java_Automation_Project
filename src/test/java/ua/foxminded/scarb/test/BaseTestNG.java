package ua.foxminded.scarb.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import ua.foxminded.scarb.helpers.ConfigLoader;
import ua.foxminded.scarb.helpers.NotSupportedBrowserException;
import ua.foxminded.scarb.helpers.WebDriverFactory;
import java.time.Duration;
import java.util.Properties;

public class BaseTestNG {

    protected WebDriver driver;
    protected String baseUrl = "https://skarb.foxminded.ua/";
    private static final String IMPLICIT_WAIT_TIMEOUT_PROPERTY = "implicit.wait.timeout.seconds";

    @BeforeTest
    public void setUp() throws NotSupportedBrowserException {
        driver = WebDriverFactory.create();
        configureDriver();
        driver.get(baseUrl);
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void configureDriver() {
        Properties config = ConfigLoader.loadConfig("src/config.properties");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(Long.parseLong(config.getProperty(IMPLICIT_WAIT_TIMEOUT_PROPERTY, "7")))
        );
    }
}

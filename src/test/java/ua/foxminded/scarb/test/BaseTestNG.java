package ua.foxminded.scarb.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import ua.foxminded.scarb.helpers.NotSupportedBrowserException;
import ua.foxminded.scarb.helpers.WebDriverFactory;
import java.time.Duration;

public class BaseTestNG {

    protected WebDriver driver;
    protected String baseUrl = "https://skarb.foxminded.ua/";

        @BeforeTest
        public void setUp () throws NotSupportedBrowserException {
        driver = WebDriverFactory.create();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.get(baseUrl);

    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

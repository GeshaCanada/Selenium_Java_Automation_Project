package ua.foxminded.scarb.test;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import ua.foxminded.scarb.helpers.NotSupportedBrowserException;
import ua.foxminded.scarb.helpers.WebDriverFactory;

public class BaseTestJUnit {

    protected WebDriver driver;
    protected String baseUrl = "https://skarb.foxminded.ua/";

    @BeforeEach
    public void setUp() throws NotSupportedBrowserException {
        driver = WebDriverFactory.create();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
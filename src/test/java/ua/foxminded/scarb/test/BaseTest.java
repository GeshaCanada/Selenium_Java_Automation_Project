package ua.foxminded.scarb.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import ua.foxminded.scarb.helpers.NotSupportedBrowserException;
import ua.foxminded.scarb.helpers.WebDriverFactory;

public class BaseTest {
    protected WebDriver driver;
    protected String baseUrl = "https://skarb.foxminded.ua/";

    @BeforeTest
    public void setUp() throws NotSupportedBrowserException {
        driver = WebDriverFactory.create();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

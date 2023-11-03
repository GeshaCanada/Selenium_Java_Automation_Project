package ua.foxminded.scarb.helpers;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestSetup {
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

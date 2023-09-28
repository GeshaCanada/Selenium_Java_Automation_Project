package ua.foxminded.scarb.test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ua.foxminded.scarb.helpers.NotSupportedBrowserException;
import ua.foxminded.scarb.helpers.WebDriverFactory;

public class ScarbHomePageTest {
    private WebDriver driver;
    private String baseUrl = "https://skarb.foxminded.ua/";

    @BeforeTest
    public void setUp() throws NotSupportedBrowserException {

        // просим WebDriverFactory создать driver
        driver = WebDriverFactory.create();
        driver.manage().window().maximize();
        driver.get(baseUrl);

    }

    @Test
    public void getToHomePageTest() {

        WebElement title = driver.findElement(By.cssSelector("h4.text-dark-red"));
        Assert.assertEquals(title.getText(), "SKARB NGO");
    }

    @Test
    public void checkContactUsTest() {
        WebElement contactUs = driver.findElement(By.partialLinkText("Связаться с нами"));
        contactUs.click();
        WebElement page = driver.findElement(By.cssSelector("title.info_title.title--red"));
        Assert.assertEquals(page.getText(), "Свяжитесь с нами");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

package ua.foxminded.scarb.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import ua.foxminded.scarb.helpers.NotSupportedBrowserException;
import ua.foxminded.scarb.helpers.WebDriverFactory;

public class ScarbHomeButtonTest {
    private WebDriver driver;
    private String baseUrl = "https://skarb.foxminded.ua/";

    @BeforeMethod
    public void setUp() throws NotSupportedBrowserException {

        // просим WebDriverFactory создать driver
        driver = WebDriverFactory.create();
        driver.manage().window().maximize();
        driver.get(baseUrl);

    }

    @Test
    public void getButtonTextTest() {
        //driver.get(baseUrl);

        WebElement button = driver.findElement(By.cssSelector("button[name=tasks-button]"));
        Assert.assertEquals(button.getText(), "Смотреть задачи");
    }

    @Test
    public void taskButtonActionTest() {

        WebElement button = driver.findElement(By.cssSelector("div.statistic button"));
        button.click();
        WebElement title = driver.findElement(By.cssSelector("h2"));
        Assert.assertEquals(title.getText(), "Поиск задач");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

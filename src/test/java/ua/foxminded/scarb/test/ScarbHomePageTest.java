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
        driver.get(baseUrl);

    }

    @Test
    public void getToHomePageTest() {

        WebElement title = driver.findElement(By.cssSelector("h4.text-dark-red"));
        Assert.assertEquals(title.getText(), "SKARB NGO");
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
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

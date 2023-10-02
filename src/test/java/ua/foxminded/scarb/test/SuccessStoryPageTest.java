package ua.foxminded.scarb.test;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ua.foxminded.scarb.helpers.NotSupportedBrowserException;
import ua.foxminded.scarb.helpers.WebDriverFactory;

public class SuccessStoryPageTest {

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
    public void checkSuccessStoryPageTextTest() {

        WebElement pageTitle = driver.findElement(By.linkText("Истории успеха"));
        Assert.assertTrue(pageTitle.isDisplayed());

    }

    @Test
    public void checkNavigationToSuccessStoryPageTest() {

        WebElement pageTitle = driver.findElement(By.linkText("Истории успеха"));
        pageTitle.click();

    }

    @Test
    public void checkSearchInputTest() {

        WebElement pageTitle = driver.findElement(By.linkText("Истории успеха"));
        pageTitle.click();
        // Find the search input element
        WebElement searchInput = driver.findElement(By.cssSelector("input[id='storyNameSearchFilter']"));
        // Enter a search query
        String searchQuery = "Web";
        searchInput.sendKeys(searchQuery);
        // Press Enter to submit the search
        searchInput.sendKeys(Keys.RETURN);

    }

    @Test
    public void showMoreSuccessStoriesFunctionTest() {

        WebElement pageTitle = driver.findElement(By.linkText("Истории успеха"));
        pageTitle.click();
        WebElement showMoreLink = driver.findElement(By.linkText("Показать больше"));
        // Проверяем, что ссылка видима и активна
        Assert.assertTrue(showMoreLink.isDisplayed(), "Ссылка 'Показать больше' не видима.");
        Assert.assertTrue(showMoreLink.isEnabled(), "Ссылка 'Показать больше' не активна.");
        showMoreLink.click();

    }

    @Test
    public void checkNavigateHomePageTest() {

        WebElement pageTitle = driver.findElement(By.linkText("Истории успеха"));
        pageTitle.click();
        WebElement link = driver.findElement(By.cssSelector("h4.text-dark-red"));
        link.click();
        String currentUrl = driver.getCurrentUrl();;
        String expectedUrl = "https://skarb.foxminded.ua/";
        Assert.assertEquals(currentUrl, expectedUrl, "После нажатия 'SKARB NGO' не была открыта ожидаемая страница.");

    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

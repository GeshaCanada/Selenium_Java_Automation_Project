package ua.foxminded.scarb.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.foxminded.scarb.helpers.NotSupportedBrowserException;
import ua.foxminded.scarb.helpers.WebDriverFactory;
import utils.RandomDataGenerator;
import utils.RandomDataGenerator2;
import java.time.Duration;
import java.util.List;

public class PartnerPageRegistrationTest {
    private WebDriver driver;
    private String baseUrl = "https://skarb.foxminded.ua/";
    private String emailURL = "https://skarbmail.foxminded.ua/";
    @BeforeMethod
    public void setUp() throws NotSupportedBrowserException {
        driver = WebDriverFactory.create();
        driver.manage().window().maximize();
    }
    @Test
    public void checkPartnerFormTest() {
        driver.get(baseUrl);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/registration']"))).click();

        List<WebElement> elements = driver.findElements(By.xpath("//button[contains(@class, 'btn-success')]"));
        if (!elements.isEmpty()) {
            elements.get(0).click();
        }

        String emailPartnerValue = RandomDataGenerator2.generateRandomEmail();
        String companyNameValue = RandomDataGenerator2.generateRandomString();
        String firstNameValue = RandomDataGenerator2.generateRandomString();
        String lastNameValue = RandomDataGenerator2.generateRandomString();
        String positionNameValue = RandomDataGenerator2.generateRandomString();
        String passwordValue = RandomDataGenerator.generateStrongPassword();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='email']"))).sendKeys(emailPartnerValue);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='organizationName']"))).sendKeys(companyNameValue);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='firstName']"))).sendKeys(firstNameValue);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='lastName']"))).sendKeys(lastNameValue);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='positionInOrganization']"))).sendKeys(positionNameValue);

        WebElement sexBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='female']")));
        sexBox.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input#password"))).sendKeys(passwordValue);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input#confirmPassword"))).sendKeys(passwordValue);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form//div[3]/button"))).click();
    }
    @Test
    public void checkRegistrationPartnerFormTest() {
        driver.get(emailURL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Подтверждение регистрации']//ancestor::span"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, 'https://skarb.foxminded.ua/registration/confirm')]"))).click();
    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

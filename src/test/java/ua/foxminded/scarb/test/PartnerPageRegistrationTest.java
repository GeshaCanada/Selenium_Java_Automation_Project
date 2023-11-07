package ua.foxminded.scarb.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import ua.foxminded.scarb.helpers.NotSupportedBrowserException;
import ua.foxminded.scarb.helpers.WebDriverFactory;
import utils.RandomStringGenerator;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class PartnerPageRegistrationTest {
    private WebDriver driver;
    private String baseUrl = "https://skarb.foxminded.ua/";
    private String emailUrl = "https://skarbmail.foxminded.ua/";
    private String registrationUrl = baseUrl + "registration/confirm";
    private String passwordValue = RandomStringGenerator.generateStrongPassword();

    @BeforeTest
    public void setUp() throws NotSupportedBrowserException {
        driver = WebDriverFactory.create();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
    }

    @Test
    public void checkPartnerFormAndRegistrationPartnerFormTest() {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//a[@href='/registration']")).click();
        driver.findElement(By.xpath("//button[contains(@class, 'btn-success')]")).click();

        List<WebElement> inputFields = driver.findElements(By.xpath("//input"));
        inputFields.get(0).sendKeys(RandomStringGenerator.generateRandomEmail());
        inputFields.get(2).sendKeys(RandomStringGenerator.generateRandomString());
        inputFields.get(3).sendKeys(RandomStringGenerator.generateRandomString());
        inputFields.get(5).click();
        inputFields.get(6).sendKeys(passwordValue);
        inputFields.get(7).sendKeys(passwordValue);
        inputFields.get(8).sendKeys(RandomStringGenerator.generateRandomString());
        inputFields.get(11).sendKeys(RandomStringGenerator.generateRandomString());

        driver.findElement(By.xpath("//form//div[3]/button")).click();

        driver.get(emailUrl);
        driver.findElement(By.xpath("//*[text()='Подтверждение регистрации']//ancestor::span")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'https://skarb.foxminded.ua/registration/confirm')]")).click();

        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            driver.switchTo().window(handle);
            if (driver.getCurrentUrl().equals(registrationUrl)) {
                WebElement page = driver.findElement(By.xpath("//*[contains(text(), 'Ваш email подтверждено')]"));
                System.out.println(page.getText());
                break;
            }
        }
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

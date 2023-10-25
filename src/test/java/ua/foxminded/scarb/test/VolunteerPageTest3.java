package ua.foxminded.scarb.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ua.foxminded.scarb.helpers.NotSupportedBrowserException;
import ua.foxminded.scarb.helpers.WebDriverFactory;
import utils.RandomStringGenerator;
import java.util.List;

public class VolunteerPageTest3 {
    private WebDriver driver;
    private String baseUrl = "https://skarb.foxminded.ua/";
    private String passwordValue = RandomStringGenerator.generateStrongPassword();

    @BeforeEach
    public void setUp() throws NotSupportedBrowserException {
        driver = WebDriverFactory.create();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void checkVolunteerFormTest1() {
        WebElement registrationLink = driver.findElement(By.cssSelector(".nav-link.ml-auto"));
        if (registrationLink != null) {
            registrationLink.click();
        } else {
            Assertions.fail("Registration link not found");
        }

        WebElement btn = driver.findElement(By.cssSelector("[name=volunteers] .btn "));
        if (btn != null) {
            btn.click();
        } else {
            Assertions.fail("Button not found");
        }

        List<WebElement> inputFields = driver.findElements(By.xpath("//input"));
        if (!inputFields.isEmpty()) {
            inputFields.get(0).sendKeys(RandomStringGenerator.generateRandomString());
            inputFields.get(1).sendKeys(RandomStringGenerator.generateRandomString());
            inputFields.get(2).sendKeys(RandomStringGenerator.generateRandomEmail());
            inputFields.get(4).sendKeys(passwordValue);
            inputFields.get(5).sendKeys(passwordValue);
        } else {
            Assertions.fail("Input field not found");
        }

        Assertions.assertAll("Password and confirm password fields",
                () -> {
                    if (inputFields.size() <= 12) {
                        inputFields.get(4).sendKeys(passwordValue);
                        inputFields.get(5).sendKeys(passwordValue);
                    } else {
                        Assertions.fail("Insufficient input fields found");
                    }
                },
                () -> {
                    if (!inputFields.get(4).getAttribute("value").equals(inputFields.get(5).getAttribute("value"))) {
                        Assertions.fail("Password and confirm password fields do not match");
                    }
                }
        );

        Assertions.assertTrue(driver.getCurrentUrl().contains("registration"));
        Assertions.assertEquals("Регистрация волонтера", driver.getTitle());

        WebElement btnSuccess = driver.findElement(By.className("btn-success"));
        if (btnSuccess != null) {
            btnSuccess.click();
        } else {
            Assertions.fail("Success button not found");
        }
        // Add other assertions for other fields
        Assertions.assertTrue(driver.getCurrentUrl().contains("success"));
        Assertions.assertEquals("Регистрация", driver.getTitle());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

package ua.foxminded.scarb.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ua.foxminded.scarb.helpers.NotSupportedBrowserException;
import ua.foxminded.scarb.helpers.WebDriverFactory;
import utils.RandomDataGenerator;

public class VolunteerPageTest1 {
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
    public void checkVolunteerFormTest1() {
        WebElement registrationLink = driver.findElement(By.cssSelector(".nav-link.ml-auto"));
        registrationLink.click();
        WebElement btn = driver.findElement(By.cssSelector("[name=volunteers] .btn "));
        btn.click();

        String firstNameValue = RandomDataGenerator.generateRandomString();
        String lastNameValue = RandomDataGenerator.generateRandomString();
        String emailValue = RandomDataGenerator.generateRandomString() + "@gmail.com";
        String phoneValue = RandomDataGenerator.generateRandomNumber();
        String passwordValue = RandomDataGenerator.generateStrongPassword();

        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys(firstNameValue);
        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys(lastNameValue);
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys(emailValue);
        WebElement phoneNumber = driver.findElement(By.id("phoneNumber"));
        phoneNumber.sendKeys(phoneValue);
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(passwordValue);
        WebElement confirmPassword = driver.findElement(By.id("confirmPassword"));
        confirmPassword.sendKeys(passwordValue);

        WebElement btnSuccess = driver.findElement(By.className("btn-success"));
        btnSuccess.click();

    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


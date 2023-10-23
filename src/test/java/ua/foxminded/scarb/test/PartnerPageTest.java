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
import utils.RandomStringGenerator;

public class PartnerPageTest {
    private WebDriver driver;
    private String baseUrl = "https://skarb.foxminded.ua/";

    @BeforeTest
    public void setUp() throws NotSupportedBrowserException {
        driver = WebDriverFactory.create();
        driver.manage().window().maximize();
    }

    @Test
    public void checkPartnerFormTest() {
        driver.get(baseUrl);
        WebElement registrationLink = driver.findElement(By.xpath("//a[@href='/registration']"));
        registrationLink.click();
        WebElement btnPartner = driver.findElement(By.xpath("//button[contains(@class, 'btn-success') ]"));
        btnPartner.click();

        String emailPartnerValue = RandomStringGenerator.generateRandomEmail();
        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys(emailPartnerValue);

        String companyNameValue = RandomStringGenerator.generateRandomString();
        WebElement companyName = driver.findElement(By.xpath("//input[@id='organizationName']"));
        companyName.sendKeys(companyNameValue);

        String firstNameValue = RandomStringGenerator.generateRandomString();
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstName']"));
        firstName.sendKeys(firstNameValue);

        String lastNameValue = RandomStringGenerator.generateRandomString();
        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastName']"));
        lastName.sendKeys(lastNameValue);

        String positionNameValue = RandomStringGenerator.generateRandomString();
        WebElement positionName = driver.findElement(By.xpath("//input[@id='positionInOrganization']"));
        positionName.sendKeys(positionNameValue);

        WebElement sexBox = driver.findElement(By.xpath("//input[@id='female']"));
        sexBox.click();

        String passwordValue = RandomDataGenerator.generateStrongPassword();
        WebElement password = driver.findElement(By.cssSelector("input#password"));
        password.sendKeys(passwordValue);
        WebElement confirmPassword = driver.findElement(By.cssSelector("input#confirmPassword"));
        confirmPassword.sendKeys(passwordValue);

        WebElement btnSuccess = driver.findElement(By.xpath("//form//div[3]/button"));
        btnSuccess.click();
    }


    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

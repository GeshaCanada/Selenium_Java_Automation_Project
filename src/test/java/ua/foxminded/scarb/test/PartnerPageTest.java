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
import utils.RandomDataGenerator2;

public class PartnerPageTest {

    private WebDriver driver;
    private String baseUrl = "https://skarb.foxminded.ua/";


    @BeforeTest
    public void setUp() throws NotSupportedBrowserException {

        driver = WebDriverFactory.create();
        driver.manage().window().maximize();
        driver.get(baseUrl);

    }

    @Test
    public void checkPartnerFormTest() {
        WebElement registrationLink = driver.findElement(By.xpath("//a[@href='/registration']"));
        registrationLink.click();
        WebElement btnPartner = driver.findElement(By.xpath("//button[contains(@class, 'btn-success') ]"));
        btnPartner.click();

        String emailPartnerValue = RandomDataGenerator2.generateRandomEmail();
        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys(emailPartnerValue);

        String companyNameValue = RandomDataGenerator2.generateRandomString1();
        WebElement companyName = driver.findElement(By.xpath("//input[@id='organizationName']"));
        companyName.sendKeys(companyNameValue);

        String firstNameValue = RandomDataGenerator2.generateRandomString2();
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstName']"));
        firstName.sendKeys(firstNameValue);

        String lastNameValue = RandomDataGenerator2.generateRandomString2();
        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastName']"));
        lastName.sendKeys(lastNameValue);

        String positionNameValue = RandomDataGenerator2.generateRandomString1();
        WebElement positionName = driver.findElement(By.xpath("//input[@id='positionInOrganization']"));
        positionName.sendKeys(positionNameValue);

        WebElement sexBox = driver.findElement(By.xpath("//input[@id='female']"));
        sexBox.click();

        String passwordValue = RandomDataGenerator.generateStrongPassword();
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

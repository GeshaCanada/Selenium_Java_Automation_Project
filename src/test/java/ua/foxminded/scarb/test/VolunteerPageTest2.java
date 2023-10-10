package ua.foxminded.scarb.test;

import org.instancio.Instancio;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ua.foxminded.scarb.Volunteer;
import ua.foxminded.scarb.helpers.NotSupportedBrowserException;
import ua.foxminded.scarb.helpers.WebDriverFactory;
import utils.RandomDataGenerator;

import static org.instancio.Select.field;


public class VolunteerPageTest2 {

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
    public void checkVolunteerFormTest2() {
        WebElement registrationLink = driver.findElement(By.cssSelector(".nav-link.ml-auto"));
        registrationLink.click();
        WebElement btn = driver.findElement(By.cssSelector("[name=volunteers] .btn "));
        btn.click();

        Volunteer volunteer = Instancio.of(Volunteer.class)
                .generate(field(Volunteer::getEmail), gen -> gen.text().pattern("#a#a#a#a#a#a@yahoo.com"))
                .generate(field(Volunteer::getPhoneNumber), gen -> gen.text().pattern(8 + "#d#d#d#d#d#d#d#d#d"))
                //.generate(field(Volunteer::getFirstName), gen -> gen.text().pattern("[a-z]{12}"))
                //.generate(field(Volunteer::getLastName), gen -> gen.text().pattern ("[a-z]{12}"))
                //.generate(field(Volunteer::getPassword), gen -> gen.text().pattern("[A-Z][A-Z][a-z][a-z][0-9]{8}[!@#$%^&*()_+\\-=\\[\\]{};':\",.<>/?\\\\|]"))
                .create();

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys(volunteer.getEmail());

        WebElement phoneNumber = driver.findElement(By.id("phoneNumber"));
        phoneNumber.sendKeys(volunteer.getPhoneNumber());

        String randomNameValue = RandomDataGenerator.generateRandomString();
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys(randomNameValue);
        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys(randomNameValue);

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



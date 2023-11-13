package ua.foxminded.scarb.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;
import utils.RandomStringGenerator;

import java.util.Arrays;
import java.util.List;


public class VolunteerPage extends BasePage {

    @FindBy(css = (".nav-link.ml-auto"))
    private WebElement registrationLink;

    @FindBy(css = ("[name=volunteers] .btn "))
    private WebElement buttonVolunteers;

    @FindBy(className = ("btn-success"))
    private WebElement buttonSuccess;

    @FindBy(id = ("firstName"))
    private WebElement field1;

    @FindBy(id = ("lastName"))
    private WebElement field2;

    @FindBy(id = ("email"))
    private WebElement field3;

    @FindBy(id = ("password"))
    private WebElement field4;

    @FindBy(id = ("confirmPassword"))
    private WebElement field5;



    public VolunteerPage(WebDriver driver) {
        super(driver);
    }

    public void registrationLinkClick() {
        registrationLink.click();
    }

    public void buttonClick() {
        buttonVolunteers.click();
    }

    public void fillRegistrationForm() {
        SoftAssert softAssert = new SoftAssert();
        List<WebElement> inputFields = Arrays.asList(field1, field2, field3, field4, field5);
        String passwordValue = RandomStringGenerator.generateStrongPassword();
        if (inputFields.size() == 5) {
            inputFields.get(0).sendKeys(RandomStringGenerator.generateRandomString());
            inputFields.get(1).sendKeys(RandomStringGenerator.generateRandomString());
            inputFields.get(2).sendKeys(RandomStringGenerator.generateRandomEmail());
            inputFields.get(3).sendKeys(passwordValue);
            inputFields.get(4).sendKeys(passwordValue);
        } else {
            softAssert.fail("Insufficient input fields found");
        }

        softAssert.assertAll();
    }

    public void assertRegistrationPage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.getCurrentUrl().contains("registration"), "URL does not contain 'registration'");
        softAssert.assertEquals(driver.getTitle(), "Регистрация волонтера", "Title is not 'Регистрация волонтера'");
        softAssert.assertAll();
    }

    public void assertSuccessButton() {
        try {
            buttonSuccess.click();
        } catch (NoSuchElementException e) {
            Assertions.fail("Success button not found");
        }
    }

    public void assertSuccessPage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.getCurrentUrl().contains("success"), "URL does not contain 'success'");
        softAssert.assertEquals(driver.getTitle(), "Регистрация", "Title is not 'Регистрация'");
        softAssert.assertAll();
    }

}


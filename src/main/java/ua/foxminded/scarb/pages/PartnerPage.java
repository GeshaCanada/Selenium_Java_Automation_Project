package ua.foxminded.scarb.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;
import utils.RandomStringGenerator;
import java.util.List;
import java.util.Set;


public class PartnerPage extends BasePage {

   private String emailUrl = "https://skarbmail.foxminded.ua/";
   private String registrationUrl = "https://skarb.foxminded.ua/registration/confirm";

    @FindBy(xpath= ("//a[@href='/registration']"))
    private WebElement link;

    @FindBy(xpath= ("//button[contains(@class, 'btn-success')]"))
    private WebElement buttonSuccess;

    @FindBy(xpath= ("//form//div[3]/button"))
    private WebElement buttonRegistration;

    @FindBy(xpath= ("//*[text()='Подтверждение регистрации']//ancestor::span"))
    private WebElement registrationField;

    @FindBy(xpath= ("//a[contains(@href, 'https://skarb.foxminded.ua/registration/confirm')]"))
    private WebElement registrationLink;

    @FindBy(xpath= ("//*[contains(text(), 'Ваш email подтверждено')]"))
    private WebElement confirmationMessage;
    public PartnerPage(WebDriver driver) {
        super(driver);
    }

    public void navigationPartnerPage() {
       link.click();
       buttonSuccess.click();
    }

    public void setRegistrationField() {
        SoftAssert softAssert = new SoftAssert();
        String passwordValue = RandomStringGenerator.generateStrongPassword();
        List<WebElement> inputFields = driver.findElements(By.xpath("//input"));
        if (inputFields.size() == 13) {
            inputFields.get(0).sendKeys(RandomStringGenerator.generateRandomEmail());
            inputFields.get(2).sendKeys(RandomStringGenerator.generateRandomString());
            inputFields.get(3).sendKeys(RandomStringGenerator.generateRandomString());
            inputFields.get(5).click();
            inputFields.get(6).sendKeys(passwordValue);
            inputFields.get(7).sendKeys(passwordValue);
            inputFields.get(8).sendKeys(RandomStringGenerator.generateRandomString());
            inputFields.get(11).sendKeys(RandomStringGenerator.generateRandomString());
        } else {
            softAssert.fail("Insufficient input fields found");
        }
        softAssert.assertAll();
        buttonRegistration.click();
    }

    public void confirmationRegistration() {
        driver.get(emailUrl);
        registrationField.click();
        registrationLink.click();
    }

    public String checkEmailConfirmationMessage() {
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            driver.switchTo().window(handle);
            if (driver.getCurrentUrl().equals(registrationUrl)) {
                return confirmationMessage.getText();
            }
        }
        return null;  // или бросить исключение, если окно с подтверждением не найдено
    }


}
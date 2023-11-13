package ua.foxminded.scarb.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.RandomDataGenerator;

public class VolunteerPageTestDataGenerator extends BaseTestNG {

    @Test
    public void checkVolunteerFormTest() {
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
}


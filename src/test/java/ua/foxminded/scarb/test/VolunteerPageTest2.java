package ua.foxminded.scarb.test;

import org.instancio.Instancio;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ua.foxminded.scarb.Volunteer;
import utils.RandomDataGenerator;
import static org.instancio.Select.field;


public class VolunteerPageTest2 extends BaseTest{


    @Test
    public void checkVolunteerFormTest2() {
        WebElement registrationLink = driver.findElement(By.cssSelector(".nav-link.ml-auto"));
        registrationLink.click();
        WebElement btn = driver.findElement(By.cssSelector("[name=volunteers] .btn "));
        btn.click();

        Volunteer volunteer = Instancio.of(Volunteer.class)
                .generate(field(Volunteer::getEmail), gen -> gen.text().pattern("#a#a#a#a#a#a@yahoo.com"))
                .generate(field(Volunteer::getPhoneNumber), gen -> gen.text().pattern(8 + "#d#d#d#d#d#d#d#d#d"))
                .set(field(Volunteer::getFirstName), RandomDataGenerator.generateRandomString())
                .set(field(Volunteer::getLastName), RandomDataGenerator.generateRandomString())
                .set(field(Volunteer::getPassword), RandomDataGenerator.generateStrongPassword())
                .create();

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys(volunteer.getEmail());

        WebElement phoneNumber = driver.findElement(By.id("phoneNumber"));
        phoneNumber.sendKeys(volunteer.getPhoneNumber());

        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys(volunteer.getFirstName());

        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys(volunteer.getLastName());

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(volunteer.getPassword());

        WebElement confirmPassword = driver.findElement(By.id("confirmPassword"));
        confirmPassword.sendKeys(volunteer.getPassword());

        WebElement btnSuccess = driver.findElement(By.className("btn-success"));
        btnSuccess.click();
    }

}



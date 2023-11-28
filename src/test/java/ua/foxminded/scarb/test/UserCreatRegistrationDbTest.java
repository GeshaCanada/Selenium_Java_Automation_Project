package ua.foxminded.scarb.test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import ua.foxminded.scarb.User;
import ua.foxminded.scarb.pages.LoginPage;
import ua.foxminded.scarb.pages.VolunteerPage;
import utils.RandomDataGenerator;
import utils.RandomStringGenerator;

import java.sql.SQLException;

public class UserCreatRegistrationDbTest extends BaseTestNG {

    private static final Logger LOGGER = LogManager.getLogger(UserCreatRegistrationDbTest.class.getName());
    private final String generatedUsername = RandomDataGenerator.generateRandomString();
    private final String generatedLastname = RandomDataGenerator.generateRandomString();
    private final String generatedEmail = RandomStringGenerator.generateRandomEmail();
    private final String generatedPassword = RandomDataGenerator.generateStrongPassword();

    @Test
    public void userLoginTest() throws SQLException {
        LOGGER.info("Start checking Test");

        User user = new User.Builder()
                .setUsername(generatedUsername)
                .setLastname(generatedLastname)
                .setEmail(generatedEmail)
                .setPassword(generatedPassword)
                .build();
        System.out.println("Generated Email: " + user.getEmail());

        new VolunteerPage(driver)
                .linkToVolunteerPage()
                .fillVolunteerForm(user)
                .assertSuccessButton()
                .confirmRegistrationDB(user.getEmail());

        new LoginPage(driver)
                .populateLoginForm(user)
                .verifyUserInfo(user);

        LOGGER.info("Finish checking Test");
    }
}
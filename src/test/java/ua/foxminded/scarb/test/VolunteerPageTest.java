package ua.foxminded.scarb.test;

import org.junit.jupiter.api.Test;
import ua.foxminded.scarb.pages.VolunteerPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VolunteerPageTest extends BaseTestJUnit {
    private static final Logger LOGGER = LogManager.getLogger(VolunteerPageTest.class.getName());

    @Test
    public void checkVolunteerFormTest() {
        LOGGER.info("Starting checkVolunteerFormTest");

        new VolunteerPage(driver)
                .linkToVolunteerPage()
                .logNavigation()
                .fillRegistrationForm()
                .logRegistrationForm()
                .assertRegistrationPage()
                .logSuccessButton()
                .assertSuccessButton()
                .logSuccessPage()
                .assertSuccessPage();

        LOGGER.info("checkVolunteerFormTest completed successfully");
    }
}

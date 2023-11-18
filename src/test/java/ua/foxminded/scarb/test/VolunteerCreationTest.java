package ua.foxminded.scarb.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ua.foxminded.scarb.pages.VolunteerPage;

import java.util.stream.Stream;

public class VolunteerCreationTest extends BaseTestJUnit {

    private static final Logger LOGGER = LogManager.getLogger(VolunteerCreationTest.class);

    @ParameterizedTest
    @MethodSource("volunteerData")
    public void createVolunteerTest(String name) {

        LOGGER.info("Creating volunteer: " + name);

        new VolunteerPage(driver)
                .linkToVolunteerPage()
                .fillRegistrationForm()
                .assertRegistrationPage()
                .assertSuccessButton()
                .assertSuccessPage();
    }

    private static Stream<Arguments> volunteerData() {
        return Stream.of(
                Arguments.of("Volunteer1"),
                Arguments.of("Volunteer2"),
                Arguments.of("Volunteer3")
        );
    }
}

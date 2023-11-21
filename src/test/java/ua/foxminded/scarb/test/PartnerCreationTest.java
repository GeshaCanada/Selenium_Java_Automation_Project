package ua.foxminded.scarb.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.foxminded.scarb.pages.PartnerPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PartnerCreationTest extends BaseTestJUnit {

    private static final Logger LOGGER = LogManager.getLogger(PartnerCreationTest.class);

    @ParameterizedTest
    @MethodSource("partnerData")
    public void createPartnerTest(String name) {

        LOGGER.info("Creating partner: " + name);

        new PartnerPage(driver)
                .linkToPartnerPage()
                .setRegistrationForm();
    }

    private static Stream<Arguments> partnerData() {
        return Stream.of(
                Arguments.of("Partner1"),
                Arguments.of("Partner2"),
                Arguments.of("Partner3"),
                Arguments.of("Partner4")
        );
    }
}



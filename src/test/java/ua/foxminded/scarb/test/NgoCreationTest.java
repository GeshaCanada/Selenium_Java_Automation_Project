package ua.foxminded.scarb.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.foxminded.scarb.pages.NgoPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class NgoCreationTest extends BaseTestJUnit {

    private static final Logger LOGGER = LogManager.getLogger(NgoCreationTest.class);

    @ParameterizedTest
    @MethodSource("NgoData")
    public void createNgoTest(String name) {

        LOGGER.info("Creating Ngo: " + name);

        new NgoPage(driver)
                .linkToNgoPage()
                .logNgoNavigation()
                .setRegistrationNgoForm()
                .logNgoRegistrationForm()
                .logNgoSuccessPage();

    }

    private static Stream<Arguments> NgoData() {
        return Stream.of(
                Arguments.of("Ngo1")
//                Arguments.of("Ngo2"),
//                Arguments.of("Ngo3"),
//                Arguments.of("Ngo4")
        );
    }
}
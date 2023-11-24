package ua.foxminded.scarb.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ua.foxminded.scarb.pages.LoginPage;
import ua.foxminded.scarb.pages.TaskPage;

import java.util.stream.Stream;

public class TaskCreationTestJUnit extends BaseTestJUnit {

    @BeforeEach
    public void login() {
        final Logger LOGGER = LogManager.getLogger(LoginPage.class.getName());
        LOGGER.info("Logging in");
        new LoginPage(driver).logIn();
        LOGGER.info("Login successful");
    }

    @ParameterizedTest
    @MethodSource("taskData")
    public void newTaskTest(String title, String description, String expected, String benefit, String money, String stage1, String stage2) {
        final Logger LOGGER = LogManager.getLogger(TaskPage.class.getName());
        LOGGER.info("Create" + title);
        new TaskPage(driver)
                .creationTask()
                .fillTaskForm(title, description, expected, benefit, money, stage1, stage2)
                .submitTask()
                .checkTasks();
        LOGGER.info("Finish create" + title);
    }

    private static Stream<Arguments> taskData() {
        return Stream.of(
                Arguments.of("Task 1 Website", "Developing web site using JS", "High quality product for music store", "Reference letter", "100", "5", "6"),
                Arguments.of("Task 2 Mobile banking app", "Developing web site using Angular", "High quality banking app", "Contract for 6 month", "200", "7", "8"),
                Arguments.of("Task 3 On-line casino", "Developing web site using React", "High quality on-line casino", "Full time job position", "300", "9", "10")
        );
    }


}

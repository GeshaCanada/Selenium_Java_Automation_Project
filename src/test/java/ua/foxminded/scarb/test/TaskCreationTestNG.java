package ua.foxminded.scarb.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ua.foxminded.scarb.pages.LoginPage;
import ua.foxminded.scarb.pages.TaskPage;

public class TaskCreationTestNG extends BaseTestNG {

    private final Logger LOGGER = LogManager.getLogger(TaskPage.class.getName());

    @BeforeTest
    public void login() {
        LOGGER.info("Logging in");
        new LoginPage(driver).logIn();
        LOGGER.info("Login successful");
    }

    @Test(dataProvider = "taskData")
    public void newTaskTest(String title, String description, String expected, String benefit, String money, String stage1, String stage2) {
        LOGGER.info("Create " + title);
        new TaskPage(driver)
                .creationTask()
                .fillTaskForm(title, description, expected, benefit, money, stage1, stage2)
                .submitTask()
                .checkTasks();
        LOGGER.info("Finish create " + title);
    }

    @DataProvider(name = "taskData")
    public Object[][] taskData() {
        return new Object[][]{
                {"Task 1 Website", "Developing web site using JS", "High quality product for music store", "Bonus 500USD", "150", "3", "5"},
                {"Task 2 Mobile banking app", "Developing web site using Angular", "High quality banking app", "Contract for 12 months", "270", "3", "4"},
                {"Task 3 On-line casino", "Developing web site using React", "High quality on-line casino", "Certificate", "330", "6", "7"}
        };
    }
}

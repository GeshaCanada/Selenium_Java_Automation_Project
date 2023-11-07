package ua.foxminded.scarb.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.foxminded.scarb.pages.TaskPage;


public class TaskPageTest extends BaseTest {

    private TaskPage pageFactory;

    @Test
    public void getButtonTextTest() {

        pageFactory = new TaskPage(driver);
        Assert.assertEquals(pageFactory.getButtonText(), "Смотреть задачи");
    }

    @Test
    public void taskButtonActionTest() {

        pageFactory = new TaskPage(driver);
        pageFactory.clickTaskButton();
        Assert.assertEquals(pageFactory.getTitleTaskText(), "Поиск задач");
    }

}

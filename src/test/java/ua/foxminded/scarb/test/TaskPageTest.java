package ua.foxminded.scarb.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.foxminded.scarb.pages.TaskPage;

public class TaskPageTest extends BaseTestNG {

    private TaskPage pageTask;

    @Test
    public void getButtonTextTest() {

        pageTask = new TaskPage(driver);
        Assert.assertEquals(pageTask.getButtonText(), "Смотреть задачи");
    }

    @Test
    public void taskButtonActionTest() {

        pageTask = new TaskPage(driver);
        pageTask.clickTaskButton();
        Assert.assertEquals(pageTask.getTitleTaskText(), "Поиск задач");
    }

}

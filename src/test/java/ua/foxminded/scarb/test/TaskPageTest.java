package ua.foxminded.scarb.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.foxminded.scarb.pages.TaskOptionPage;

public class TaskPageTest extends BaseTestNG {

    private TaskOptionPage pageTask;

    @Test
    public void getButtonTextTest() {

        pageTask = new TaskOptionPage(driver);
        Assert.assertEquals(pageTask.getButtonText(), "Смотреть задачи");
    }

    @Test
    public void taskButtonActionTest() {

        pageTask = new TaskOptionPage(driver);
        pageTask.clickTaskButton();
        Assert.assertEquals(pageTask.getTitleTaskText(), "Поиск задач");
    }

}

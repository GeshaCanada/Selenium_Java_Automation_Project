package ua.foxminded.scarb.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.List;

public class TaskTilesTest extends BaseTest {

    @Test
    public void printTasksAndCalculateTotalNumber() {
        List<WebElement> taskTiles = driver.findElements(By.name("task-card"));
        System.out.println("Print the tasks into console output:");
        for (WebElement task : taskTiles) {
            WebElement title = task.findElement(By.tagName("h5"));
            System.out.println("Title: " + title.getText());
            List<WebElement> fields = task.findElements(By.tagName("li"));
            for (WebElement field : fields) {
                System.out.println(field.getText());
            }
            System.out.println();
        }
        System.out.println("Calculate the overall number of tasks: " + taskTiles.size());
    }

}

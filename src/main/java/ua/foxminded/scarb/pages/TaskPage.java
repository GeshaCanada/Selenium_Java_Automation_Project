package ua.foxminded.scarb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TaskPage extends BasePage {

    @FindBy(id = ("tasksDropdown"))
    private WebElement dropDown;

    @FindBy(xpath = ("//a[@href='/tasks/register/volunteer']"))
    private WebElement taskLink;

    @FindBy(id = ("name"))
    private WebElement taskName;

    @FindBy(className = ("dropdown-toggle"))
    private WebElement choiceCategoryBtn;

    @FindBy(id = ("bs-select-1-5"))
    private WebElement categoryProgramming;

    @FindBy(id = ("description"))
    private WebElement taskDescription;

    @FindBy(id = ("expectedOutcome"))
    private WebElement taskExpected;

    @FindBy(id = ("benefit"))
    private WebElement taskBenefit;

    @FindBy(id = ("savedMoney"))
    private WebElement savedMoney;

    @FindBy(name = ("stages[0].duration"))
    private WebElement stage1Task;

    @FindBy(name = ("stages[1].duration"))
    private WebElement stage2Task;

    @FindBy(xpath = ("//button[contains(@value, 'PUBLISHED')]"))
    private WebElement buttonSuccess;

    @FindBy(id = ("deadline"))
    private WebElement deadLine;

    @FindBy(xpath = ("//*[@id='navbarNav']/a[1]/i"))
    private WebElement profile;

    @FindBy(xpath = ("//a[@href='#tasksSubmenu']"))
    private WebElement myTasks;

    public TaskPage(WebDriver driver) {
        super(driver);
    }

    public TaskPage creationTask() {
        dropDown.click();
        taskLink.click();
        return this;
    }

    public TaskPage fillTaskForm(String taskNameValue, String taskDescriptionValue, String expectedValue, String benefitValue, String savedMoneyValue, String stage1Value, String stage2Value) {
        taskName.sendKeys(taskNameValue);
        choiceCategoryBtn.click();
        categoryProgramming.click();

        LocalDate currentDate = LocalDate.now();
        LocalDate deadlineDate = currentDate.plusDays(5);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDeadline = deadlineDate.format(formatter);

        deadLine.sendKeys(formattedDeadline);
        taskDescription.sendKeys(taskDescriptionValue);
        taskExpected.sendKeys(expectedValue);
        taskBenefit.sendKeys(benefitValue);
        savedMoney.sendKeys(savedMoneyValue);
        stage1Task.sendKeys(stage1Value);
        stage2Task.sendKeys(stage2Value);

        return this;
    }

    public TaskPage submitTask() {
        buttonSuccess.click();
        return this;
    }

    public TaskPage checkTasks() {
        profile.click();
        myTasks.click();
        driver.get(publishedTasks);
        return this;
    }

}

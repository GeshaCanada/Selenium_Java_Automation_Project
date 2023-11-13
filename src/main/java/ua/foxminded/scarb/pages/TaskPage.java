package ua.foxminded.scarb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskPage extends BasePage {

    @FindBy(css = ("div.statistic button"))
    private WebElement button;

    @FindBy(css = ("h2"))
    private WebElement title;

    public TaskPage(WebDriver driver) {
        super(driver);
    }


    public String getButtonText() {
        return button.getText();
    }

    public void clickTaskButton() {
        button.click();
    }

    public String getTitleTaskText() {
        return title.getText();
    }

}

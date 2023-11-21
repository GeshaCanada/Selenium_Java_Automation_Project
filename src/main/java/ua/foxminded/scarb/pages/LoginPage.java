package ua.foxminded.scarb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class LoginPage extends BasePage {

    @FindBy(xpath = ("//a[@href='/login']"))
    private WebElement loginLink;

    @FindBy(id = ("login"))
    private WebElement login;

    @FindBy(id = ("password"))
    private WebElement password;

    @FindBy(className = ("btn-primary"))
    private WebElement button;

    @FindBy(id = ("tasksDropdown"))
    private WebElement dropDown;

    @FindBy(xpath = ("//a[@href='/tasks/register/volunteer']"))
    private WebElement taskLink;


    public LoginPage(WebDriver driver) {
        super(driver);
    }



    public LoginPage logIn() {
        loginLink.click();
        login.sendKeys("grostikov23@gmail.com");
        password.sendKeys("Gg23021981Gg!");
        button.click();
        return this;
    }

    public LoginPage creationTask() {
        dropDown.click();
        taskLink.click();
        return this;
    }

}

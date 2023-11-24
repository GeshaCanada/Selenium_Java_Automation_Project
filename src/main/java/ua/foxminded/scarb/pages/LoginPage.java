package ua.foxminded.scarb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.foxminded.scarb.User;

public class LoginPage extends BasePage {

    @FindBy(xpath = ("//a[@href='/login']"))
    private WebElement loginLink;

    @FindBy(id = ("login"))
    private WebElement login;


    @FindBy(id = ("password"))
    private WebElement password;

    @FindBy(className = ("btn-primary"))
    private WebElement button;


    @FindBy(xpath = ("//*[@id='navbarNav']/a[1]/i"))
    private WebElement profile;

    @FindBy(id = ("positionInOrganization"))
    private WebElement position;

    @FindBy(id = ("lastName"))
    private WebElement lastname;


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


    public LoginPage populateLoginForm(User user) {
        loginLink.click();
        login.sendKeys(user.getUsername());
        password.sendKeys(user.getPassword());
        button.click();
        return this;
    }

    public LoginPage verifyUserInfo(User user) {
        profile.click();
        String actualPosition = position.getText();
        String actualLastName = lastname.getText();
        actualPosition.equals(user.getPosition());
        actualLastName.equals(user.getLastname());
        return this;
    }

}

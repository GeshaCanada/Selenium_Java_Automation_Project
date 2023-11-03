package ua.foxminded.scarb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    @FindBy(css = "h4.text-dark-red")
    private WebElement title;

    @FindBy(partialLinkText = "Связаться с нами")
    private WebElement contactUs;

    @FindBy(css = "title.info_title.title--red")
    private WebElement page;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getTitle() {
        return title;
    }

    public WebElement getContactUs() {
        return contactUs;
    }

    public WebElement getPage() {
        return page;
    }
}

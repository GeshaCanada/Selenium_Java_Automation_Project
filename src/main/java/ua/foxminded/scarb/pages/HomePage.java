package ua.foxminded.scarb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = "h4.text-dark-red")
    private WebElement title;

    @FindBy(partialLinkText = "Связаться с нами")
    private WebElement contactUs;

    @FindBy(css = "title.info_title.title--red")
    private WebElement page;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getTitleText() {
        return title.getText();
    }

    public void clickContactUs() {
        contactUs.click();
    }

    public String getPageText() {
        return page.getText();
    }


}

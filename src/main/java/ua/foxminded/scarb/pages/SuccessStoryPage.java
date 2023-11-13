package ua.foxminded.scarb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.Keys;
public class SuccessStoryPage extends BasePage {

    @FindBy(partialLinkText = ("Истории успеха"))
    private WebElement title;

    @FindBy(css = ("input[id='storyNameSearchFilter']"))
    private WebElement searchInput;

    @FindBy(partialLinkText = ("Показать больше"))
    private WebElement link;

    @FindBy(css = "h4.text-dark-red")
    private WebElement homeLink;


    public SuccessStoryPage (WebDriver driver) {
        super(driver);
    }

    public boolean getTitle() {
        return title.isDisplayed();
    }

    public void clickPageTitle() {
        title.click();
    }

    public void setSearchQuery(String query) {
        searchInput.sendKeys(query);
        searchInput.sendKeys(Keys.RETURN);
    }

    public boolean showMoreLinkDisplayed() {
        return link.isDisplayed();
    }
    public boolean showMoreLinkEnabled() {
        return link.isEnabled();
    }

    public void showMoreLinkClick() {
        link.click();
    }

    public String getHomeLink() {
        return homeLink.getText();
    }

    public void homeLinkClick() {
        homeLink.click();
    }

}
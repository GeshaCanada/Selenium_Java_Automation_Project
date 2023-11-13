package ua.foxminded.scarb.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.foxminded.scarb.pages.SuccessStoryPage;

public class SuccessStoryPageTest extends BaseTestNG {

    private SuccessStoryPage pageSuccessStory;

    @Test
    public void checkSuccessStoryPageTextTest() {
        pageSuccessStory = new SuccessStoryPage(driver);
        Assert.assertTrue(pageSuccessStory.getTitle());
    }

    @Test
    public void checkNavigationToSuccessStoryPageTest() {
        pageSuccessStory = new SuccessStoryPage(driver);
        pageSuccessStory.clickPageTitle();
    }

    @Test
    public void checkSearchInputTest() {
        pageSuccessStory = new SuccessStoryPage(driver);
        pageSuccessStory.clickPageTitle();
        pageSuccessStory.setSearchQuery("Web");
    }

    @Test
    public void showMoreSuccessStoriesFunctionTest() {
        pageSuccessStory = new SuccessStoryPage(driver);
        pageSuccessStory.clickPageTitle();
        Assert.assertTrue(pageSuccessStory.showMoreLinkDisplayed(), "Ссылка 'Показать больше' не видима.");  // Проверяем, что ссылка видима и активна
        Assert.assertTrue(pageSuccessStory.showMoreLinkEnabled(), "Ссылка 'Показать больше' не активна.");
        pageSuccessStory.showMoreLinkClick();
    }

    @Test
    public void checkNavigateHomePageTest() {

        pageSuccessStory = new SuccessStoryPage(driver);
        pageSuccessStory.clickPageTitle();
        pageSuccessStory.getHomeLink();
        pageSuccessStory.homeLinkClick();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://skarb.foxminded.ua/";
        Assert.assertEquals(currentUrl, expectedUrl, "После нажатия 'SKARB NGO' не была открыта ожидаемая страница.");

    }

}

package ua.foxminded.scarb.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.foxminded.scarb.pages.SuccessStoryPage;

public class SuccessStoryPageTest extends BaseTest {

    private SuccessStoryPage pageFactory;

    @Test
    public void checkSuccessStoryPageTextTest() {
        pageFactory = new SuccessStoryPage(driver);
        Assert.assertTrue(pageFactory.getTitle());
    }

    @Test
    public void checkNavigationToSuccessStoryPageTest() {
        pageFactory = new SuccessStoryPage(driver);
        pageFactory.clickPageTitle();
    }

    @Test
    public void checkSearchInputTest() {
        pageFactory = new SuccessStoryPage(driver);
        pageFactory.clickPageTitle();
        pageFactory.getInput();
    }

    @Test
    public void showMoreSuccessStoriesFunctionTest() {
        pageFactory = new SuccessStoryPage(driver);
        pageFactory.clickPageTitle();
        Assert.assertTrue(pageFactory.showMoreLinkDisplayed(), "Ссылка 'Показать больше' не видима.");  // Проверяем, что ссылка видима и активна
        Assert.assertTrue(pageFactory.showMoreLinkEnabled(), "Ссылка 'Показать больше' не активна.");
        pageFactory.showMoreLinkClick();
    }

    @Test
    public void checkNavigateHomePageTest() {

        pageFactory = new SuccessStoryPage(driver);
        pageFactory.clickPageTitle();
        pageFactory.getHomeLink();
        pageFactory.homeLinkClick();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://skarb.foxminded.ua/";
        Assert.assertEquals(currentUrl, expectedUrl, "После нажатия 'SKARB NGO' не была открыта ожидаемая страница.");

    }

}

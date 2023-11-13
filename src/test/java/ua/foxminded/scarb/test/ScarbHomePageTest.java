package ua.foxminded.scarb.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.foxminded.scarb.pages.HomePage;

public class ScarbHomePageTest extends BaseTestNG  {
    private HomePage pageFactory;

    @Test
    public void getToHomePageTest() {
        pageFactory = new HomePage(driver);
        Assert.assertEquals(pageFactory.getTitleText(), "SKARB NGO");
    }

    @Test
    public void checkContactUsTest() {
        pageFactory = new HomePage(driver);
        pageFactory.clickContactUs();
        Assert.assertEquals(pageFactory.getPageText(), "Свяжитесь с нами");
    }
}

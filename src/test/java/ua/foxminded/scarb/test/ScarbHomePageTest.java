package ua.foxminded.scarb.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.foxminded.scarb.helpers.TestSetup;
import ua.foxminded.scarb.pages.HomePage;

public class ScarbHomePageTest extends TestSetup {
    private HomePage pageFactory;

    @Test
    public void getToHomePageTest() {
        pageFactory = new HomePage(driver);
        Assert.assertEquals(pageFactory.getTitle().getText(), "SKARB NGO");
    }

    @Test
    public void checkContactUsTest() {
        pageFactory = new HomePage(driver);
        pageFactory.getContactUs().click();
        Assert.assertEquals(pageFactory.getPage().getText(), "Свяжитесь с нами");
    }

}

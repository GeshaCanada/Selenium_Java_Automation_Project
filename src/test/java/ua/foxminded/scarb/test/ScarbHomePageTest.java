package ua.foxminded.scarb.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.foxminded.scarb.pages.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ScarbHomePageTest extends BaseTestNG {
    private static final Logger LOGGER = LogManager.getLogger(ScarbHomePageTest.class.getName());
    private HomePage pageHome;

    @Test
    public void getToHomePageTest() {
        LOGGER.info("Starting getToHomePageTest");

        pageHome = new HomePage(driver);
        String actualTitle = pageHome.getTitleText();
        String expectedTitle = "SKARB NGO";

        LOGGER.debug("Actual Title: " + actualTitle);
        LOGGER.debug("Expected Title: " + expectedTitle);

        Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch");

        LOGGER.info("getToHomePageTest completed successfully");
    }

    @Test
    public void checkContactUsTest() {
        LOGGER.info("Starting checkContactUsTest");

        pageHome = new HomePage(driver);
        pageHome.clickContactUs();
        String actualPageText = pageHome.getPageText();
        String expectedPageText = "Свяжитесь с нами";

        LOGGER.debug("Actual Page Text: " + actualPageText);
        LOGGER.debug("Expected Page Text: " + expectedPageText);

        Assert.assertEquals(actualPageText, expectedPageText, "Page text mismatch");

        LOGGER.info("checkContactUsTest completed successfully");
    }
}


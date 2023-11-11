package ua.foxminded.scarb.test;

import org.junit.jupiter.api.Test;
import ua.foxminded.scarb.pages.VolunteerPage;

public class VolunteerPageTest3 extends BaseTest2 {

    private VolunteerPage pageFactory;

    @Test
    public void checkVolunteerFormTest1() {
        pageFactory = new VolunteerPage(driver);
        pageFactory.registrationLinkClick();
        pageFactory.buttonClick();
        pageFactory.fillInputFields();
        pageFactory.assertRegistrationPage();
        pageFactory.assertSuccessButton();
        pageFactory.assertSuccessPage();
    }

}

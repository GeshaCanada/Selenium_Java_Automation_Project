package ua.foxminded.scarb.test;

import org.junit.jupiter.api.Test;
import ua.foxminded.scarb.pages.VolunteerPage;

public class VolunteerPageTest extends BaseTestJUnit {

    private VolunteerPage pageVolunteer;

    @Test
    public void checkVolunteerFormTest() {
        pageVolunteer = new VolunteerPage(driver);
        pageVolunteer.registrationLinkClick();
        pageVolunteer.buttonClick();
        pageVolunteer.fillRegistrationForm();
        pageVolunteer.assertRegistrationPage();
        pageVolunteer.assertSuccessButton();
        pageVolunteer.assertSuccessPage();
    }

}

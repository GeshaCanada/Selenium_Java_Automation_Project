package ua.foxminded.scarb.test;
import org.junit.jupiter.api.Test;
import ua.foxminded.scarb.pages.VolunteerPage;

public class VolunteerPageTest extends BaseTestJUnit {
    @Test
    public void checkVolunteerFormTest() {
        (new VolunteerPage(driver))
                .linkToVolunteerPage()
                .fillRegistrationForm()
                .assertRegistrationPage()
                .assertSuccessButton()
                .assertSuccessPage();
    }
}

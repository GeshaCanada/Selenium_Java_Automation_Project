package ua.foxminded.scarb.test;
import org.testng.annotations.Test;
import ua.foxminded.scarb.pages.PartnerPage;

public class PartnerPageRegistrationTest extends BaseTestNG {
    @Test
    public void checkPartnerFormAndRegistrationPartnerFormTest() {
        (new PartnerPage(driver))
                .linkToPartnerPage()
                .setRegistrationForm()
                .confirmRegistration()
                .checkEmailConfirmationMessage();
    }
}

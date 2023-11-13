package ua.foxminded.scarb.test;
import org.testng.annotations.*;
import ua.foxminded.scarb.pages.PartnerPage;

public class PartnerPageRegistrationTest extends BaseTestNG {
    private PartnerPage pagePartner;

    @Test
    public void checkPartnerFormAndRegistrationPartnerFormTest() {
        pagePartner = new PartnerPage(driver);
        pagePartner.navigationPartnerPage();
        pagePartner.setRegistrationField();
        pagePartner.confirmationRegistration();
        pagePartner.checkEmailConfirmationMessage();

    }
}

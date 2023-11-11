package ua.foxminded.scarb.test;
import org.testng.annotations.*;
import ua.foxminded.scarb.pages.PartnerPage;

public class PartnerPageRegistrationTest extends BaseTest {
    private PartnerPage pageFactory;

    @Test
    public void checkPartnerFormAndRegistrationPartnerFormTest() {
        pageFactory = new PartnerPage(driver);
        pageFactory.navigationPartnerPage();
        pageFactory.setRegistrationField();
        pageFactory.confirmationRegistration();
        pageFactory.checkEmailConfirmationMessage();

    }
}

package bokoff.il.tests;

import static io.qameta.allure.Allure.step;

import bokoff.il.data.RegistrationData;
import bokoff.il.pages.RegistrationFormPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StudentRegistrationForm extends TestBase {

  @Test
  @DisplayName("Successful fill form")
  void fillFormTest() {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    RegistrationData registrationData = new RegistrationData();

    step("Open main page", ()-> {
      registrationFormPage.openPage();
    });

    step("Fill form", ()-> {
      registrationFormPage.fillForm(registrationData)
                          .submit();
    });
    step("Verify data form", ()-> {
      registrationFormPage.checkTitle()
                         .checkFields(registrationData);
    });
  }
}

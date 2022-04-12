package bokoff.il.tests;

import bokoff.il.data.RegistrationData;
import bokoff.il.pages.RegistrationFormPage;
import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StudentRegistrationForm {

  @BeforeAll
  static void setUp() {
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.browserSize = "1920x1080";

  }

  @Test
  void fillFormTest() {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    RegistrationData registrationData = new RegistrationData();

    registrationFormPage.openPage()
                        .fillForm(registrationData)
                        .submit();

    registrationFormPage.checkTitle();

  }
}

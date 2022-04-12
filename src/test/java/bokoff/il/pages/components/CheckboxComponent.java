package bokoff.il.pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

import bokoff.il.pages.RegistrationFormPage;

public class CheckboxComponent {
  public CheckboxComponent setCheckbox(String value){
    $(byText(value)).click();
    return this;
  }
}

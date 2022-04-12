package bokoff.il.pages.components;

import static com.codeborne.selenide.Selectors.byText;

import com.codeborne.selenide.SelenideElement;

public class ListComponents {
  public ListComponents setValue(SelenideElement locator, String value) {
    locator.click();
    locator.$(byText(value)).click();
    return this;
  }

}

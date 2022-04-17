package bokoff.il.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.String.format;

import bokoff.il.data.RegistrationData;
import bokoff.il.pages.components.CalendarComponent;
import bokoff.il.pages.components.CheckboxComponent;
import bokoff.il.pages.components.ListComponents;
import com.codeborne.selenide.SelenideElement;

public class RegistrationFormPage {
  SelenideElement firstNameInput=$("#firstName");
  SelenideElement lastNameInput= $("#lastName");
  SelenideElement emailInput = $("#userEmail");
  SelenideElement userNumberInput = $("#userNumber");
  SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
  SelenideElement subjectsInput = $("#subjectsInput");
  SelenideElement pictureInput = $("#uploadPicture");
  SelenideElement currentAddressInput = $("#currentAddress");
  SelenideElement stateInput = $("#state");
  SelenideElement cityInput = $("#city");
  SelenideElement submitButton = $("#submit");
  SelenideElement title = $("#example-modal-sizes-title-lg");

  CalendarComponent calendar = new CalendarComponent();
  CheckboxComponent checkBox= new CheckboxComponent();
  ListComponents list=new ListComponents();

  public RegistrationFormPage openPage(){
    open("/automation-practice-form");
    return this;
  }

  public RegistrationFormPage fillForm(RegistrationData registrationData){
    setFirstName(registrationData.firstName);
    setLastName(registrationData.lastName);
    setEmail(registrationData.email);
    setGender(registrationData.gender);
    setPhoneNumber(registrationData.mobilePhone);
    setBirthDate(registrationData.day,registrationData.month,registrationData.year);
    setSubjects(registrationData.subjects);
    setHobby(registrationData.hobby);
    setPicture(registrationData.filePath);
    setCurrentAddress(registrationData.currentAddress);
    setState(registrationData.state);
    setCity(registrationData.city);
    return this;
  }

  private RegistrationFormPage setFirstName(String value){
    firstNameInput.setValue(value);
    return this;
  }

  private RegistrationFormPage setLastName(String value){
    lastNameInput.setValue(value);
    return this;
  }

  private RegistrationFormPage setEmail(String value){
    emailInput.setValue(value);
    return this;
  }

  private RegistrationFormPage setPhoneNumber(String value){
    userNumberInput.setValue(value);
    return this;
  }

  private RegistrationFormPage setBirthDate(String day, String month, String year){
    dateOfBirthInput.click();
    calendar.setDate(day, month, year);
    return this;
  }

  private RegistrationFormPage setSubjects(String value){
    subjectsInput.setValue(value).pressEnter();
    return this;
  }

  private RegistrationFormPage setPicture(String value){
    pictureInput.uploadFromClasspath(value);
    return this;
  }

  private RegistrationFormPage setCurrentAddress(String value){
    currentAddressInput.setValue(value);
    return this;
  }

  private RegistrationFormPage setGender(String value){
    checkBox.setCheckbox(value);
    return this;
  }

  private RegistrationFormPage setHobby(String value){
    checkBox.setCheckbox(value);
    return this;
  }

  private RegistrationFormPage setState(String value) {
    list.setValue(stateInput, value);
    return this;
  }

  private RegistrationFormPage setCity(String value) {
    list.setValue(cityInput, value);
    return this;
  }

  public RegistrationFormPage submit(){
    submitButton.click();
    return this;
  }

  public RegistrationFormPage checkTitle(){
    title.shouldHave(text("Thanks for submitting the form"));
    return this;
  }

  public RegistrationFormPage checkFields(RegistrationData registrationData){
    $(".table-responsive").shouldHave(
        text(format("%s %s", registrationData.firstName, registrationData.lastName)),
        text(registrationData.email),
        text(registrationData.mobilePhone),
        text(registrationData.gender),
        text(format("%s %s,%s", registrationData.day, registrationData.month, registrationData.year)),
        text(registrationData.subjects),
        text(registrationData.hobby),
        text(registrationData.fileName),
        text(registrationData.currentAddress),
        text(format("%s %s",registrationData.state, registrationData.city)));
    return this;
  }
}
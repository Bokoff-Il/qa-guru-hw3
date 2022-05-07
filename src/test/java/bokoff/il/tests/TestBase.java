package bokoff.il.tests;

import bokoff.il.config.CredentialsConfig;
import bokoff.il.helpers.Attach;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {
  @BeforeAll
  static void setUp(){

    CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

    String login = config.login();
    String password = config.password();
    String remote = System.getProperty("remote", "selenoid.autotests.cloud/wd/hub");

    Configuration.baseUrl = System.getProperty("baseUrl", "https://demoqa.com");
    Configuration.browser = System.getProperty("browser", "chrome");
    Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
    Configuration.remote = "https://"+login+":"+password+"@"+remote;

    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("enableVNC", true);
    capabilities.setCapability("enableVideo", true);
    Configuration.browserCapabilities = capabilities;
  }

  @AfterEach
  void addAttachments(){
    Attach.screenshotAs("Last screenshot");
    Attach.pageSource();
    Attach.browserConsoleLogs();
    Attach.addVideo();
  }
}

package config;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;

public class WebDriverConfig {

  private static final ProjectConfig config =
      ConfigFactory.create(ProjectConfig.class);

  public static void setup() {

    WebDriverManager.chromedriver().setup();

    Configuration.browser = config.browser();
    Configuration.baseUrl = config.baseUrl();
    Configuration.timeout = config.timeout();
    Configuration.browserSize = "1920x1080";
    Configuration.pageLoadStrategy = "eager";
  }
}
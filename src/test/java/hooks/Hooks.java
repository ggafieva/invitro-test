package hooks;

import config.WebDriverConfig;
import io.cucumber.java.Before;

public class Hooks {

  @Before
  public void setup() {
    WebDriverConfig.setup();
  }
}

package core;

import config.ProjectConfig;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;

public abstract class BaseApiClient {

  protected static final ProjectConfig config =
      ConfigFactory.create(ProjectConfig.class);

  static {
    RestAssured.baseURI = config.apiBaseUrl();
  }
}

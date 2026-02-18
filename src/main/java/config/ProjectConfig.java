package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:application.properties")
public interface ProjectConfig extends Config {

  @Key("base.url")
  String baseUrl();

  @Key("api.base.url")
  String apiBaseUrl();

  @Key("browser")
  String browser();

  @Key("timeout")
  long timeout();
}

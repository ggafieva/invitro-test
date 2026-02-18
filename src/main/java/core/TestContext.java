package core;

import java.util.HashMap;
import java.util.Map;

public class TestContext {

  private final Map<String, String> variables = new HashMap<>();

  public void setVariable(String varName, String value) {
    variables.put(varName, value);
  }

  public String getVariable(String varName) {
    return variables.get(varName);
  }
}

package steps;

import clients.CityApiClient;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

public class ApiStep {

  private final CityApiClient cityApi = new CityApiClient();

  @Когда("отправляем GET запрос с CODE {string}")
  public void sendRequest(String code) {
    cityApi.sendGetRequestWithCode(code);
  }

  @Тогда("код ответа равен {int}")
  public void checkStatusCode(int statusCode) {
    cityApi.shouldHaveStatusCode(statusCode);
  }

  @Тогда("body содержит {string}")
  public void checkResponseBody(String text) {
    cityApi.responseBodyShouldContain(text);
  }
}

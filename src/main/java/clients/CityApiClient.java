package clients;
import core.BaseApiClient;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CityApiClient extends BaseApiClient {

  private Response response;

  public void sendGetRequestWithCode(String code) {

    response = given()
        .baseUri("https://www.invitro.ru")
        .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/144.0.0.0 Safari/537.36")
        .header("Referer", "https://www.invitro.ru/moscow/")
        .queryParam("CODE", code)
        .when()
        .get("/local/ajax/current-city.php")
        .then()
        .extract()
        .response();
  }

  public void shouldHaveStatusCode(int expectedStatus) {
    response.then().statusCode(expectedStatus);
  }

  public void responseBodyShouldContain(String expectedText) {
    response.then().body(org.hamcrest.Matchers.containsString(expectedText));
  }
}

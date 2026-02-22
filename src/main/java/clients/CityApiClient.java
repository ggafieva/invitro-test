package clients;

import core.BaseApiClient;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;
import models.CityCookies;

import static clients.data.CityStorage.CITY_STORAGE;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

public class CityApiClient extends BaseApiClient {

  private Response response;

  public void sendGetRequestWithCode(String code) {

    String baseUri = "https://www.invitro.ru";

    CityCookies cityData = CITY_STORAGE.get(code);

    if (cityData == null) {
      throw new IllegalArgumentException("Неизвестный code города: " + code);
    }

    Map<String, String> cookies = new HashMap<>();
    cookies.put("INVITRO_CITY", cityData.city());
    cookies.put("INVITRO_REGION_CODE", code);
    cookies.put("INVITRO_CITY_LK_GUID", cityData.guid());

    response = given()
        .baseUri(baseUri)
        .cookies(cookies)
        .header("User-Agent", "Mozilla/5.0")
        .header("Accept", "application/json, text/plain, */*")
        .queryParam("CODE", code)
        .when()
        .get("/local/ajax/current-city.php")
        .then()
        .log().all()
        .extract()
        .response();
  }

  public void shouldHaveStatusCode(int expectedStatus) {
    response.then().statusCode(expectedStatus);
  }

  public void responseBodyShouldContain(String expectedText) {
    response.then().body(org.hamcrest.Matchers.containsString(expectedText));
  }

  public void checkBodyFields(Map<String, String> expectedData) {
    expectedData.forEach((key, expectedValue) -> {
      response.then()
          .body(key, is(expectedValue));
    });
  }
}
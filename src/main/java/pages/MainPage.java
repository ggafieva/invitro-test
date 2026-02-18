package pages;

import com.codeborne.selenide.SelenideElement;
import core.BasePage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MainPage extends BasePage {

  private final SelenideElement cityButton =
      $x("//span[contains(@class,'city')]");

  private final SelenideElement chooseAnother =
      $x("//a[@href='#selectBasketCity']");


  public void selectCity() {
    cityButton.click();
    if (chooseAnother.isDisplayed()) {
      chooseAnother.click();
    }
  }

  public void shouldSeeCity(String city) {
    cityButton.shouldHave(text(city));
  }

  public void shouldSeeCityInUrl(String code) {
    webdriver().shouldHave(urlContaining(code));
  }

  public void checkErrorMessage(String expectedMessage) {
    String actualMessage = $x("//div[contains(@class, 'UnauthResultsPage_error')]").getText()
        .replaceAll("\\s+", " ")
        .trim();

    assertThat(actualMessage, is(expectedMessage));
  }
}


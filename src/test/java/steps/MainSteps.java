package steps;

import static com.codeborne.selenide.Selenide.open;

import io.cucumber.java.ru.*;
import pages.MainPage;

public class MainSteps {

  private final MainPage page = new MainPage();

  @Дано("открыта главная страница")
  public void openMain() {
    open("/");
  }

  @Тогда("отображается выбранный город {string}")
  public void checkCity(String city) {
    page.shouldSeeCity(city);
  }

  @Тогда("в адресной строке отображается код города {string}")
  public void checkUrl(String code) {
    page.shouldSeeCityInUrl(code);
  }

  @Когда("открываем окно выбора города")
  public void selectCity() {
    page.selectCity();
  }

  @Тогда("видим сообщение об ошибке {string}")
  public void checkErrorMessage(String expectedMessage) {
    page.checkErrorMessage(expectedMessage);
  }
}

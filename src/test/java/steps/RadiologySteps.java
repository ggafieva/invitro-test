package steps;

import static com.codeborne.selenide.Selenide.open;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import pages.RadiologyPage;

public class RadiologySteps {

  private final RadiologyPage page = new RadiologyPage();

  @Дано("открыта страница Медицинские услуги города с кодом {string}")
  public void openRadiology(String city) {
    open("/" + city + "/radiology");
  }

  @И("прокликиваем все меню медицинских услуг и проверяем соответствие заголовка")
  public void clickAllMenu() {
    page.clickAllMenu(null);
  }

  @И("прокликиваем все меню медицинских услуг исключая {string} и проверяем соответствие заголовка")
  public void clickAllMenu(String string) {
    page.clickAllMenu(string);
  }

  @И("прокликиваем все меню медицинских услуг исключая {string} по xpath и проверяем соответствие заголовка")
  public void clickAllMenuExcludeXpath(String string) {
    page.clickAllMenuExcludeXpath(string);
  }

  @И("прокликиваем все меню медицинских услуг исключая {string} из коллекции и проверяем соответствие заголовка")
  public void clickAllMenuExcludeCollection(String string) {
    page.clickAllMenuExcludeCollection(string);
  }
}

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

  @И("прокликиваем все меню медицинских услуг исключая МРТ тела и проверяем соответствие заголовка")
  public void clickAllMenu() {
    page.clickAllMenu("МРТ тела");
  }

  @И("прокликиваем все меню медицинских услуг исключая МРТ тела по xpath и проверяем соответствие заголовка")
  public void clickAllMenuExcludeXpath() {
    page.clickAllMenuExcludeXpath();
  }

  @И("прокликиваем все меню медицинских услуг исключая МРТ тела из коллекции и проверяем соответствие заголовка")
  public void clickAllMenuExcludeCollection() {
    page.clickAllMenuExcludeCollection();
  }
}

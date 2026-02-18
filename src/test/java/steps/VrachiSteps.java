package steps;

import static com.codeborne.selenide.Selenide.open;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Тогда;
import pages.VrachiPage;

public class VrachiSteps {

  private final VrachiPage page = new VrachiPage();

  @Дано("открыта страница врачи города с кодом {string}")
  public void openVrachi(String city) {
    open("/" + city + "/vrachi");
  }

  @Тогда("во всех карточках врачей есть отметка Детский врач")
  public void checkAllDoctorsAreChildren() {
    page.shouldAllDoctorsBeChildrenDoc();
  }
}

package steps;

import static com.codeborne.selenide.Selenide.open;

import io.cucumber.java.ru.Дано;
import pages.AnalizesPage;

public class AnalizesSteps {

  private final AnalizesPage page = new AnalizesPage();

  @Дано("открыта страница Сдать анализы")
  public void openAnalizes() {
    open("/analizes/for-doctors/");
  }
}

package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.util.List;

public class RadiologyPage {

  private static final String MENU_XPATH = "//div[@class='side-bar side-bar--inner ']//a";

  public void clickAllMenu(String excludeText) {
    ElementsCollection menuItems = $$x(MENU_XPATH)
        .filter(visible);

    for (SelenideElement item : menuItems) {
      String text = item.getText().trim();
      if (text.equals(excludeText)) continue;

      item.click();

      $x("//div[@id='titlePage']/h1").shouldHave(visible)
          .shouldHave(text(text));
    }
  }

  public void clickAllMenuExcludeXpath() {
    ElementsCollection menuItems = $$x("//div[@class='side-bar side-bar--inner ']//a[not(text()='МРТ тела')]")
        .filter(visible);

    for (SelenideElement item : menuItems) {
      String text = item.getText().trim();
      item.click();
      $x("//div[@id='titlePage']/h1").shouldHave(visible)
          .shouldHave(text(text));
    }
  }

  public void clickAllMenuExcludeCollection() {
    ElementsCollection menuItems = $$x(MENU_XPATH).filter(visible);

    List<SelenideElement> filtered = menuItems.stream()
        .filter(e -> !e.getText().trim().equals("МРТ тела"))
        .toList();

    for (SelenideElement item : filtered) {
      String text = item.getText().trim();
      item.click();
      $x("//div[@id='titlePage']/h1").shouldHave(visible)
          .shouldHave(text(text));
    }
  }
}

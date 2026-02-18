package core;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.refresh;
import static com.codeborne.selenide.Selenide.sleep;

import com.codeborne.selenide.SelenideElement;
import java.util.List;

public class BasePage {

  public void clickElementByXpath(String xpath) {
    SelenideElement element = $x(xpath);
    element.scrollTo().click();
  }

  public void clickElementById(String id) {
    SelenideElement element = $("#" + id);
    element.shouldBe(visible)
        .scrollTo()
        .click();
  }

  public void fillFieldById(String id, String value) {
    SelenideElement field = $("#" + id);
    field.shouldBe(visible)
        .setValue(value);
  }

  public void fillFieldByXpath(String xpath, String value) {
    SelenideElement field = $x(xpath);
    field.shouldBe(visible)
        .setValue(value);
  }

  public void waitSeconds(int seconds) {
    sleep(seconds * 1000L);
  }

  public void shouldSeeFieldsByXpath(List<String> xpaths) {
    for (String xpath : xpaths) {
      $x(xpath).shouldBe(visible);
    }
  }

  public void shouldSeeFieldByXpath(String xpath) {
    $x(xpath).shouldBe(visible);
  }

  public void shouldNotSeeFieldsByXpath(List<String> xpaths) {
    for (String xpath : xpaths) {
      $x(xpath).shouldNotBe(visible);
    }
  }

  public void shouldNotSeeFieldByXpath(String xpath) {
    $x(xpath).shouldNotBe(visible);
  }

  public void refreshPageWithWait(int seconds) {
    refresh();
    sleep(seconds * 1000L);
  }

  public String getElementTextByXpath(String xpath) {
    String rawText = $x(xpath)
        .shouldBe(visible)
        .getText()
        .trim();
    return rawText.replaceAll("[^0-9]", "");
  }
}

package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.util.ArrayList;
import java.util.List;
import models.MenuLink;

public class RadiologyPage {

  public void clickAllMenu(String excludeText) {
    String secondXpath =
        "//div[contains(@class,'side-bar-second')]//li[contains(@class,'side-bar-second__items')]";
    int secondCount = $$x(secondXpath).size();
    for (int i = 0; i < secondCount; i++) {
      SelenideElement second = $$x(secondXpath).get(i);
      SelenideElement secondLink = second.$("a").shouldBe(visible);
      String secondText = secondLink.getText().trim();
      String secondUrl = secondLink.getAttribute("href");
      if (shouldSkip(secondText, excludeText)) {
        continue;
      }
      open(secondUrl);
      checkHeader(secondText);
      processThirdLevel(secondXpath, i, excludeText);
    }
  }

  private void processThirdLevel(String secondXpath, int secondIndex, String excludeText) {
    SelenideElement second =
        $$x(secondXpath).get(secondIndex);
    ElementsCollection thirdLinks =
        second.$$x(".//div[contains(@class,'side-bar-third')]//a")
            .filter(visible);
    int thirdCount = thirdLinks.size();
    for (int j = 0; j < thirdCount; j++) {
      second = $$x(secondXpath).get(secondIndex);
      thirdLinks = second
          .$$x(".//div[contains(@class,'side-bar-third')]//a")
          .filter(visible);
      SelenideElement third = thirdLinks.get(j);
      String thirdText = third.getText().trim();
      String thirdUrl = third.getAttribute("href");
      if (shouldSkip(thirdText, excludeText)) {
        continue;
      }
      open(thirdUrl);
      checkHeader(thirdText);
    }
  }

  private boolean shouldSkip(String text, String excludeText) {
    return excludeText != null && text.contains(excludeText);
  }

  private void checkHeader(String expectedText) {
    $x("//div[@id='titlePage']/h1")
        .shouldBe(visible)
        .shouldHave(text(expectedText));
  }

  public void clickAllMenuExcludeXpath(String excludeText) {
    String secondXpath =
        "//div[contains(@class,'side-bar-second')]//li[contains(@class,'side-bar-second__items')]" +
            (excludeText != null
                ? "[not(./a[contains(normalize-space(), '" + excludeText + "')])]"
                : "");
    int secondCount = $$x(secondXpath).size();
    for (int i = 0; i < secondCount; i++) {
      SelenideElement second = $$x(secondXpath).get(i);
      SelenideElement secondLink = second.$("a").shouldBe(visible);
      String secondText = secondLink.getText().trim();
      String secondUrl = secondLink.getAttribute("href");
      open(secondUrl);
      checkHeader(secondText);
      processThirdLevelExcludeXpath(secondXpath, i, excludeText);
    }
  }

  private void processThirdLevelExcludeXpath(String secondXpath,
      int secondIndex,
      String excludeText) {
    SelenideElement second =
        $$x(secondXpath).get(secondIndex);
    String thirdXpath =
        ".//div[contains(@class,'side-bar-third')]//a" +
            (excludeText != null
                ? "[not(contains(normalize-space(), '" + excludeText + "'))]"
                : "");
    ElementsCollection thirdLinks =
        second.$$x(thirdXpath).filter(visible);
    int thirdCount = thirdLinks.size();
    for (int j = 0; j < thirdCount; j++) {
      second = $$x(secondXpath).get(secondIndex);
      thirdLinks = second.$$x(thirdXpath).filter(visible);
      SelenideElement third = thirdLinks.get(j);
      String thirdText = third.getText().trim();
      String thirdUrl = third.getAttribute("href");
      open(thirdUrl);
      checkHeader(thirdText);
    }
  }

  public void clickAllMenuExcludeCollection(String excludeText) {
    List<MenuLink> thirdLinks = new ArrayList<>();
    List<String> secondUrls = $$x(
        "//li[contains(@class,'side-bar-second__items')]/a"
    ).attributes("href");
    for (String secondUrl : secondUrls) {
      open(secondUrl);
      for (SelenideElement third :
          $$x("//li[contains(@class,'side-bar-third__items')]/a")) {
        String text = third.getText().trim();
        if (!text.isBlank()) {
          thirdLinks.add(
              new MenuLink(text, third.getAttribute("href"))
          );
        }
      }
    }
    if (excludeText != null) {
      thirdLinks.removeIf(link ->
          link.getText().contains(excludeText));
    }
    for (MenuLink link : thirdLinks) {
      open(link.getUrl());
      checkHeader(link.getText());
    }
  }
}

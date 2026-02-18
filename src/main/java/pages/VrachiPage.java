package pages;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.BasePage;

public class VrachiPage extends BasePage {

  public void shouldAllDoctorsBeChildrenDoc() {

    ElementsCollection vrachiCards = $$x("//p[@class='vrach-card__job-main']");

    vrachiCards.shouldHave(sizeGreaterThan(0));

    for (SelenideElement card : vrachiCards) {
      card.$x(".//span[contains(text(),'Детский врач')]")
          .shouldBe(visible);
    }
  }
}

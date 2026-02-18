package steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import core.BasePage;
import core.TestContext;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import java.util.List;

public class BaseSteps {
  private final BasePage page = new BasePage();
  private final TestContext context = new TestContext();

  @И("кликаем на элемент с xpath {string}")
  public void clickByXpath(String xpath) {
    page.clickElementByXpath(xpath);
  }

  @И("кликаем на элемент с id {string}")
  public void clickById(String id) {
    page.clickElementById(id);
  }

  @И("поле с id {string} заполняем значением {string}")
  public void fillFieldById(String id, String value) {
    page.fillFieldById(id, value);
  }

  @И("поле с xpath {string} заполняем значением {string}")
  public void fillFieldByXpath(String xpath, String value) {
    page.fillFieldByXpath(xpath, value);
  }

  @И("ожидаем {int} сек")
  public void waitSeconds(int seconds) {
    page.waitSeconds(seconds);
  }

  @Тогда("отображаются поля")
  public void shouldSeeFieldsByXpaths(io.cucumber.datatable.DataTable table) {
    List<String> xpaths = table.asList();
    page.shouldSeeFieldsByXpath(xpaths);
  }

  @Тогда("отображается элемент с xpath {string}")
  public void shouldSeeFieldByXpath(String xpath) {
    page.shouldSeeFieldByXpath(xpath);
  }

  @Тогда("не отображаются поля")
  public void shouldNotSeeFieldByXpaths(io.cucumber.datatable.DataTable table) {
    List<String> xpaths = table.asList();
    page.shouldNotSeeFieldsByXpath(xpaths);
  }

  @Тогда("не отображается элемент с xpath {string}")
  public void shouldNotSeeFieldByXpath(String xpath) {
    page.shouldNotSeeFieldByXpath(xpath);
  }

  @И("обновляем страницу и ожидаем {int} секунд")
  public void refreshPageWithWait(int seconds) {
    page.refreshPageWithWait(seconds);
  }

  @И("записать в переменную {string} значение элемента с xpath {string}")
  public void saveElementValueToVariable(String variableName, String xpath) {
    String value = page.getElementTextByXpath(xpath);
    context.setVariable(variableName, value);
  }

  @Тогда("элемент с xpath {string} равен значению переменной {string}")
  public void elementEqualsVariable(String xpath, String variableName) {
    String expectedValue = context.getVariable(variableName);
    String value = page.getElementTextByXpath(xpath);
    assertThat(value, is(expectedValue));
  }
}

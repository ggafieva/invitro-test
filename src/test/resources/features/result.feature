# language: ru

Функция: Проверка формы Результаты анализов

  Сценарий: Проверка формы Результаты анализов
    Дано открыта главная страница
    И кликаем на элемент с xpath "//span[text()='Результаты анализов']"
    И ожидаем 2 сек
    И кликаем на элемент с xpath "//button[text()='Найти результаты']"
    И отображаются поля
      | //input[@name='orderNumber' and contains(@class, 'Input_error')] |
      | //input[@name='birthday' and contains(@class, 'Input_error')]    |
      | //input[@name='lastName' and contains(@class, 'Input_error')]    |
    Тогда видим сообщение об ошибке "Поля Код ИНЗДата рожденияФамилия обязательны для заполнения"
    И поле с xpath "//input[@name='orderNumber' and contains(@class, 'Input_error')]" заполняем значением "231231231"
    Тогда не отображается элемент с xpath "//input[@name='orderNumber' and contains(@class, 'Input_error')]"
    Тогда видим сообщение об ошибке "Поля Дата рожденияФамилия обязательны для заполнения"
    И поле с xpath "//input[@name='birthday' and contains(@class, 'Input_error')]" заполняем значением "11.12.2000"
    Тогда не отображается элемент с xpath "//input[@name='birthday' and contains(@class, 'Input_error')]"
    Тогда видим сообщение об ошибке "Поле Фамилия обязательно для заполнения"
    И поле с xpath "//input[@name='lastName' and contains(@class, 'Input_error')]" заполняем значением "тест"
    Тогда не отображается элемент с xpath "//input[@name='lastName' and contains(@class, 'Input_error')]"
    Тогда не отображается элемент с xpath "//div[contains(@class, 'UnauthResultsPage_error')]"
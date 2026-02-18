# language: ru

Функция: Cтраница Сдать анализы

  Сценарий: Сверка цены продукта на странице анализы с ценой в корзине
    Дано открыта страница Сдать анализы
    И записать в переменную "price" значение элемента с xpath "//div[@class='analyzes-item__total--sum']"
    И кликаем на элемент с xpath "//div[contains(@class,'analyzes-item__total')]//a[contains(@href,'/analizes/for-doctors/481/2212/')]"
    И кликаем на элемент с xpath "//div[contains(@class,'analyzes-item__total')]//a[contains(@href,'cart')]"
    И ожидаем 3 сек
    Тогда элемент с xpath "//div[text()='Продукты:']/following-sibling::div//span" равен значению переменной "price"
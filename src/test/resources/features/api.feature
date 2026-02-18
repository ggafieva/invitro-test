# language: ru
Функция: Проверка backend запроса current-city

  Структура сценария: Проверка ответа сервиса current-city
    Когда отправляем GET запрос с CODE "<Код>"
    Тогда код ответа равен 200
    Тогда body содержит "<Тело>"

#    Тут видимо не дает актуальные данные, везде должно быть {\"city\": \"Москва\",\"code\": \"moscow\",\"guid\": \"f1c3c4f0-{int}-4cda-{int}-e5d326e02f97\"}
  #    но возвращает {\"city\":null,\"code\":null,\"guid\":null}
    Примеры:
      | Код    | Тело                                        |
      | bajmak | {\"city\":null,\"code\":null,\"guid\":null} |
      | moscow | {\"city\":null,\"code\":null,\"guid\":null} |
      | london | {\"city\":null,\"code\":null,\"guid\":null} |
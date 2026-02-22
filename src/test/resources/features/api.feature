# language: ru
Функция: Проверка backend запроса current-city

  Структура сценария: Проверка ответа сервиса current-city
    Когда отправляем GET запрос с CODE "<code>"
    Тогда код ответа равен 200
    Тогда поля body содержат
      | city | <city> |
      | code | <code> |
      | guid | <guid> |

    Примеры:
      | code   | city   | guid                                 |
      | bajmak | Bajmak | 5ba940c9-911a-11ea-8456-00155d80e803 |
      | moscow | Moscow | f1c3c4f0-3426-4cda-8449-e5d326e02f97 |
      | london | null   | null                                 |
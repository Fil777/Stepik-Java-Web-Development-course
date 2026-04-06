# Техническое задание на улучшение логики обновления контакта

**Задача**: Реализовать валидацию данных при обновлении контакта с использованием DTO.

**Требования к UpdateContactDto**:

1. Создать класс `UpdateContactDto` со следующими полями:

```java
public class UpdateContactDto {
    // поля
}
```

**Валидация полей**:

- `id`: обязательное поле
- `firstName`:
    - обязательное поле
    - длина от 2 до 50 символов (_@Size_)
    - только буквы
- `lastName`:
    - обязательное поле
    - длина от 2 до 50 символов
    - только буквы
- `phone`:
    - обязательное поле
    - уникальный среди всех контактов (кроме текущего обновляемого)
    - формат: +7(XXX)XXX XX XX
- `email`:
    - обязательное поле
    - валидный email-адрес

**Обновление эндпоинта**:

```java

@PutMapping("/update")
public ResponseEntity<ServerResponse<Contact>> updateContact(
        @Valid @RequestBody UpdateContactDto updateContactDto) { ...}
```

**Логика обработки**:

1. Проверка существования контакта по ID
2. Проверка уникальности email (исключая текущий контакт)
3. Маппинг DTO в сущность Contact
4. Обновление данных контакта
5. Возврат обновленного контакта

**Обработка ошибок**:

- Если контакт не найден: HTTP 404 (Not Found)
- Если email уже существует: HTTP 409 (Conflict)
- Если данные не прошли валидацию: HTTP 409 (Conflict)

**Пример успешного ответа**:

```json
{
  "success": true,
  "data": {
    "id": 1,
    "firstName": "Иван",
    "lastName": "Иванов",
    "phone": "+7(999)999 99 99",
    "email": "ivan@example.com"
  },
  "errors": null
}
```

**Пример ответа с ошибкой**:

```json
{
  "statusCode": "CONFLICT",
  "result": null,
  "isSuccess": false,
  "errors": [
    "email: Контакт с таким email уже существует"
  ]
}
```

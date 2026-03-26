# Техническое задание на разработку парсера JSON'а

## Цель проекта

Разработать Java-приложение для парсинга JSON-файла с информацией о заказе и его товарах.

## Требования к проекту

### 1. Структура проекта

- Создать Maven-проект с названием "orderparser".
- Использовать Java

### 2. JSON выглядит так

```json
{
  "isSuccess": true,
  "statusCode": 200,
  "errorMessages": [],
  "result": {
    "orderHeaderId": 1,
    "customerName": "Илья Муромец",
    "customerEmail": "ilya.muromets@bogatyr.email",
    "appUserId": "30276287-aeb0-488c-ac43-4b80718f1cc7",
    "orderTotalAmount": 2385,
    "orderDateTime": "2024-09-25T10:48:04.556128Z",
    "status": "ready_to_ship",
    "totalCount": 3,
    "orderDetailItems": [
      {
        "orderDetailId": 1,
        "orderHeaderId": 1,
        "productId": 3,
        "product": {
          "id": 3,
          "name": "Потрясающий Деревянный Ремень",
          "description": "Этот потрясающий ремень, изготовленный из высококачественной древесины, станет стильным дополнением к вашему образу. Он прочный, долговечный и удобный в носке.",
          "specialTag": "Популярный",
          "category": "Аксессуары",
          "price": 153.5,
          "image": "https://s3.timeweb.cloud/3acf5705-ea38ea8637814151fb6185113c727eb4f/img2.png"
        },
        "quantity": 10,
        "itemName": "Потрясающий Деревянный Ремень",
        "price": 1535
      },
      {
        "orderDetailId": 2,
        "orderHeaderId": 1,
        "productId": 4,
        "product": {
          "id": 4,
          "name": "Модная Железная Чашка",
          "description": "Эта модная чашка, изготовленная из прочного железа, идеально подходит для горячих и холодных напитков. Она имеет стильный дизайн и удобна в использовании.",
          "specialTag": "Эксклюзив",
          "category": "Посуда",
          "price": 50,
          "image": "https://s3.timeweb.cloud/3acf5705-ea38ea8637814151fb6185113c727eb4f/img4.png"
        },
        "quantity": 5,
        "itemName": "Модная Железная Чашка",
        "price": 250
      },
      {
        "orderDetailId": 3,
        "orderHeaderId": 1,
        "productId": 5,
        "product": {
          "id": 5,
          "name": "Элегантная Стеклянная Ваза",
          "description": "Эта элегантная ваза, изготовленная из высококачественного стекла, станет прекрасным украшением для вашего дома. Она идеально подходит для цветочных композиций и придаст изысканности любому интерьеру.",
          "specialTag": "Со скидкой",
          "category": "Декор",
          "price": 200,
          "image": "https://s3.timeweb.cloud/3acf5705-ea38ea8637814151fb6185113c727eb4f/img5.png"
        },
        "quantity": 3,
        "itemName": "Элегантная Стеклянная Ваза",
        "price": 600
      }
    ]
  }
}
```

### 3. Зависимости

Включить следующие зависимости в pom.xml:

```xml

<dependencies>
    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
        <version>2.18.1</version>
    </dependency>
    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-core</artifactId>
        <version>2.18.1</version>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.34</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

### 4. Модели данных, которые могут быть использованы

Создать следующие классы для представления структуры JSON:

- `Root`
- `Result`
- `OrderDetailItem`
- `Product`

Использовать аннотации Lombok для автоматической генерации геттеров, сеттеров и конструкторов.

### 5. Парсинг JSON

- Реализовать метод для чтения JSON-файла и его десериализации в объекты Java.
- Использовать `ObjectMapper` из библиотеки Jackson для парсинга.

### 6. Функциональность

Приложение должно:

- Читать JSON-файл из указанного пути.
- Парсить JSON в объекты Java.
- Выводить в консоль основную информацию о заказе:
    - Номер заказа
    - Имя и email клиента
    - Общая сумма заказа
    - Дата и время заказа
    - Статус заказа
- Выводить список товаров в заказе с их характеристиками.

### 7. Обработка ошибок

- Реализовать обработку возможных исключений при чтении файла и парсинге JSON.
- Выводить понятные сообщения об ошибках в случае их возникновения.

## Ожидаемый результат

Приложение, способное читать предоставленный JSON-файл, парсить его содержимое и выводить структурированную информацию о
заказе и товарах в консоль.

## Дополнительные требования

- Код должен соответствовать стандартам оформления Java-кода.
- Использовать принципы ООП и чистого кода.
- Обеспечить расширяемость приложения для возможности добавления новых функций в будущем.

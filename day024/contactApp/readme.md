# Техническое задание для реализации функционала управления владельцами контактов:

## Задание 1: Создание моделей

1. Создать enum `AppRole`:

```java
public enum AppRole {
    USER, ADMIN
}
```

и модель владельца контакта:

```java

@Getter
@Setter
public class ContactOwner {

    private String id;
    private String username;
    private String description;
    private String email;
    private String password;
    private AppRole role;

    private List<Contact> contacts = new ArrayList<>();

    public ContactOwner() {
        this.id = UUID.randomUUID().toString();
    }

    public ContactOwner(String username, String description) {
        this();
        this.username = username;
        this.description = description;
    }

}
```

2. Создать DTO модели: `CreateContactOwnerDto`, `UpdateContactOwnerDto`

## Задание 2: Реализация контроллера

1. Добавить зависимость для использования библиотеки Faker.

2. Реализовать методы контроллера:

- Инициализация тестовых данных через Faker
- CRUD операции с использованием ServerResponse в качестве модели ответа
- Добавьте эндпоинт поиска владельца по имени
- Добавьте эндпоинт поиска по ключевому слову внутри любого поля кроме id
- Добавьте валидацию входных данных
- Добавьте обработку ошибок

## Требования к реализации:

1. **Валидация**:

- Все входные данные должны проходить валидацию
- Использовать аннотации валидации из Jakarta Validation
- Добавить кастомные сообщения об ошибках

2. **Безопасность**:

- Пароли не должны возвращаться в ответах
- ID должны быть уникальными
- Email должен быть уникальным

3. **Обработка ошибок**:

- Возвращать соответствующие HTTP статусы
- Предоставлять понятные сообщения об ошибках

4. **Поиск**:

- Реализовать поиск по точному совпадению имени
- Реализовать поиск по ключевым словам во всех текстовых полях
- Поиск должен быть регистронезависимым

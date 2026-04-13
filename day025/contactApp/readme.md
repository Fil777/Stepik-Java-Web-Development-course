# Техническое задание на обновление сервиса ContactOwner

## Цель проекта
Реструктуризация текущего контроллера ContactOwnerController с применением многослойной архитектуры, разделением ответственности между компонентами и улучшением качества кода.

## Требования к компонентам

### 1. ContactOwnerRepository
- Интерфейс для абстракции доступа к данным
- Методы для базовых операций CRUD
- Методы поиска с различными критериями
- Использование Optional для nullable результатов
- Возвращение копий коллекций для предотвращения прямого изменения данных

```java
public interface ContactOwnerRepository {
    List<ContactOwner> findAll();
    Optional<ContactOwner> findById(String id);
    Optional<ContactOwner> findByEmail(String email);
    ContactOwner save(ContactOwner contactOwner);
    boolean deleteById(String id);
    List<ContactOwner> findByUsername(String username);
    List<ContactOwner> searchByKeyword(String keyword);
}
```

### 2. ContactOwnerRepositoryImpl
- Реализация интерфейса ContactOwnerRepository
- Хранение данных в памяти (ArrayList)
- Инициализация тестовыми данными при создании
- Использование Stream API для операций фильтрации и поиска
- Генерация уникальных идентификаторов с помощью UUID

### 3. ContactOwnerService
- Интерфейс для бизнес-логики
- Методы высокоуровневых операций с ContactOwner
- Валидация входных данных
- Обработка бизнес-правил
- Преобразование DTO в сущности

```java
public interface ContactOwnerService {
    List<ContactOwner> getAllContactOwners();
    ContactOwner getContactOwnerById(String id);
    ContactOwner createContactOwner(CreateContactOwnerDto createDto);
    ContactOwner updateContactOwner(UpdateContactOwnerDto updateDto);
    boolean deleteContactOwner(String id);
    List<ContactOwner> searchContactOwnersByUsername(String username);
    List<ContactOwner> searchContactOwnersByKeyword(String keyword);
}
```

### 4. ContactOwnerServiceImpl
- Реализация интерфейса ContactOwnerService
- Внедрение зависимостей через конструктор
- Использование ModelMapper для преобразования DTO
- Выброс специализированных исключений
- Проверка уникальности email
- Бизнес-логика создания, обновления и удаления сущностей

### 5. ContactOwnerController
- RESTful эндпоинты для работы с ContactOwner
- Валидация входящих данных
- Делегирование логики сервису
- Использование ServerResponseHelper
- Обработка HTTP-запросов
- Возврат корректных HTTP-статусов

## Дополнительные требования
- Применить принципы SOLID
- Использовать ModelMapper для преобразования DTO
- Обработка ошибок через GlobalExceptionHandler
- Кастомные исключения (EntityNotFoundException, ValidationException)

## Функциональные возможности
- Получение списка всех владельцев контактов
- Получение владельца по ID
- Создание нового владельца
- Обновление существующего владельца
- Удаление владельца
- Поиск по имени пользователя
- Поиск по ключевому слову

## Ограничения
- Email должен быть уникальным
- Невозможно создать владельца с существующим email
- Обязательная валидация входных данных
- Генерация ID только через UUID


# Техническое задание на адаптацию существующего интерфейса `ContactOwnerRepository` с JPA-реализацией.

Создать адаптер для интеграции `ContactOwnerRepository` с новой JPA-реализацией.

**Исходные данные:**

- Интерфейс `ContactOwnerRepository` с базовыми CRUD-операциями
- Новая реализация `JpaContactOwnerRepository extends JpaRepository<ContactOwner, String>`

**Требования:**

1. Создать класс `JpaContactOwnerRepositoryAdapter`, реализующий интерфейс `ContactOwnerRepository`
2. Обеспечить делегирование всех операций к `JpaContactOwnerRepository`
3. Пометить адаптер аннотациями `@Repository` и `@Primary`
4. Сохранить существующую бизнес-логику в `ContactOwnerServiceImpl` без изменений

**Ожидаемый результат:**

- Бесшовная интеграция JPA-репозитория в существующую архитектуру
- Сохранение текущего контракта взаимодействия через `ContactOwnerRepository`
- Отсутствие необходимости изменения кода сервисного слоя
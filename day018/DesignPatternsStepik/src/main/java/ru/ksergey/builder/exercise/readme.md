## Задание: "Билдер для Системы Управления Студентами"

### Задание: Создание Builder для класса Student

**Цель работы**: Спроектировать и реализовать паттерн Builder для класса `Student` с расширенной функциональностью.

### Требования к классу Student

**Поля класса**:

- `id` (Long) - уникальный идентификатор студента
- `firstName` (String) - имя
- `lastName` (String) - фамилия
- `middleName` (String) - отчество
- `age` (Integer) - возраст
- `faculty` (String) - факультет
- `course` (Integer) - курс
- `averageGrade` (Double) - средний балл
- `isGrantHolder` (Boolean) - получает ли стипендию
- `phoneNumber` (String) - номер телефона

### Задачи для выполнения

1. **Реализация Builder**:
    - Создайте класс `StudentBuilder` с методами для установки каждого поля
    - Реализуйте fluent-интерфейс с возвратом `this` для каждого метода
    - Добавьте метод `build()` для создания объекта `Student`

2. **Валидация данных**:
    - Реализуйте метод `validate()` с проверками:
        - Возраст от 16 до 35 лет
        - Курс от 1 до 6
        - Средний балл от 2.0 до 5.0
        - Обязательное наличие имени и фамилии

3. **Дополнительные методы**:
    - Статический метод `createDefaultStudent()` для создания студента по умолчанию
    - Переопределение метода `toString()` в классе `Student`

### Пример кода для вдохновения

```java
public class Main {
    public static void main(String[] args) {
        // Создание студента с полной информацией
        Student student1 = StudentBuilder.create()
                .id(1L)
                .firstName("Иван")
                .lastName("Петров")
                .age(20)
                .faculty("Информатика")
                .course(3)
                .averageGrade(4.5)
                .isGrantHolder(true)
                .validate()
                .build();

        // Создание студента с частичной информацией
        Student student2 = StudentBuilder.create()
                .firstName("Анна")
                .lastName("Смирнова")
                .faculty("Экономика")
                .build();

        // Использование метода по умолчанию
        Student defaultStudent = StudentBuilder.createDefaultStudent();
    }
}
```

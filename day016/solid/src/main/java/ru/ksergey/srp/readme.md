# Single responsibility principle

это один из пяти принципов SOLID, предложенных Робертом Мартином. Он гласит, что класс должен иметь только одну причину для изменения. Суть заключается в том, что каждый класс должен выполнять только одну конкретную ответственность, и изменения в этой ответственности должны приводить к изменению только этого класса.

### Пример

Плохой пример

```java
public class Employee {
    private String name;
    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void saveToDatabase() {
        // Сохранение сотрудника в базу данных
    }

    public void calculateTax() {
        // Расчет налогов
    }
}
```
Хороший пример

```JAVA
public class Employee {
    private String name;
    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

public class EmployeeDatabase {
    public void saveToDatabase(Employee employee) {
        // Сохранение сотрудника в базу данных
    }
}

public class TaxCalculator {
    public void calculateTax(Employee employee) {
        // Расчет налогов
    }
}
```
В плохо соблюденном `SRP` примере класс `Employee` имеет две ответственности: сохранение в базу данных и расчет налогов. В хорошо соблюденном `SRP` примере каждый класс выполняет только одну конкретную задачу: `Employee` отвечает только за информацию о сотруднике, `EmployeeDatabase` занимается сохранением сотрудника в базе данных, а `TaxCalculator` - расчетом налогов. Это делает код более поддерживаемым и позволяет изменять каждую часть независимо от других.


## Техническое задание: Сервис работы с изображениями

### Описание:
Необходимо разработать сервис для работы с изображениями, который будет предоставлять следующие возможности:
- Создание объекта изображения с указанием ширины и высоты
- Отправка изображения на email
- Загрузка изображения на SFTP сервер
- Получение размеров изображения
- Загрузка изображения из URL
- Сохранение изображения в файл

### Требования:
1. Сервис должен иметь абстрактный класс `Attach`, представляющий вложение.
2. Класс `Image` должен наследоваться от класса `Attach`
3. `Image` должен содержать поля `width` и `height` для хранения размеров изображения и соответствующие геттеры.

### Дополнительные требования:
- Код должен быть читабельным, хорошо структурированным и содержать комментарии для ключевых моментов.

### Примечания:
- Реализация методов может быть упрощена или заменена заглушками на начальном этапе разработки.
- Пример использования сервиса можно добавить в метод `main` класса `Program`.

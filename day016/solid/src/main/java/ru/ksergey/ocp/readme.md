# Open-closed principle

Принцип открытости / закрытости (Open-Closed Principle, OCP) - это один из принципов SOLID, который гласит, что классы должны быть открыты для расширения, но закрыты для модификации. Это означает, что изменения в поведении класса должны быть достигнуты через добавление нового кода, а не путем изменения существующего кода.

### Пример

Плохой пример

```java
public class Circle {
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }
}

public class Rectangle {
    private double width;
    private double height;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double area() {
        return width * height;
    }
}
```
Хороший пример

```JAVA
public interface Shape {
    double area();
}

public class Circle implements Shape {
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

public class Rectangle implements Shape {
    private double width;
    private double height;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}
```
В плохо соблюденном `OCP` примере, чтобы добавить новую фигуру (например, треугольник), нам пришлось бы изменять существующий код, что нарушает принцип. В хорошо соблюденном `OCP` примере мы создали интерфейс `Shape`, который позволяет добавлять новые фигуры, не изменяя существующий код. Это делает код более гибким и поддерживаемым.

## Техническое задание: Сервис для сохранения изображений

### Описание:
Разработать сервис для создания, управления и сохранения изображений в различных форматах. Сервис должен предоставлять возможность создания изображений, получения их размеров и сохранения в форматах BMP, JPG и PNG.

### Требования:

1. **Структура классов:**
   - Абстрактный класс `Attach` как базовый для вложений.
   - Класс `Image`, наследующий от `Attach`, для представления изображений.
   - Класс `ImageSize` для хранения размеров изображения.
   - Класс `ImageExtensions` для методов сохранения изображений.

2. **Функциональность `Image`:**
   - Создание изображения с заданными шириной и высотой.
   - Получение размера изображения (ширина и высота).
   - Защита от прямого изменения размера изображения извне.

3. **Функциональность `ImageExtensions`:**
   - Методы для сохранения изображений в форматах BMP, JPG и PNG.

4. **Основная программа:**
   - Демонстрация создания изображения и его сохранения в разных форматах.

### Дополнительные требования:

   - Использовать принцип инкапсуляции для защиты данных изображения.

### Примечания:

- Реализация методов сохранения в различных форматах должна быть добавлена позже.
- Сервис должен быть расширяемым для добавления новых форматов изображений и функциональности.
- Код должен соответствовать принципам SOLID, особенно принципу открытости/закрытости (OCP).

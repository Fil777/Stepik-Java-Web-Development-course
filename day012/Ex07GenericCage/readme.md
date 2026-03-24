### Обобщения 

Обобщения в Java позволяют создавать классы, интерфейсы и методы, которые могут работать с различными типами данных, сохраняя при этом безопасность типов. 

Основные концепции обобщений:

1. Обобщенные классы

Обобщенный класс объявляется с одним или несколькими параметрами типа.

Пример:

```java
public class Box<T> {
    private T content;

    public void put(T item) {
        this.content = item;
    }

    public T get() {
        return content;
    }
}
```

В этом примере `T` - это параметр типа. Мы можем использовать этот класс для хранения объектов любого типа:

```java
Box<Integer> intBox = new Box<>();
intBox.put(10);
Integer value = intBox.get(); // Не требуется явное приведение типов

Box<String> stringBox = new Box<>();
stringBox.put("Hello");
String text = stringBox.get();
```

2. Ограничения типов

Мы можем ограничить типы, которые могут использоваться в качестве параметра типа.

Пример:

```java
public class NumberBox<T extends Number> {
    private T number;

    public void set(T number) {
        this.number = number;
    }

    public double getDoubleValue() {
        return number.doubleValue();
    }
}
```

Теперь `NumberBox` может использоваться только с типами, которые являются подклассами `Number`:

```java
NumberBox<Integer> intBox = new NumberBox<>();
NumberBox<Double> doubleBox = new NumberBox<>();
// NumberBox<String> stringBox = new NumberBox<>(); // Ошибка компиляции
```

3. Обобщенные методы

Методы также могут быть обобщенными, независимо от того, находятся ли они в обобщенном классе или нет.

Пример:

```java
public class Util {
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
```

Использование:

```java
Integer[] intArray = {1, 2, 3, 4, 5};
String[] stringArray = {"Hello", "World"};

Util.printArray(intArray);
Util.printArray(stringArray);
```

4. Wildcards

Wildcards позволяют создавать более гибкие обобщенные типы.

Пример:

```java
public class AnimalShelter {
    public static void feedAnimals(List<? extends Animal> animals) {
        for (Animal animal : animals) {
            animal.feed();
        }
    }
}
```

Этот метод может принимать список любых подтипов `Animal`:

```java
List<Dog> dogs = new ArrayList<>();
List<Cat> cats = new ArrayList<>();

AnimalShelter.feedAnimals(dogs);
AnimalShelter.feedAnimals(cats);
```
 
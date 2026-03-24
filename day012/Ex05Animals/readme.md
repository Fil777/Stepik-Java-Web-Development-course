# Полиморфизм

Полиморфизм - это один из ключевых принципов объектно-ориентированного программирования, который позволяет экземплярам разных классов, связанных наследованием, реагировать по-разному на один и тот же вызов метода.

### Полиморфная переменная 

Это переменная, которая может ссылаться на экземпляры разных экземпляров классов, связанных наследованием или реализацией интерфейса. Тип полиморфной переменной является либо интерфейсом, либо суперклассом иерархии, на которые она может ссылаться.

Пример полиморфной переменной:

```java
class Animal {
    public void makeSound() {
        System.out.println("Животное издает звук");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Мяу");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Гав");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Cat();
        Animal animal2 = new Dog();
        
        animal1.makeSound(); // Вывод: "Мяу"
        animal2.makeSound(); // Вывод: "Гав"
    }
}
```

В этом примере `animal1` и `animal2` являются полиморфными переменными типа `Animal`. Они могут ссылаться на экземпляры классов `Cat` и `Dog`, которые являются подклассами `Animal`.

Когда вызывается метод `makeSound()` на полиморфных переменных, Java определяет фактический тип экземпляра класса во время выполнения (в данном случае `Cat` или `Dog`) и вызывает соответствующую реализацию метода.

Полиморфные переменные позволяют писать более обобщенный и гибкий код. Например, можно создать массив типа `Animal` и хранить в нем экземпляры разных подклассов:

```java
Animal[] animals = new Animal[3];
animals[0] = new Cat();
animals[1] = new Dog();
animals[2] = new Cat();

for (Animal animal : animals) {
    animal.makeSound();
}
```

Этот код будет работать корректно, вызывая соответствующий метод `makeSound()` для каждого экземпляра в массиве, независимо от его фактического типа (`Cat` или `Dog`).

---

## Виды полиморфизма

В ООП в целом и Java в частности выделяют несколько видов полиморфизма:

1. Полиморфизм времени выполнения (динамический полиморфизм):

Это способность экземпляров класса с одинаковым интерфейсом иметь различные реализации методов. Достигается через переопределение методов.

Пример:

```java
class Animal {
    void makeSound() {
        System.out.println("Животное издает звук");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Собака лает");
    }
}

class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Кошка мяукает");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Dog();
        Animal animal2 = new Cat();
        
        animal1.makeSound(); // Выведет: "Собака лает"
        animal2.makeSound(); // Выведет: "Кошка мяукает"
    }
}
```

2. Полиморфизм времени компиляции (статический полиморфизм):

Это способность использовать один и тот же идентификатор для методов с разными параметрами. Достигается через перегрузку методов.

Пример:

```java
class Calculator {
    int add(int a, int b) {
        return a + b;
    }
    
    double add(double a, double b) {
        return a + b;
    }
    
    int add(int a, int b, int c) {
        return a + b + c;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.add(5, 3));       // Вызовет первый метод
        System.out.println(calc.add(5.5, 3.2));   // Вызовет второй метод
        System.out.println(calc.add(5, 3, 2));    // Вызовет третий метод
    }
}
```

3. Полиморфизм подтипов:

Это возможность использовать экземпляра класса-потомка везде, где ожидается экземпляр класса-родителя.

Пример:

```java
interface Shape {
    double getArea();
}

class Rectangle implements Shape {
    private double width, height;
    
    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double getArea() {
        return width * height;
    }
}

class Circle implements Shape {
    private double radius;
    
    Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

public class Main {
    static void printArea(Shape shape) {
        System.out.println("Площадь: " + shape.getArea());
    }
    
    public static void main(String[] args) {
        Shape shape1 = new Rectangle(5, 3);
        Shape shape2 = new Circle(2);
        
        printArea(shape1); // Работает с прямоугольником
        printArea(shape2); // Работает с кругом
    }
}
```

4. Параметрический полиморфизм (обобщения):

Это возможность написать код, который может работать с разными типами данных.

Пример:

```java
class Box<T> {
    private T content;
    
    public void put(T item) {
        this.content = item;
    }
    
    public T get() {
        return content;
    }
}

public class Main {
    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>();
        intBox.put(10);
        System.out.println(intBox.get());
        
        Box<String> stringBox = new Box<>();
        stringBox.put("Hello");
        System.out.println(stringBox.get());
    }
}
```

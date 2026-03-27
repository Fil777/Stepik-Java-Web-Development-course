package org.example;

import java.lang.reflect.Field;

public class ReflectionExample {
    public static void main(String[] args) throws Exception {
        // Создаем объект класса Person с id=123 и fullName="Имя Фамилия"
        Person person = new Person(123, "Имя Фамилия");

        // Выводим объект person на консоль
        System.out.println(person);

        // Получаем объект класса Class для класса Person
        Class<? extends Person> personClass = person.getClass();

        // Получаем массив всех объявленных полей класса Person
        Field[] fields = personClass.getDeclaredFields();

        // Выводим имена всех полей класса Person
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        // Получаем приватное поле "id" класса Person
        Field idField = personClass.getDeclaredField("id");

        // Делаем поле "id" доступным для изменения
        idField.setAccessible(true);

        // Получаем текущее значение поля "id" объекта person
        int currentId = (int) idField.get(person);
        System.out.println(currentId);

        // Изменяем значение поля "id" объекта person на -123
        idField.set(person, -123);

        // Выводим объект person на консоль после изменения поля "id"
        System.out.println(person);
    }
}

class Person {
    private String fullName;
    private int id;

    public Person(int id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                ", id=" + id +
                '}';
    }
}
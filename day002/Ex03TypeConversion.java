public class Ex03TypeConversion {
    public static void main(String[] args) {
        // Неявное преобразование типов
        int myInt = 9;
        double myDouble = myInt; // Автоматическое преобразование int в double
        System.out.println("Неявное преобразование int в double: " + myDouble);

        // Явное преобразование типов
        double anotherDouble = 9.78;
        int anotherInt = (int) anotherDouble; // Явное преобразование double в int
        System.out.println("Явное преобразование double в int: " + anotherInt);

        // Автоматическая упаковка и распаковка
        Integer wrappedInt = 5; // Автоматическая упаковка int в Integer
        int unwrappedInt = wrappedInt; // Автоматическая распаковка Integer в int
        System.out.println("Автоматическая упаковка и распаковка: " + unwrappedInt);

        // Преобразование строки в числа
        String intString = "2147000000";
        int parsedInt = Integer.parseInt(intString);
        System.out.println("Преобразование строки в int: " + parsedInt);

        String doubleString = "12.345";
        double parsedDouble = Double.parseDouble(doubleString);
        System.out.println("Преобразование строки в double: " + parsedDouble);

        // Преобразование через классы-обертки
        Integer intObject = Integer.valueOf(intString);
        Double doubleObject = Double.valueOf(doubleString);
        System.out.println("Преобразование строки в Integer: " + intObject);
        System.out.println("Преобразование строки в Double: " + doubleObject);
    }
}

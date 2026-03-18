public class Ex15CaesarCipher {
    public static void main(String[] args) {
        // Исходный текст для шифрования
        String text = "Привет, мир!";
        // Величина сдвига для шифра Цезаря
        int shift = 1;

        // Алфавит, используемый для шифрования
        String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        // Переменная для хранения зашифрованного текста
        String cipherText = "";

        // Проходим по каждому символу исходного текста
        for (int i = 0; i < text.length(); i++) {
            // Получаем текущий символ
            char c = text.charAt(i);
            // Находим индекс символа в алфавите (в нижнем регистре)
            int index = alphabet.indexOf(Character.toLowerCase(c));

            // Если символ найден в алфавите
            if (index != -1) {
                // Вычисляем новый индекс с учетом сдвига
                int newIndex = (index + shift) % alphabet.length();
                // Получаем новый символ из алфавита
                char newChar = alphabet.charAt(newIndex);

                // Проверяем, был ли исходный символ в верхнем регистре
                if (Character.isUpperCase(c)) {
                    // Если да, добавляем новый символ в верхнем регистре
                    cipherText += Character.toUpperCase(newChar);
                } else {
                    // Иначе добавляем новый символ как есть
                    cipherText += newChar;
                }
            } else {
                // Если символ не найден в алфавите, добавляем его без изменений
                cipherText += c;
            }
        }

        // Выводим исходный текст
        System.out.println("Исходный текст: " + text);
        // Выводим зашифрованный текст
        System.out.println("Зашифрованный текст: " + cipherText);
    }
}

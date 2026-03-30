package ru.ksergey.singleton.exercise;

// Пример использования
public class Shop {
    public static void main(String[] args) {
        // Получение экземпляра логгера
        Logger logger = Logger.getInstance();

        // Логирование различных событий
        logger.logInfo("Запуск интернет-магазина");
        logger.logWarning("Низкий остаток товара на складе");
        logger.logError("Ошибка при обработке платежа");
        logger.logDebug("Детали отладки");

        // Вывод полной истории логов
        System.out.println("Полная история логов:");
        for (var item : logger.getLogHistory()) {
            System.out.println(item);
        }

        // Получение логов определенного уровня
        System.out.println("\nЛоги уровня ERROR:");
        for (var item : logger.getLogsByLevel(Logger.LogLevel.ERROR)) {
            System.out.println(item);
        }
    }
}

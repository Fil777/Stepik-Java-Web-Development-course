import java.util.Scanner;

public class Ex06CoinGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Символ для отображения монеты
        String img = "🪙";

        // Игровое поле в виде двумерного массива строк
        String[][] board = {
                { img, img },
                { img, img, img },
                { img, img, img, img, img }
        };

        // Номер текущего игрока (1 или 2)
        int player = 1;
        // Флаг окончания игры
        boolean gameOver = false;

        // Основной цикл игры
        while (!gameOver) {
            // Вывод игрового поля
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }

            // Запрос хода у игрока
            System.out.println("Ход игрока: " + player);
            System.out.print("Введите номер ряда (1-" + board.length + "): ");
            int row = scanner.nextInt() - 1;
            System.out.print("Введите количество монет: ");
            int coins = scanner.nextInt();

            // Проверка корректности хода
            if (row >= 0
                    && row < board.length
                    && coins > 0
                    && coins <= board[row].length) {
                // Удаление монет из выбранного ряда
                board[row] = new String[board[row].length - coins];
                for (int i = 0; i < board[row].length; i++) {
                    board[row][i] = img;
                }

                // Проверка окончания игры
                gameOver = true;
                for (int i = 0; i < board.length; i++) {
                    if (board[i].length > 0) {
                        gameOver = false;
                    }
                }

                // Смена текущего игрока
                player = player == 1 ? 2 : 1;

            } else {
                System.out.println("Некорректный ход. Попробуйте ещё раз.");
            }
        }

        // Вывод результата игры
        System.out.println("Игра окончена. Победил игрок " + (player == 1 ? 2 : 1));

        scanner.close();
    }
}

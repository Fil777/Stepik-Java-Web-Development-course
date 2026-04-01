package stepik.course;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // пример 1
        Calculate calculator = new Calculate(new Sum());
        int res1 = calculator.execute(2, 3);
        System.out.println("Sum result = " + res1);

        // пример 2
        calculator.setOperation(new Sub());
        int res2 = calculator.execute(2, 3);
        System.out.println("Sub result = " + res2);

        // пример 3
        MathOperation op = new Mult();
        calculator.setOperation(op);
        int res3 = calculator.execute(2, 3);
        System.out.println("Operation result = " + res3);

        // пример 4
        // анонимный класс
        calculator.setOperation( new MathOperation() {
            @Override
            public int action(int x, int y) {
                if ( y == 0) return 1;
                int pwr = x;
                for (int i = 1; i < y; i++){
                    pwr *= x;
                }
                return pwr;
            }
        });
        int res4 = calculator.execute(2, 3);
        System.out.println("Operation result = " + res4);

        // пример 5
        // добавляем FunctionalInterface на интерфейс для использования лямбды
        // теперь можно писать вызов абстрактного класса лаконично:
        MathOperation oper = (m, n) -> m * n * -1;
        calculator.setOperation(oper);
        int res5 = calculator.execute(2, 3);
        System.out.println("Operation result = " + res5);

        // пример 6
        // ещё короче:
        Calculate newCalculator = new Calculate();
        newCalculator.setOperation((m, n) -> m * n * -1);
        int res6 = newCalculator.execute(2, 3);
        System.out.println("Operation result = " + res6);

        // пример 7
        // и ещё короче:
        int res7 = new Calculate((m, n) -> m * n * -1).execute(2, 3);
        System.out.println("Operation result = " + res7);

        // пример 8
        // совсем коротко и ясно, как и надо писать в программах далее:
        MathOperation sum = (a, b) -> a + b;
        System.out.println(sum.action(2,3));
        MathOperation sub = (a, b) -> a - b;
        System.out.println(sub.action(2,3));

    }

    @FunctionalInterface
    interface MathOperation {
        int action(int x, int y);
    }

    // всё, что ниже этого комментария станет ненужным при использовании лямбды (см пример 8)

    static class Sum implements MathOperation {
        @Override
        public int action(int x, int y) {
            return x + y;
        }
    }

    static class Sub implements MathOperation {
        @Override
        public int action(int x, int y) {
            return x - y;
        }
    }

    static class Mult implements MathOperation {
        @Override
        public int action(int x, int y) {
            return x * y;
        }
    }


    static class Calculate {
        private MathOperation operation;

        public Calculate() {
            this.operation = null;
        }

        public Calculate(MathOperation operation) {
            setOperation(operation);
        }

        public void setOperation(MathOperation operation) {
            this.operation = operation;
        }

        public int execute(int a, int b) {
            return this.operation.action(a, b);
        }
    }

}
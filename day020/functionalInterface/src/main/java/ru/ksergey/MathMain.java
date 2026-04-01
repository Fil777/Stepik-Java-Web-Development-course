package ru.ksergey;

public class MathMain {
    public static void main(String[] args) {
        MathOperation op = new AbstractOp();
        Calculate calculate = new Calculate(op);
        calculate.calculate(2, 3);
        // ....
        calculate.setOperation(new Sum());
        calculate.calculate(2, 3);

        op = new MathOperation() {
            @Override
            public int action(int x, int y) {
                return x * y;
            }
        };

        calculate.setOperation(op);
        calculate.calculate(2, 3);

        calculate.setOperation(new MathOperation() {
            @Override
            public int action(int x, int y) {
                return x * y * 2;
            }
        });
        calculate.calculate(2, 3);

        op = (x, y) -> x * y * 2;

        calculate.setOperation(op);
        calculate.calculate(10, 20);
    }
}

@FunctionalInterface
interface MathOperation {
    int action(int x, int y);
}

class Sum implements MathOperation {
    @Override
    public int action(int x, int y) {
        return x + y;
    }
}

class Sub implements MathOperation {
    @Override
    public int action(int x, int y) {
        return x - y;
    }
}

class AbstractOp implements MathOperation {

    @Override
    public int action(int x, int y) {
        return (x + y) * 2;
    }
}

class Calculate {
    public void setOperation(MathOperation operation) {
        this.operation = operation;
    }

    private MathOperation operation;

    public Calculate(MathOperation operation) {
        this.operation = operation;
    }

    public void calculate(int a, int b) {
        int result = operation.action(a, b);

        System.out.println("result: " + result);
    }
}

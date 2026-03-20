import library.MathUtils;
import library.TerminalView;
import exercises.*;

public class Main {
    public static void main(String[] args) {
        var r = MathUtils.fibonacci(10);
        System.out.println(r);
        TerminalView.print("foo");
        TerminalView.print(123);

        TerminalView.printMathPi();
        MathUtils.PI = 3.1415;

        TerminalView.printMathPi();

        Exercise01.main(args);
    }
}

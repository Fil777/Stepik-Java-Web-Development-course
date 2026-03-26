package ru.ksergey.lsp.ex01;

public class CalculatingDistance {
    int time;

    public CalculatingDistance(int time) {
        this.time = time;
    }

    public void calculate(Bird bird) {
        for (int i = 0; i < time; i++) {
            bird.fly();
        }

        System.out.printf("%n%n%nРасстояние:  %d %s%n", bird.getSpacing(), bird.position);
    }
}

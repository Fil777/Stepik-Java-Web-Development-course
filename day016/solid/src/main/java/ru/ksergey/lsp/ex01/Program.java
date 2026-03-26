package ru.ksergey.lsp.ex01;

public class Program {
    public static void main(String[] args) {
        Bird bird = new Bird();
        CalculatingDistance dist = new CalculatingDistance(10);
        dist.calculate(bird);

        Kiwi kiwi = new Kiwi();
        dist = new CalculatingDistance(10);
        dist.calculate(kiwi);
    }
}

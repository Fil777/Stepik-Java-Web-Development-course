public class Ex03LogicalOperations {
    public static void main(String[] args) {
        int x1 = 21;
        int x2 = 12;
        int x3 = 14;
        int x4 = 21;

        // AND (&&): возвращает `true`, если оба условия истинны. В примере
        // `(x1 > x2) && (x3 < x4)` возвращает `false`, так как второе условие ложно.
        boolean andResult = (x1 > x2) && (x3 < x4);
        System.out.println("AND Result: " + andResult);

        // OR (||): возвращает `true`, если хотя бы одно из условий истинно. В примере
        // `(x1 > x2) || (x3 > x4)` возвращает `true`, так как первое условие истинно.
        boolean orResult = (x1 > x2) || (x3 > x4);
        System.out.println("OR Result: " + orResult);

        // XOR (^): возвращает `true`, если ровно одно из условий истинно. В примере
        // `(x1 > x2) ^ (x3 > x4)` возвращает `true`, так как только первое условие
        // истинно.
        boolean xorResult = (x1 > x2) ^ (x3 > x4);
        System.out.println("XOR Result: " + xorResult);

        // NOT (!): инвертирует значение условия. В примере `!(x1 > x2)`
        // возвращает `false`, так как условие `(x1 > x2)` истинно, а оператор NOT
        // инвертирует его.
        boolean notResult = !(x1 > x2);
        System.out.println("NOT Result: " + notResult);
    }
}

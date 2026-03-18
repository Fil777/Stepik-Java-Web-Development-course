import java.util.HashMap;

public class Ex08HashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Банан", 55);
        map.put("Яблоко", 5);
        map.put("Апельсин", 3);

        System.out.println(map.get("Банан"));
        System.out.println(map.containsKey("Банан"));
        System.out.println(map.containsValue(3));
        System.out.println(map.containsKey("Киви"));
        System.out.println(map.containsValue(2025));
        System.out.println(map);
        map.remove("Яблоко");
        System.out.println(map);
        System.out.println(map.values());
        System.out.println(map.keySet());

        System.out.println(map.size());
        map.clear();
        System.out.println(map);

    }
}

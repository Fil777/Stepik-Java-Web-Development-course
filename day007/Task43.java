import java.util.HashMap;

public class Task43 {
    public static void main(String[] args) {
        String sourceText = "Далеко-далеко за словесными горами в стране гласных и согласных живут рыбные тексты.";
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char c : sourceText.toCharArray()) {
            // if (Character.isLetter(c)) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            // }
        }
        for (Character key : charCount.keySet()) {
            System.out.println(key + " = " + charCount.get(key));
        }
    }
}

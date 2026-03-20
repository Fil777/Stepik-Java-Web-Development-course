package exercises;

public class Exercise01 {
    public static String getGradeDescription(int grade) {
        if (grade == 5) {
            return "отлично";
        } else if (grade == 4) {
            return "хорошо";
        } else if (grade == 3) {
            return "удовлетворительно";
        } else if (grade <= 2 && grade >= 1) {
            return "неудовлетворительно";
        } else {
            return "некорректная оценка";
        }
    }

    public static void main(String[] args) {
        System.out.println(getGradeDescription(5)); // отлично
        System.out.println(getGradeDescription(4)); // хорошо
        System.out.println(getGradeDescription(3)); // удовлетворительно
        System.out.println(getGradeDescription(2)); // неудовлетворительно
        System.out.println(getGradeDescription(1)); // неудовлетворительно
        System.out.println(getGradeDescription(0)); // некорректная оценка
    }
}

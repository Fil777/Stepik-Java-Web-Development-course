package model;

public enum PersonType {
    UNKNOWN("Не определено"),
    STAFF("Сотрудник"),
    INSTRUCTOR("Преподаватель"),
    STUDENT("Учащийся");

    private String meaning;

    PersonType(String meaning) {
        this.meaning = meaning;
    }

    public String meaning() {
        return this.meaning;
    }

    @Override
    public String toString() {
        return this.meaning;
    }
}

package model;

import java.util.Comparator;

public class PersonComparator <Person> implements Comparator <Person>  {
    @Override
    public int compare(Person p1, Person p2) {
        if (p1 == null && p2 == null) {
            return 0;
        } else if (p1 == null) {
            return -1;
        } else if (p2 == null) {
            return 1;
        }
        if (!(p1 instanceof Person)) {
            return -1;
        }
        if (!(p2 instanceof Person)) {
            return 1;
        }
        EmptyPerson person1 = (EmptyPerson) p1;
        EmptyPerson person2 = (EmptyPerson) p2;
        int result = 0;
        result = person1.getName().compareTo(person2.getName());
        if (result != 0) {
            return result;
        }
        result = Integer.compare(person1.getAge(), person2.getAge());
        if (result != 0) {
            return result;
        }
        return Integer.compare(person1.getId(), person2.getId());
    }
}

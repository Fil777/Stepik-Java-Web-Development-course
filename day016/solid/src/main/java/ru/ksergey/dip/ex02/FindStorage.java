package ru.ksergey.dip.ex02;

import java.util.List;
import java.util.function.Predicate;

public interface FindStorage {
    List<Person> findAll(Predicate<Person> predicate);
}
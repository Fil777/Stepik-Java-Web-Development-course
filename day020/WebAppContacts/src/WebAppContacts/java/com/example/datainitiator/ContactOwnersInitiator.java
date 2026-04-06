package com.example.datainitiator;


import com.example.model.entity.Contact;
import com.example.model.entity.ContactOwner;
import com.example.model.enums.AppRole;
import com.example.transliterator.CyrillicToLatin;
import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class ContactOwnersInitiator {
    public static ArrayList<ContactOwner> generate() {
        int counter = 10;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        ArrayList<ContactOwner> owners = new ArrayList<>();

        // эмулируем владельцев контактов из faker
        Faker faker = new Faker(Locale.of("ru"));
        for (int i = 1; i < counter; i++) {
            ContactOwner owner = new ContactOwner();
            owner.setUsername(faker.name().username());
            owner.setPassword(faker.internet().password(6,20, true, false, true));
            owner.setDescription(faker.lorem().sentence());
            owner.setEmail(faker.internet().emailAddress());
            owner.setFullName(faker.name().fullName());
            owner.setRole(AppRole.USER);
            // латинизация email
            String[] parts = owner.getFullName().trim().split(" ");
            owner.setEmail(
                    CyrillicToLatin.transliterate(parts[0]) + "."
                            + CyrillicToLatin.transliterate(parts[1]) + "@mail.ru");
            owner.setUsername(CyrillicToLatin.transliterate(parts[0]+parts[1]));
            // контакт - в список
            owners.add(owner);
        }
        return owners;
    }



}

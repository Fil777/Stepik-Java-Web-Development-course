package com.example.initiatedata;

import com.example.entity.Contact;
import com.example.transliterator.CyrillicToLatin;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Locale;

public class ContactsInitiator {

    public static ArrayList<Contact> generate(int contactsCounter){
        ArrayList<Contact> contacts = new ArrayList<>();
        Faker faker = new Faker(Locale.of("ru"));
        for (int i = 1; i < contactsCounter; i++) {
            Contact contact = new Contact(
                    i,
                    faker.name().firstName(),
                    faker.name().lastName(),
                    faker.demographic().sex(),
                    faker.phoneNumber().phoneNumber(),
                    faker.internet().emailAddress()
            );
            contact.setEmail(
                    CyrillicToLatin.transliterate(contact.getFirstName()) + "." +
                            CyrillicToLatin.transliterate(contact.getLastName()) + "@mail.ru");
            if (contact.getLastName().charAt(contact.getLastName().length() - 1) == 'а') {
                contact.setSex("Female");
            } else if (contact.getFirstName().charAt(contact.getFirstName().length() - 1) == 'а') {
                contact.setSex("Female");
            } else if (contact.getFirstName().charAt(contact.getFirstName().length() - 1) == 'я') {
                contact.setSex("Female");
            } else if (contact.getFirstName().charAt(contact.getFirstName().length() - 1) == 'й') {
                contact.setSex("Male");
            } else {
                contact.setSex("Male");
            }

            contacts.add(contact);
        }
        return contacts;
    }
}

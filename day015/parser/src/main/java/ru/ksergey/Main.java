package ru.ksergey;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import ru.ksergey.model.Contact;
import ru.ksergey.model.ContactsResponse;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        parseJson();
    }

    static void parseJson() throws IOException {
        Path path = Path.of("data.json");

        String json = Files.readString(path);

        ObjectMapper mapper = new ObjectMapper();

        ContactsResponse response = mapper.readValue(json, ContactsResponse.class);

        System.out.println(response.getPageSize());
        System.out.println(response.getCurrentPage());
        System.out.println(response.getTotalCount());
        ArrayList<Contact> list = response.getContacts();

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    static void createJson() throws IOException {
        Faker faker = new Faker();

        int totalCount = faker.number().numberBetween(20, 31);
        int currentPage = faker.number().numberBetween(3, 8);
        int pageSize = totalCount % currentPage == 0
                ? totalCount / currentPage
                : totalCount / currentPage + 1;

        ArrayList<HashMap<String, Object>> contacts = new ArrayList<>();

        for (int i = 10; i < 10 + pageSize; i++) {
            HashMap<String, Object> contact = new HashMap<>();
            contact.put("id", i);
            contact.put("name", faker.name().fullName());
            contact.put("email", faker.internet().emailAddress());
            contacts.add(contact);
        }

        HashMap<String, Object> data = new HashMap<>();

        data.put("contacts", contacts);
        data.put("totalCount", totalCount);
        data.put("currentPage", currentPage);
        data.put("pageSize", pageSize);

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(data);
        System.out.println(json);

        FileWriter fw = new FileWriter("data.json");
        fw.write(json);
        fw.close();
    }
}

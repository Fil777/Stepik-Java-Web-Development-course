package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import org.example.model.ContactResponse;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class JsonParser {
    public static void main(String[] args) {
        createJson();
        parseJson();
    }

    public static void parseJson() {
        Path path = Path.of("data.json");

        try {
            String json = Files.readString(path);
            ObjectMapper mapper = new ObjectMapper();
            ContactResponse response = mapper.readValue(json, ContactResponse.class);
            System.out.println(response);
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    public static void createJson()  {
        Faker faker = new Faker();

        int totalCount = faker.number().numberBetween(10, 20);
        int currentPage = faker.number().numberBetween(1, 5);
        int pageSize = totalCount % currentPage == 0 ? totalCount / currentPage : totalCount / currentPage + 1;
        ArrayList<HashMap<String, Object>> contacts = new ArrayList<>();

        for (int i = 0; i < currentPage; i++) {
            HashMap<String, Object> contact = new HashMap<>();
            contact.put("id", i + 1);
            contact.put("name", faker.name().fullName());
            contact.put("email", faker.internet().emailAddress());
            contacts.add(contact);
        }

        HashMap<String, Object> data = new HashMap<>();
        data.put("contacts", contacts);
        data.put("totalCount", totalCount);
        data.put("currentPage", currentPage);
        data.put("pageSize", pageSize);

        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(data);
            FileWriter writer = new FileWriter("data.json");
            writer.write(json);
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
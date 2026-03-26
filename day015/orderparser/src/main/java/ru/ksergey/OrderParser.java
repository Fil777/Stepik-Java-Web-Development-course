package ru.ksergey;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.ksergey.model.OrderDetailItem;
import ru.ksergey.model.Root;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class OrderParser {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        File jsonFile = new File("data.json");

        Root root = mapper.readValue(jsonFile, Root.class);

        System.out.println(root.getStatusCode());
        ArrayList<OrderDetailItem> orderDetailItems = root
                .getResult()
                .getOrderDetailItems();

        for (int i = 0; i < orderDetailItems.size(); i++) {
            System.out.println(orderDetailItems.get(i)
                    .getProduct()
                    .getId());
            System.out.println(orderDetailItems.get(i)
                    .getProduct()
                    .getName());
            System.out.println(orderDetailItems.get(i)
                    .getProduct()
                    .getDescription());
        }
    }
}

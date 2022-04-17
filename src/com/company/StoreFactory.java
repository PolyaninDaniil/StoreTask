package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class StoreFactory {
    public static Store[] generateStores(int numberOfStore) {

        Store[] stores = new Store[numberOfStore];

        for (int i = 0; i < numberOfStore; i++) {
            stores[i] = new Store(generateName(), generateProducts(), generateEmployees(), generateOpenStatus());
        }
        return stores;
    }

    public static String generateName() {
        String characters = "qwrtplkjhgfdszxcvbnmaeiou";
        Random random = new Random();
        int length = random.nextInt(4, 6);
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(random.nextInt(characters.length()));
        }
        return new String(text);
    }

    private static boolean generateOpenStatus() {
        Random random = new Random();
        return random.nextBoolean();
    }


    private static Employee[] generateEmployees() {
        Random random = new Random();
        Employee[] employees = new Employee[random.nextInt(10, 20)];
        for (int i = 0; i < employees.length; i++) {
            employees[i] = generateEmployee();
        }

        return employees;
    }

    private static Employee generateEmployee() {
        Random random = new Random();
        int rnd = random.nextInt(1, 4);
        if (rnd == 1) {
            return new SalesAssistant(generateName(), random.nextInt(10000, 60000));
        }
        if (rnd == 2) {
            return new Cashier(generateName(), random.nextInt(10000, 30000));
        }
        return new Cleaner(generateName(), random.nextInt(7000, 20000));
    }

    private static Product[] generateProducts() {
        Random random = new Random();
        Product[] products = new Product[random.nextInt(5, 10)];
        for (int i = 0; i < products.length; i++) {
            products[i] = new Product(random.nextInt(100, 3000), generateName());
        }
        return products;
    }



}

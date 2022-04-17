package com.company;

import java.util.Arrays;

public class Store {
    private String nameOfStore;


    private Product[] products;
    private Employee[] employees;
    private boolean openStatus;

    public Store(String nameOfStore, Product[] products, Employee[] employees, boolean openStatus) {
        this.nameOfStore = nameOfStore;
        this.products = products;
        this.employees = employees;
        this.openStatus = openStatus;
        calculatePremiums();
    }

    @Override
    public String toString() {
        return "Store{" +
                "nameOfStore='" + nameOfStore + '\'' +
                ",\n products=" + Arrays.toString(products) +
                ",\n employee=" + Arrays.toString(employees) +
                ",\n openStatus=" + openStatus +
                "}\n" + getAmountOfEmployees() +
                "}\n" + getAverageSalary() +
                "}\n" + getAmountOfProduct() +
                "}\n" + getMinOfProduct() +
                "}\n" + "Maximum price: " + getMaxOfProduct();
    }

    public String getAmountOfEmployees() {
        int sales = 0;
        int cleaners = 0;
        int cashiers = 0;
        for (Employee employee : employees) {
            if (employee instanceof SalesAssistant) {
                sales++;
            }
            if (employee instanceof Cashier) {
                cashiers++;
            }
            if (employee instanceof Cleaner) {
                cleaners++;
            }
        }
        String n = "SalesAssistants: " + sales + "; Cashiers: " + cashiers + "; Cleaners: " + cleaners + "\n";
        return n;
    }

    public String getAverageSalary() {
        int s = 0;
        for (int i = 0; i < employees.length; i++) {
            s += employees[i].getSalary();
        }
        s = s / employees.length;
        String string = "Average salary: " + s;
        return string;

    }

    public String getAmountOfProduct() {
        int s = 0;
        for (int i = 0; i < products.length; i++) {
            s++;
        }
        String p = "Amount of products: " + s;
        return p;
    }

    public String getMinOfProduct() {
        int min = 100000;

        for (Product product : products) {
            if (product.getPrice() < min) {
                min = product.getPrice();
            }
        }

        String p = "Minimal price: " + min + ". ";
        return p;
    }

    public int getMaxOfProduct() {
        int max = 0;
        for (Product product : products) {
            if (product.getPrice() > max) {
                max = product.getPrice();
            }
        }
        return max;
    }

    public void calculatePremiums() {
        int max = 0;
        for (Product product : products) {
            if (product.getPrice() > max) {
                max = product.getPrice();
            }
        }
        for (Employee employee : employees) {
            if (employee instanceof Stimulatable) {
                ((Stimulatable)employee).calculatePremium(products.length, max);
            }
        }
    }
}

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
                "}\n" + "Average salary for SalesAssistants: " + getAverageSalaryForSalesAssistant() +
                "}\n" + "Average salary for Cleaners: " + getAverageSalaryForCleaners() +
                "}\n" + "Average salary for Cashiers: " + getAverageSalaryForCashiers() +
                "}\n" + "Difference between SalesAssistants and Cashiers: " + getDifferenceBetweenSalesAssistantsAndCashiers() + "%" +
                "}\n" + "Difference between SalesAssistants and Cleaners: " + getDifferenceBetweenSalesAssistantsAndCleaners() + "%" +
                "}\n" + "Difference between Cashiers and Cleaners: " + getDifferenceBetweenCashiersAndCleaners() + "%" +
                "}\n" + "Amount of products: " + getAmountOfProduct() +
                "}\n" + "Minimum price: " + getMinOfProduct() +
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

    public int getAverageSalaryForSalesAssistant() {
        int salesAssistants = 0;
        int allSalaries = 0;
        for (Employee employee : employees) {
            if (employee instanceof SalesAssistant) {
                salesAssistants++;
                allSalaries += employee.getSalary();
            }
        }
        return allSalaries / salesAssistants;
    }

    public int getAverageSalaryForCashiers() {
        int cashiers = 0;
        int allSalaries = 0;
        for (Employee employee : employees) {
            if (employee instanceof Cashier) {
                cashiers++;
                allSalaries += employee.getSalary();
            }
        }
        return allSalaries / cashiers;
    }

    public int getAverageSalaryForCleaners() {
        int cleaners = 0;
        int allSalaries = 0;
        for (Employee employee : employees) {
            if (employee instanceof Cleaner) {
                cleaners++;
                allSalaries += employee.getSalary();
            }
        }
        return allSalaries / cleaners;
    }

    private int percent(int a, int b) {
        float result = 0;
        result = ((a - b) * 100) / b;

        return (int) result;
    }

    public int getDifferenceBetweenSalesAssistantsAndCashiers() {
        return percent(getAverageSalaryForSalesAssistant(), getAverageSalaryForCashiers());
    }

    public int getDifferenceBetweenSalesAssistantsAndCleaners() {
        return percent(getAverageSalaryForSalesAssistant(), getAverageSalaryForCleaners());
    }
    public int getDifferenceBetweenCashiersAndCleaners() {
        return percent(getAverageSalaryForCashiers(), getAverageSalaryForCleaners());
    }


    public int getAmountOfProduct() {
        int s = 0;
        for (int i = 0; i < products.length; i++) {
            s++;
        }
        return s;
    }

    public int getMinOfProduct() {
        int min = 100000;

        for (Product product : products) {
            if (product.getPrice() < min) {
                min = product.getPrice();
            }
        }

        return min;
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
                ((Stimulatable) employee).calculatePremium(products.length, max);
            }
        }
    }
}

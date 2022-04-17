package com.company;

public class SalesAssistant extends Employee implements Stimulatable {

    private int premium;

    SalesAssistant(String name, int salary) {
        super(name, salary);
    }

    @Override
    public String toString() {
        return "\nSalesAssistant{" +
                "salary=" + getSalary() +
                ", name='" + getName() + '\'' +
                 ", premium=" + premium +
                '}';
    }

    @Override
    public void calculatePremium(int amountOfProducts, int maxPrice) {
        premium = (int) (getSalary() * 0.01 * (maxPrice/100 * amountOfProducts));
    }
}

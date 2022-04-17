package com.company;

public class Cleaner extends Employee {
    Cleaner(String name, int salary) {
        super(name, salary);
    }
    @Override
    public String toString() {
        return "\nCleaner{" +
                "salary=" + getSalary() +
                ", name='" + getName() + '\'' +
                '}';
    }
}

package com.company;

public class Product {
    private int price;
    private String nameOfProduct;
    public Product(int price, String nameOfProduct) {
        this.price = price;
        this.nameOfProduct = nameOfProduct;
    }

    @Override
    public String toString() {
        return "\nProduct{" +
                "price=" + price +
                ", nameOfProduct='" + nameOfProduct + '\'' +
                '}';
    }

    public int getPrice() {
        return price;
    }



    public void setPrice(int price) {
        this.price = price;
    }
}

package com.narendra.entity;

public class Product {
    private static int ID_GENERATOR = 1;
    private final int code;
    private final String name;
    private final double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.code = ID_GENERATOR ++;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void decreaseQuantity() {
        quantity --;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}

package com.narendra.entity;

import java.util.HashMap;
import java.util.Map;

public class ProductInventory {
    private final Map<Integer, Product> productsMap = new HashMap<>();
    public void restock(Product product) {
        productsMap.put(product.getCode(), product);
    }
    public Product getProductByCode(int code) {
        return productsMap.get(code);
    }

    @Override
    public String toString() {
        return "ProductInventory{" +
                "productsMap=" + productsMap +
                '}';
    }
}

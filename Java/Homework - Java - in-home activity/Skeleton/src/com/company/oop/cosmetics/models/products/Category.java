package com.company.oop.cosmetics.models.products;

import com.company.oop.cosmetics.commands.AddToCategory;
import com.company.oop.cosmetics.models.products.Product;

import java.util.ArrayList;
import java.util.List;

public class Category {

    public static final int MIN_LENGTH_NAME_CATEGORY = 2;
    public static final int MAX_LENGTH_NAME_CATEGORY = 15;
    private String name;
    private List<Product> products = new ArrayList<>();


    public Category(String name) {
        if (name.length() < MIN_LENGTH_NAME_CATEGORY || name.length() > MAX_LENGTH_NAME_CATEGORY) {
            throw new IllegalArgumentException("Category name’s length must be minimum 2 symbols and maximum 15 symbols.");
        }
        this.name = name;
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product can not be null.");
        }
        products.add(product);
    }

    public void removeProduct(Product product) {
        if (!getProducts().contains(product)) {
            throw new IllegalArgumentException("Product can not be null.");
        }
        products.remove(product);
    }

    public String print() {
        return constructPrint();
    }

    private String constructPrint() {
        StringBuilder statement = new StringBuilder();
        statement.append("#Category ").append(name).append("\n");

        if (products.isEmpty()) {
            statement.append("#No product in this category");
            return statement.toString();
        }

        for (Product product : products) {
            statement.append(product.print()).append("\n");
        }
        return statement.toString();
    }

}
    


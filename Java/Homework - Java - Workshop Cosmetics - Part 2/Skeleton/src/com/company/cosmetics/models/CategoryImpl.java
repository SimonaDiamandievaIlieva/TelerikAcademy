package com.company.cosmetics.models;


import com.company.cosmetics.models.contracts.Category;
import com.company.cosmetics.models.contracts.Product;
import com.company.cosmetics.models.products.ProductBase;


import java.util.ArrayList;
import java.util.List;

public class CategoryImpl implements Category {
    private static final String CATEGORY_NAME_LENGTH_ERROR = "Category name’s length is minimum 2 symbols and maximum 15 symbols.";
    private static final int MIN_CATEGORY_NAME_LENGTH = 2;
    private static final int MAX_CATEGORY_NAME_LENGTH = 15;

    private String name;
    protected List<Product> products= new ArrayList<>();
    
    public CategoryImpl(String name) {
        setName(name);
        setProducts(products);
    }

    private void setName(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName (String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name can not be null");
        }
        if (name.length() < MIN_CATEGORY_NAME_LENGTH || name.length()> MAX_CATEGORY_NAME_LENGTH) {
            throw new IllegalArgumentException(CATEGORY_NAME_LENGTH_ERROR);
        }
    }
    private void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getName() {
        return name;
    }
    
    public List<Product> getProducts() {
        //We are returning a copy to protect the original list.
        return new ArrayList<>(products);
    }
    
    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product can not be null.");
        }
        products.add(product);
    }
    
    public void removeProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product can not be null.");
        }
        products.remove(product);
    }

    public String print() {
        if (products.size() == 0) {
            return String.format("#Category: %s\n" +
                    " #No product in this category", name);
        }
        else {
            StringBuilder category = new StringBuilder();
            for (Product product : products
                 ) {
                category.append(product.print());
            }
            return String.format("#Category: %s \n %s", name, category);
        }
    }
}

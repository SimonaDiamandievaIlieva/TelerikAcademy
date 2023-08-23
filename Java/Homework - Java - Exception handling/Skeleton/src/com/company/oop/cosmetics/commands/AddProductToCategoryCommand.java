package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.commands.contracts.Command;
import com.company.oop.cosmetics.core.contracts.ProductRepository;
import com.company.oop.cosmetics.models.contracts.Category;
import com.company.oop.cosmetics.models.contracts.Product;
import exceptions.InvalidParametersCountExceptions;
import exceptions.InvalidUserInputException;

import java.util.List;

public class AddProductToCategoryCommand implements Command {
    private static final String PRODUCT_ADDED_TO_CATEGORY = "Product %s added to category %s!";
    public static final int PARAMETERS_LENGTH = 2;

    private final ProductRepository productRepository;

    public AddProductToCategoryCommand(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public String execute(List<String> parameters) throws InvalidUserInputException {
        if (parameters.size() != PARAMETERS_LENGTH) {
            throw new InvalidParametersCountExceptions("Add  Product to category", PARAMETERS_LENGTH);
        }

        String categoryNameToAdd = parameters.get(0);
        String productNameToAdd = parameters.get(1);

        return addProductToCategory(categoryNameToAdd, productNameToAdd);
    }

    private String addProductToCategory(String categoryName, String productName) {
        Category category = productRepository.findCategoryByName(categoryName);
        Product product = productRepository.findProductByName(productName);

        category.addProduct(product);

        return String.format(PRODUCT_ADDED_TO_CATEGORY, productName, categoryName);
    }
}

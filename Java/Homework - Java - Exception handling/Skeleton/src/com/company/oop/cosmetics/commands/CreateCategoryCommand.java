package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.core.contracts.ProductRepository;
import com.company.oop.cosmetics.commands.contracts.Command;
import exceptions.InvalidNameExistingException;
import exceptions.InvalidParametersCountExceptions;
import exceptions.InvalidUserInputException;

import java.util.List;

public class CreateCategoryCommand implements Command {
    private static final String CATEGORY_CREATED = "Category with name %s was created!";
    private static final int MAX_CATEGORY_PARAMETER_COUNT = 1;

    private final ProductRepository productRepository;

    public CreateCategoryCommand(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public String execute(List<String> parameters) throws InvalidUserInputException {
        if (parameters.size() != MAX_CATEGORY_PARAMETER_COUNT) {
            throw new InvalidParametersCountExceptions("CreateCategory", MAX_CATEGORY_PARAMETER_COUNT);
        }
        String categoryName = parameters.get(0);

        return createCategory(categoryName);
    }

    private String createCategory(String categoryName) throws InvalidUserInputException {
        if (productRepository.categoryExist(categoryName)) {
            throw new InvalidNameExistingException("Category", categoryName);
        }

        productRepository.createCategory(categoryName);

        return String.format(CATEGORY_CREATED, categoryName);
    }
}

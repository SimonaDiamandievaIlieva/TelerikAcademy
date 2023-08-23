package com.company.oop.cosmetics.tests.commands;

import com.company.oop.cosmetics.commands.CreateCategoryCommand;
import com.company.oop.cosmetics.commands.contracts.Command;
import com.company.oop.cosmetics.core.ProductRepositoryImpl;
import com.company.oop.cosmetics.exceptions.DuplicateEntityException;
import com.company.oop.cosmetics.exceptions.InvalidUserInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CreateCategoryCommandTests {
    private Command command;
    private ProductRepositoryImpl productRepository;

    private List<String> parameters = new ArrayList<>();
    @BeforeEach
    public void before () {
        this.productRepository = new ProductRepositoryImpl();
        this.command = new CreateCategoryCommand(productRepository);
    }

    @Test
    public void execute_Should_AddNewCategoryToRepository_When_ValidParameters() {
        String name = "TestCat";
        parameters.add(name);
        Assertions.assertEquals("Category with name TestCat was created!", command.execute(parameters));
    }

    @Test
    public void execute_Should_ThrowException_When_MissingParameters() {
        Assertions.assertThrows(InvalidUserInputException.class, () -> command.execute(parameters));
    }

    @Test
    public void execute_Should_ThrowException_When_DuplicateCategoryName() {
        String name = "TestCat";
        parameters.add(name);
        command.execute(parameters);
        Assertions.assertThrows(DuplicateEntityException.class, () -> command.execute(parameters));
    }

}

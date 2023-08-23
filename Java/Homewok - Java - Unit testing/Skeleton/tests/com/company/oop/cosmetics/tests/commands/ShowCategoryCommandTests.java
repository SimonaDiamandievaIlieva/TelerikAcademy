package com.company.oop.cosmetics.tests.commands;

import com.company.oop.cosmetics.commands.CreateCategoryCommand;
import com.company.oop.cosmetics.commands.ShowCategoryCommand;
import com.company.oop.cosmetics.commands.contracts.Command;
import com.company.oop.cosmetics.core.ProductRepositoryImpl;
import com.company.oop.cosmetics.exceptions.InvalidUserInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ShowCategoryCommandTests {
    private Command command;
    private ProductRepositoryImpl productRepository;
    private CreateCategoryCommand commandCategory;

    private List<String> parameters = new ArrayList<>();
    private List<String> parametersCategory = new ArrayList<>();
    @BeforeEach
    public void before () {
        this.productRepository = new ProductRepositoryImpl();
        this.command = new ShowCategoryCommand(productRepository);
        this.commandCategory = new CreateCategoryCommand(productRepository);
    }

    @Test
    public void execute_Should_ShowCategory_When_ValidParameters() {
        String name = "TestCat";
        parametersCategory.add(name);
        commandCategory.execute(parametersCategory);

        parameters.add(name);
        Assertions.assertEquals(String.format(
                "#Category: %s%n" +
                        " #No product in this category",
                name), command.execute(parameters));
    }

    @Test
    public void execute_Should_ThrowException_When_MissingParameters() {
        Assertions.assertThrows(InvalidUserInputException.class, () -> command.execute(parameters));
    }
}

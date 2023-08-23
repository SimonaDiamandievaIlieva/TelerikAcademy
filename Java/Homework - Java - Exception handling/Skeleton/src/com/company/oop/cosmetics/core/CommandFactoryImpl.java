package com.company.oop.cosmetics.core;

import com.company.oop.cosmetics.commands.*;
import com.company.oop.cosmetics.core.contracts.CommandFactory;
import com.company.oop.cosmetics.core.contracts.ProductRepository;
import com.company.oop.cosmetics.commands.contracts.Command;
import exceptions.InvalidCommandException;
import exceptions.InvalidUserInputException;

public class CommandFactoryImpl implements CommandFactory {
    @Override
    public Command createCommandFromCommandName(String commandTypeValue, ProductRepository productRepository)
            throws InvalidUserInputException {
        try {
            CommandType commandType = CommandType.valueOf(commandTypeValue.toUpperCase());
            switch (commandType) {
                case CREATECATEGORY:
                    return new CreateCategoryCommand(productRepository);
                case CREATEPRODUCT:
                    return new CreateProductCommand(productRepository);
                case ADDPRODUCTTOCATEGORY:
                    return new AddProductToCategoryCommand(productRepository);
                case SHOWCATEGORY:
                    return new ShowCategoryCommand(productRepository);
                default:
                    throw new InvalidCommandException(String.format("Command %s is not supported.", commandType));
            }

        } catch (IllegalArgumentException e) {
            throw new InvalidCommandException(String.format("Command %s is not supported.", commandTypeValue));
        }
    }
}

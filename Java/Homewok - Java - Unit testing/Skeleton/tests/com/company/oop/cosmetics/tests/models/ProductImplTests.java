package com.company.oop.cosmetics.tests.models;

import com.company.oop.cosmetics.exceptions.InvalidUserInputException;
import com.company.oop.cosmetics.models.GenderType;
import com.company.oop.cosmetics.models.ProductImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductImplTests {

    @Test
    public void constructor_Should_InitializeProduct_When_ArgumentsAreValid () {
        ProductImpl shampoo = new ProductImpl("ForYou", "Nivea", 10, GenderType.WOMEN);
    }

    @Test
    public void constructor_Should_ThrowException_When_NameIsNull() {
       Assertions.assertThrows(NullPointerException.class, () -> new ProductImpl(null, "Nivea", 10, GenderType.WOMEN));
    }

    @Test
    public void constructor_Should_ThrowException_When_BrandIsNull () {
        Assertions.assertThrows(NullPointerException.class, () -> new ProductImpl("ForYou", null, 10, GenderType.WOMEN));
    }

    @Test
    public void constructor_Should_ThrowException_When_NameIsShorterThanExpected() {
        Assertions.assertThrows(InvalidUserInputException.class, () -> new ProductImpl("Fo", "Nivea", 10, GenderType.WOMEN));
    }

    @Test
    public void constructor_Should_ThrowException_When_BrandIsShorterThanExpected () {
        Assertions.assertThrows(InvalidUserInputException.class, () -> new ProductImpl("ForYou", "N", 10, GenderType.WOMEN));
    }

    @Test
    public void constructor_Should_ThrowException_When_NameIsLongerThanExpected() {
        Assertions.assertThrows(InvalidUserInputException.class, () -> new ProductImpl("For you and me forever", "Nivea", 10, GenderType.WOMEN));
    }

    @Test
    public void constructor_Should_ThrowException_When_BrandIsLongerThanExpected () {
        Assertions.assertThrows(InvalidUserInputException.class, () -> new ProductImpl("ForYou", "Nivea International Brand For Everyone", 10, GenderType.WOMEN));
    }

    @Test
    public void constructor_Should_ThrowException_When_PriceIsLowerThanExpected () {
        Assertions.assertThrows(InvalidUserInputException.class, () -> new ProductImpl("ForYou", "Nivea", -10, GenderType.WOMEN));
    }

    @Test
    public void print_Product_When_ValidArguments(){
        ProductImpl shampoo = new ProductImpl("ForYou", "Nivea", 10, GenderType.WOMEN);
        Assertions.assertEquals(String.format(
                "#%s %s%n" +
                        " #Price: $%.2f%n" +
                        " #Gender: %s%n",
                shampoo.getName(),
                shampoo.getBrand(),
                shampoo.getPrice(),
                shampoo.getGender()), shampoo.print());

    }
}

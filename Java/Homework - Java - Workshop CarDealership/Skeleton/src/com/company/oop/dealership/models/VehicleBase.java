package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Comment;
import com.company.oop.dealership.models.contracts.Vehicle;
import com.company.oop.dealership.utils.ValidationHelpers;

import java.util.ArrayList;

public abstract class VehicleBase implements Vehicle {

    private String make;
    private String model;
    private double price;
    private ArrayList<Comment> comments;

    protected VehicleBase(String make, String model, double price) {
        setMake(make);
        setModel(model);
        setPrice(price);
        this.comments = new ArrayList<>();
    }

    @Override
    public String getMake() {
        return make;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public void removeComment(Comment comment) {
        comments.remove(comment);
    }

    @Override
    public ArrayList<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    private void setMake(String make) {
        validateMake(make);
        this.make = make;
    }

    void validateMake(String make) {
        ValidationHelpers.validateIntRange(
                make.length(),
                MAKE_NAME_LEN_MIN,
                MAKE_NAME_LEN_MAX,
                MAKE_NAME_LEN_ERR);
    }

    private void setModel(String model) {
        validateModel(model);
        this.model = model;
    }

    void validateModel(String model) {
        ValidationHelpers.validateIntRange(
                model.length(),
                MODEL_NAME_LEN_MIN,
                MODEL_NAME_LEN_MAX,
                MODEL_NAME_LEN_ERR);
    }

    private void setPrice(double price) {
        validatePrice(price);
        this.price = price;
    }

    void validatePrice(double price) {
        ValidationHelpers.validateDecimalRange(
                price,
                PRICE_VAL_MIN,
                PRICE_VAL_MAX,
                PRICE_VAL_ERR);
    }

    @Override
    public String toString() {
        String className = String.format("%s", getClass().getSimpleName().replace("Impl", ""));
        return String.format("%s:\n" +
                        "Make: %s\n" +
                        "Model: %s\n" +
                        "Wheels: %s\n" +
                        "Price: $%.0f",
                className, make, model, getWheels(), price);
    }

    public String printComment() {
        StringBuilder builder = new StringBuilder();

        if (comments.size() == 0) {
            builder.append(NO_COMMENTS_HEADER);
        } else {
            builder.append(String.format(COMMENTS_HEADER)).append(System.lineSeparator());
            for (Comment comment : comments) {
                builder.append(String.format("%s", comment.toString()))
                        .append(System.lineSeparator());

            }
            builder.append(String.format(COMMENTS_HEADER));
        }

        return builder.toString().trim();
    }
}

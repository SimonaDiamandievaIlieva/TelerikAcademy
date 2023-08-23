package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Comment;
import com.company.oop.dealership.models.contracts.User;
import com.company.oop.dealership.models.contracts.Vehicle;
import com.company.oop.dealership.models.enums.UserRole;
import com.company.oop.dealership.utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.List;

public class UserImpl implements User {
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private final UserRole userRole;
    private final List<Vehicle> vehicles;

    public UserImpl(String username, String firstName, String lastName, String password, UserRole userRole) {
        setUsername(username);
        setFirstName(firstName);
        setLastName(lastName);
        setPassword(password);
        this.userRole = userRole;
        vehicles = new ArrayList<>();
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public UserRole getRole() {
        return userRole;
    }

    @Override
    public List<Vehicle> getVehicles() {
        return new ArrayList<>(vehicles);
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        if (userRole == UserRole.ADMIN) {
            throw new IllegalArgumentException(ADMIN_CANNOT_ADD_VEHICLES);
        }
        if (userRole != UserRole.VIP && vehicles.size() >=NORMAL_ROLE_VEHICLE_LIMIT) {
            throw new IllegalArgumentException(String.format(NOT_AN_VIP_USER_VEHICLES_ADD, NORMAL_ROLE_VEHICLE_LIMIT));
        }
        vehicles.add(vehicle);
    }

    @Override
    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    @Override
    public void addComment(Comment commentToAdd, Vehicle vehicleToAddComment) {
        vehicleToAddComment.addComment(commentToAdd);
    }

    @Override
    public void removeComment(Comment commentToRemove, Vehicle vehicleToRemoveComment) {
        if (!username.equals(commentToRemove.getAuthor())) {
            throw new IllegalArgumentException(YOU_ARE_NOT_THE_AUTHOR);
        }
        vehicleToRemoveComment.removeComment(commentToRemove);
    }

    @Override
    public String printVehicles() {
        StringBuilder builder = new StringBuilder();

        builder.append(String.format(USER_HEADER, username)).append(System.lineSeparator());

        if (vehicles.size() == 0) {
            builder.append(NO_VEHICLES_HEADER).append(System.lineSeparator());
        } else {
            int counter = 1;
            for (Vehicle vehicle : vehicles) {
                builder.append(String.format("%d. %s", counter, vehicle.toString()))
                        .append(System.lineSeparator());
                counter++;
            }
        }

        return builder.toString().trim();
    }

    @Override
    public boolean isAdmin() {
        return userRole == UserRole.ADMIN;
    }

    @Override
    public String toString() {
        return String.format(USER_TO_STRING, username, firstName, lastName, userRole);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserImpl user = (UserImpl) o;
        return username.equals(user.username) && firstName.equals(user.firstName)
                && lastName.equals(user.lastName) && userRole == user.userRole;
    }

    private void setUsername(String username) {
        ValidationHelpers.validatePattern(username, USERNAME_REGEX_PATTERN, USERNAME_PATTERN_ERR);
        ValidationHelpers.validateIntRange(username.length(), USERNAME_LEN_MIN, USERNAME_LEN_MAX, USERNAME_LEN_ERR);
        this.username = username;
    }

    private void setFirstName(String firstName) {
        ValidationHelpers.validateIntRange(firstName.length(), FIRSTNAME_LEN_MIN, FIRSTNAME_LEN_MAX, FIRSTNAME_LEN_ERR);
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        ValidationHelpers.validateIntRange(lastName.length(), LASTNAME_LEN_MIN, LASTNAME_LEN_MAX, LASTNAME_LEN_ERR);
        this.lastName = lastName;
    }

    private void setPassword(String password) {
        ValidationHelpers.validatePattern(password, PASSWORD_REGEX_PATTERN, PASSWORD_PATTERN_ERR);
        ValidationHelpers.validateIntRange(password.length(), PASSWORD_LEN_MIN, PASSWORD_LEN_MAX, PASSWORD_LEN_ERR);
        this.password = password;
    }
}
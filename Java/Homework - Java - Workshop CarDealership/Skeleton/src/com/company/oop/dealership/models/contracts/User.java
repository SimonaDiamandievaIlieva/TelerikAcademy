package com.company.oop.dealership.models.contracts;

import com.company.oop.dealership.models.enums.UserRole;

import java.util.List;

import static java.lang.String.format;

public interface User {

    int USERNAME_LEN_MIN = 2;
    int USERNAME_LEN_MAX = 20;
    String USERNAME_REGEX_PATTERN = "^[A-Za-z0-9]+$";
    String USERNAME_PATTERN_ERR = "Username contains invalid symbols!";
    String USERNAME_LEN_ERR = format(
            "Username must be between %d and %d characters long!",
            USERNAME_LEN_MIN,
            USERNAME_LEN_MAX);

    int PASSWORD_LEN_MIN = 5;
    int PASSWORD_LEN_MAX = 30;
    String PASSWORD_REGEX_PATTERN = "^[A-Za-z0-9@*_-]+$";
    String PASSWORD_PATTERN_ERR = "Password contains invalid symbols!";
    String PASSWORD_LEN_ERR = format(
            "Password must be between %s and %s characters long!",
            PASSWORD_LEN_MIN,
            PASSWORD_LEN_MAX);

    int LASTNAME_LEN_MIN = 2;
    int LASTNAME_LEN_MAX = 20;
    String LASTNAME_LEN_ERR = format(
            "Lastname must be between %s and %s characters long!",
            LASTNAME_LEN_MIN,
            LASTNAME_LEN_MAX);

    int FIRSTNAME_LEN_MIN = 2;
    int FIRSTNAME_LEN_MAX = 20;
    String FIRSTNAME_LEN_ERR = format(
            "Firstname must be between %s and %s characters long!",
            FIRSTNAME_LEN_MIN,
            FIRSTNAME_LEN_MAX);

    String NOT_AN_VIP_USER_VEHICLES_ADD = "You are not VIP and cannot add more than %d vehicles!";
    String ADMIN_CANNOT_ADD_VEHICLES = "You are an admin and therefore cannot add vehicles!";

    String YOU_ARE_NOT_THE_AUTHOR = "You are not the author of the comment you are trying to remove!";
    String USER_TO_STRING = "Username: %s, FullName: %s %s, Role: %s";
    String NO_VEHICLES_HEADER = "--NO VEHICLES--";
    String USER_HEADER = "--USER %s--";
    int NORMAL_ROLE_VEHICLE_LIMIT = 5;

    String getUsername();

    String getFirstName();

    String getLastName();

    String getPassword();

    UserRole getRole();

    List<Vehicle> getVehicles();

    void addVehicle(Vehicle vehicle);

    void removeVehicle(Vehicle vehicle);

    void addComment(Comment commentToAdd, Vehicle vehicleToAddComment);

    void removeComment(Comment commentToRemove, Vehicle vehicleToRemoveComment);

    String printVehicles();

    boolean isAdmin();

}

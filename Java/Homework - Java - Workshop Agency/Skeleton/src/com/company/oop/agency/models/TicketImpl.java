package com.company.oop.agency.models;

import com.company.oop.agency.exceptions.InvalidUserInputException;
import com.company.oop.agency.models.contracts.Journey;

import com.company.oop.agency.models.contracts.Ticket;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;

public class TicketImpl implements Ticket {

    private int id;
    private Journey journey;
    private double administrativeCosts;
    public TicketImpl(int id, Journey journey, double administrativeCosts) {
        setJourney(journey);
        setAdministrativeCosts(administrativeCosts);
        setId(id);
    }
    private void validateAdministrativeCosts (double administrativeCosts) {
        if (administrativeCosts < 1.0) {
            throw new InvalidUserInputException(String.format("Value of 'costs' must be a positive number. " +
                            "Actual value: %.2f.", administrativeCosts) );
        }
    }
    private void setAdministrativeCosts(double administrativeCosts) {
       validateAdministrativeCosts(administrativeCosts);
        this.administrativeCosts = administrativeCosts;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setJourney(Journey journey) {
        this.journey = journey;
    }

    @Override
    public String getAsString() {
        return String.format( "Ticket ----\n" +
                "Destination: %s\n" +
                "Price: %.2f\n", journey.getDestination(), calculatePrice());
    }

    @Override
    public Journey getJourney() {
        return journey;
    }

    @Override
    public double calculatePrice() {
        return administrativeCosts * journey.calculateTravelCosts();
    }

    @Override
    public double getAdministrativeCosts() {
        return administrativeCosts;
    }
}

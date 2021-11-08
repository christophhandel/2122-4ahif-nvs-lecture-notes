package at.htl.carrental.entity;

import java.time.LocalDateTime;

public class Rental {
    private Customer customer;
    private Vehicle vehicle;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private double discount;

    //region constructors
    public Rental(Customer customer, Vehicle vehicle, LocalDateTime startDateTime, LocalDateTime endDateTime, double discount) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.discount = discount;
    }

    public Rental() {
    }
    //endregion

    //region getters and setters
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
    //endregion


    @Override
    public String toString() {
        return "Rental{" +
                "customer=" + customer +
                ", vehicle=" + vehicle +
                '}';
    }
}

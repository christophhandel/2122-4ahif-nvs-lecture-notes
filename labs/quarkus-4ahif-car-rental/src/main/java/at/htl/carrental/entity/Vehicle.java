package at.htl.carrental.entity;

public class Vehicle {

    private String brand;
    private String type;
    private double pricePerDay;

    //region Constructors


    public Vehicle(String brand, String type, double pricePerDay) {
        this.brand = brand;
        this.type = type;
        this.pricePerDay = pricePerDay;
    }

    public Vehicle() {
    }
    //endregion

    //region getters and setters
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
    //endregion

    @Override
    public String toString() {
        return "Vehicle{" +
                "brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", pricePerDay=" + pricePerDay +
                '}';
    }
}

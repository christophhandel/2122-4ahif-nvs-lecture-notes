package at.htl.carrental.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    @Test
    void createVehicle() {

        Vehicle vehicle = new Vehicle("Opel", "Kadett", 10.0);

        assertThat(vehicle.getBrand()).isEqualTo("Opel");
        assertThat(vehicle.getType()).isEqualTo("Kadett");
        assertThat(vehicle.getPricePerDay()).isEqualTo(10.0);

    }
}
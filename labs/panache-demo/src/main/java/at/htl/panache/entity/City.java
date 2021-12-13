package at.htl.panache.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class City {

    @Id
    @Column(name = "C_NAME")
    String name;

    public City() {
    }

    public City(String city) {
        this.name = city;
    }

    @Override
    public String toString() {
        return name;
    }
}

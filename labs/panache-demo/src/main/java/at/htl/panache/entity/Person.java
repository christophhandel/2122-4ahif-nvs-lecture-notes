package at.htl.panache.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
public class Person extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_name")
    public City city;

    public City getCity() {
        return city;
    }


    public Person() {
        // init something
    }

    public Person(String name) {
        // this();
        this.name = name;
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return "Person: " + name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    @Override
    public String toString() {
        return String.format("%d: %s", id, name);
    }
}

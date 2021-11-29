package at.htl.cascade.entity;

import javax.persistence.*;

@Entity
public class C {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    public B b;

    public C() {
    }

    public C(B b) {
        this.b = b;
    }


    @Override
    public String toString() {
        return "C{" +
                "id=" + id +
                ", b=" + b +
                '}';
    }
}

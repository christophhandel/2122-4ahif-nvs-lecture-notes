package at.htl.cascade.entity;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "A.findByXXX",
                query = "select a from A a where a.id = :ID"
        )
})
public class A {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Override
    public String toString() {
        return "A{" +
                "id=" + id +
                '}';
    }
}

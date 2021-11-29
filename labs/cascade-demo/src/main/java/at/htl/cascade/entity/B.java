package at.htl.cascade.entity;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(
                name = "B.findByText",
                query = "select b from B b where b.text = :TEXT"
        )
})
@Entity
public class B {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        public Long id;

        @Column(unique = true)
        public String text;

        @ManyToOne(cascade = CascadeType.ALL)
        public A a;

        public B() {
        }

        public B(String text, A a) {
                this.text = text;
                this.a = a;
        }

        @Override
        public String toString() {
                return "B{" +
                        "id=" + id +
                        ", a=" + a +
                        '}';
        }
}

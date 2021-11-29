package at.htl.cascade.control;

import at.htl.cascade.entity.A;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ARepository implements PanacheRepository<A> {

    public A save() {

        return null;

    }

}

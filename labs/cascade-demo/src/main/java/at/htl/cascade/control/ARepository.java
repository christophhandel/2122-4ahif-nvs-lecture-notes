package at.htl.cascade.control;

import at.htl.cascade.entity.A;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class ARepository implements PanacheRepository<A> {

    @Inject
    EntityManager em;

    @Transactional
    public A save(A a) {

        return em.merge(a);

    }

}

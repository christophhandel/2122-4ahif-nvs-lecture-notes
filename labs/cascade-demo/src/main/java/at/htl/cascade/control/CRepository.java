package at.htl.cascade.control;

import at.htl.cascade.entity.B;
import at.htl.cascade.entity.C;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class CRepository implements PanacheRepository<C> {

    @Inject
    EntityManager em;

    @Inject
    BRepository bRepository;

    public C save(C c) {

        B existingB = bRepository.findByText(c.b.text);

        if (existingB == null) {
            c.b = bRepository.save(c.b);
        } else {
            c.b = existingB;
        }
        return em.merge(c);
    }

}

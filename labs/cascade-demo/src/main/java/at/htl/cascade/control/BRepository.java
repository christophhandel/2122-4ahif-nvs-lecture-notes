package at.htl.cascade.control;

import at.htl.cascade.entity.B;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@ApplicationScoped
public class BRepository implements PanacheRepository<B> {

    @Inject
    EntityManager em;

    @Transactional
    public B save(B b) {
        return em.merge(b);
    }

    public B findByText(String text) {

        TypedQuery<B> query = em
                .createNamedQuery("B.findByText", B.class)
                .setParameter("TEXT", text);
        return query.getSingleResult();

    }

}

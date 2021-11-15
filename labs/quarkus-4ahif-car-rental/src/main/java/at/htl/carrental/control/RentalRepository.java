package at.htl.carrental.control;

import at.htl.carrental.entity.Rental;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class RentalRepository {

    @Inject
    EntityManager em;

    @Transactional
    public Rental save(Rental rental) {
        return em.merge(rental);
    }

}

package at.htl.panache.control;

import at.htl.panache.entity.Person;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {


    //@Transactional
    public Person save(Person person) {
        return getEntityManager().merge(person);
        //persist(person);
    }



}

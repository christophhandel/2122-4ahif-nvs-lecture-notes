package at.htl.carrental.control;

import at.htl.carrental.entity.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.clearProperty;
import static java.lang.System.out;

@ApplicationScoped
public class PersonRepository {

    @Inject
    EntityManager em;

    @Transactional
    public Person save(
            Person person
    ) {
        return em.merge(person);
    }

    public List<Person> findAll() {
        TypedQuery<Person> query = em.createNamedQuery("Person.findAll", Person.class);
        List<Person> persons = query.getResultList();
        persons.forEach(out::println);
        return persons;
    }

    public Person findByName(String name) {
        TypedQuery<Person> query = em
                .createNamedQuery("Person.findByName", Person.class)
                .setParameter("NAME", name);
        return query.getSingleResult();
    }

    public Map<Character, Integer> countByInitial() {
        Map<Character, Integer> result = new HashMap<>();
        Query query = em
                .createNamedQuery("Person.countByInital");
        List<Object[]> initials = query.getResultList();
        for (Object[] initial : initials) {
            result.put(
                    initial[0].toString().charAt(0),
                    Integer.parseInt(initial[1].toString())
            );
        }
        return result;
    }
}

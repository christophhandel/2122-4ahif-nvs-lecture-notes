package at.htl.carrental.entity;

import at.htl.carrental.control.PersonRepository;
import io.quarkus.test.junit.QuarkusTest;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class PersonTest {

    @Inject
    Logger logger;

    @Inject
    EntityManager em;

    @Inject
    PersonRepository personRepository;

    @Test
    void createPerson() {
        Person darius = new Person("Daräus");
//        em.persist(darius);
//        em.persist(new Person("Meister Handel"));
        Person p2 = personRepository.save(darius);
        System.out.println(p2);
        fail();
    }

    @Test
    void getAllPersons() {
        TypedQuery<Person> query = em
                .createNamedQuery("Person.findAll",Person.class);
        List<Person> persons = query.getResultList();
        assertThat(persons.size()).isEqualTo(8);
        logger.info(persons);
    }

    @Test
    void getAllPersonsWithQuery() {
        TypedQuery<Person> query = em
                .createQuery("select p from Person p",Person.class);
        List<Person> persons = query.getResultList();
        assertThat(persons.size()).isEqualTo(8);
        logger.info(persons);
    }


    @Test
    void getAllPersonsWithNativeQuery() {
        Query query = em
                .createNativeQuery("select p.id, p.name from person p");
        List<Object[]> persons = query.getResultList();
        for (Object[] elem : persons) {
            System.out.println(elem[0] + " " + elem[1]);
        }
        assertThat(persons.size()).isEqualTo(9);

    }

    @Test
    void countLetters() {

        Query query = em.createQuery("select substring(p.name,1,1), count(p) from Person p group by substring(p.name,1,1)");
        List<Object[]> list = query.getResultList();

        for (Object[] elem : list) {
            logger.info(elem[0] + " - " + elem[1]);
        }

        assertThat(list.size()).isEqualTo(8);
    }
}







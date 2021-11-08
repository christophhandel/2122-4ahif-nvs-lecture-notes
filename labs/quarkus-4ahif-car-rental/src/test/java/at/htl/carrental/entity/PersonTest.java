package at.htl.carrental.entity;

import at.htl.carrental.control.PersonRepository;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class PersonTest {

//    @Inject
//    EntityManager em;

    @Inject
    PersonRepository personRepository;

    @Test
    void createPerson() {
        Person darius = new Person("Daräus");
//        em.persist(darius);
//        em.persist(new Person("Meister Handel"));
        Person p2 = personRepository.save(darius);
        System.out.println(p2);
    }
}
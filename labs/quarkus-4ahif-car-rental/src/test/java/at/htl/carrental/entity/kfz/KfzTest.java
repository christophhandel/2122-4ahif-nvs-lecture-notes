package at.htl.carrental.entity.kfz;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class KfzTest {

    @Inject
    EntityManager em;

//    @Test
//    @Transactional
//    void createKfz() {
//        Kfz kadett = new Kfz("Opel", "Kadett");
//        em.persist(kadett);
//    }

    @Test
    @Transactional
    void createPkw() {
        Pkw ascona = new Pkw("Opel", "Ascona", false, 5);
        em.persist(ascona);
    }

    @Test
    @Transactional
    void createLkw() {

        Lkw scania = new Lkw("Scania", "1500", 8000);
        em.persist(scania);

    }














}
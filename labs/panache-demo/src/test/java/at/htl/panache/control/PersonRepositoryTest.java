package at.htl.panache.control;

import at.htl.panache.entity.Person;
import io.quarkus.test.junit.QuarkusTest;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.*;

import static org.junit.jupiter.api.Assertions.*;


@QuarkusTest
class PersonRepositoryTest {

    @Inject
    PersonRepository personRepository;

    @Inject
    Logger LOG;

    @Inject
    UserTransaction tx;

    @Test
    void createPerson() throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {
        tx.begin();
        Person susi = new Person("Susi");
        susi = personRepository.save(susi);
        susi.name = "Susanne";
        tx.commit();

        LOG.info(susi);
//        personRepository.save(susi);
//        LOG.info(susi);
    }
}
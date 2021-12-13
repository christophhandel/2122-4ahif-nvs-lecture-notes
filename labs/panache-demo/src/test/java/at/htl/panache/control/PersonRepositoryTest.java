package at.htl.panache.control;

import at.htl.panache.entity.City;
import at.htl.panache.entity.Person;
import io.agroal.api.AgroalDataSource;
import io.quarkus.test.junit.QuarkusTest;
import org.assertj.db.type.Table;
import org.glassfish.json.JsonUtil;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import javax.inject.Inject;
import javax.transaction.*;

import static org.assertj.db.api.Assertions.assertThat;
import static org.assertj.db.output.Outputs.output;
import static org.junit.jupiter.api.Assertions.*;


@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PersonRepositoryTest {

    @Inject
    PersonRepository personRepository;

    @Inject
    Logger LOG;

    @Inject
    UserTransaction tx;

    @Inject
    AgroalDataSource ds;

    @Order(1000)
    @Test
    void createPerson() throws Exception {
        tx.begin();
        Person susi = new Person("Susi");
        susi = personRepository.save(susi);
        susi.name = "Susanne";
        tx.commit();

        LOG.info(susi);
//        personRepository.save(susi);
//        LOG.info(susi);
    }

    @Order(1010)
    @Test
    void updatePerson() throws Exception {
        tx.begin();
        Person susi = personRepository.findById(1L);

        if (personRepository.isPersistent(susi)) {
            LOG.info("is in persistent contxt");
        } else {
            LOG.info("is not in persistence context");
        }
        susi.name = "Susanne Maria";
        tx.commit();
    }

    @Order(1030)
    @Test
    //@Transactional
    void updatePerson2() throws Exception {

        // arrange
        Table personTable = new Table(ds, "PERSON");
        output(personTable).toConsole();
        tx.begin();
        Person susi = personRepository.findById(1L);

        if (personRepository.isPersistent(susi)) {
            LOG.info("is in persistent contxt");
        } else {
            LOG.info("is not in persistence context");
        }

        // act
        susi.name = "Susanne Hildegard";
        tx.commit();

        // assert
        personTable = new Table(ds, "PERSON");
        output(personTable).toConsole();
        assertThat(personTable)
                .hasNumberOfRows(1)
                .row(0)
                .column("ID").value().isEqualTo(1L)
                .column("NAME").value().isEqualTo("Susanne Hildegard");
    }


    @Order(1040)
    @Test
    @Transactional
    void cascadingPersist() {

        City city = new City("Leonding");
        Person susi = personRepository.findById(1L);
        susi.city = city;

    }
}
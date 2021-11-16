package at.htl.carrental.control;

import at.htl.carrental.entity.Person;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.persistence.Query;

import java.util.List;
import java.util.Map;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class PersonRepositoryTest {

    @Inject
    PersonRepository personRepository;

    @Test
    void findAllPersons() {

        List<Person> persons = personRepository.findAll();
        assertThat(persons.size()).isEqualTo(7);

    }

    @Test
    void findPersonByName_ok() {

        Person person = personRepository.findByName("Kiki");
        assertThat(person.getName()).isEqualTo("Kiki");

    }

    @Test
    void countPersonsByInitials_ok() {

        Map<Character, Integer> result = personRepository.countByInitial();
        for (Map.Entry<Character, Integer> e : result.entrySet()) {
            out.printf("%s - %d\n", e.getKey(), e.getValue());
        }
        assertThat(result.size()).isEqualTo(4);

    }
}
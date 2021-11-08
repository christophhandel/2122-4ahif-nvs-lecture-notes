package at.htl.carrental.control;

import at.htl.carrental.entity.Person;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class InitBean {

    @Inject
    PersonRepository personRepository;

    void init(@Observes StartupEvent event) {
        Person p = new Person("Susi");
        personRepository.save(p);
    }

}

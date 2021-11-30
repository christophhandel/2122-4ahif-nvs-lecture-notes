package at.htl.carrental.boundary;

import at.htl.carrental.control.PersonRepository;
import at.htl.carrental.entity.Person;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("person")
public class PersonResource {

    @Inject
    PersonRepository personRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> findAllPersons() {
        return personRepository.findAll();
    }


}

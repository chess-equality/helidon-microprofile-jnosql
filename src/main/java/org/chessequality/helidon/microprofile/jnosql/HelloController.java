package org.chessequality.helidon.microprofile.jnosql;

import org.chessequality.helidon.microprofile.jnosql.model.Address;
import org.chessequality.helidon.microprofile.jnosql.model.Person;
import org.chessequality.helidon.microprofile.jnosql.repository.PersonRepository;
import org.chessequality.helidon.microprofile.jnosql.template.PersonTemplate;
import org.jnosql.artemis.Database;
import org.jnosql.artemis.DatabaseType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 */
@Path("/hello")
@Singleton
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @Inject
    PersonTemplate personTemplate;

    @Inject
    @Database(DatabaseType.DOCUMENT)
    private PersonRepository personRepository;

    @GET
    public String sayHello() {

        LOGGER.info("########## IN sayHello...");

        Person person1 = personTemplate.get("5e935478a5cef7f71994597b");
        if (person1 != null) {
            LOGGER.info(">>>>>>>>>> 1 person id = {}", person1.getId());
            LOGGER.info(">>>>>>>>>> 1 person name = {}", person1.getName());
            LOGGER.info(">>>>>>>>>> 1 person address = {}", person1.getAddress());
            Address address1 = person1.getAddress();
            LOGGER.info(">>>>>>>>>> 1 address number = {}", address1.getNumber());
            LOGGER.info(">>>>>>>>>> 1 address street = {}", address1.getStreet());
            LOGGER.info(">>>>>>>>>> 1 address city = {}", address1.getCity());
            LOGGER.info(">>>>>>>>>> 1 phones = {}", person1.getPhones());
        }

        Person person2 = personRepository.findById("5e935478a5cef7f71994597b").orElse(null);
        if (person2 != null) {
            LOGGER.info(">>>>>>>>>> 2 person id = {}", person2.getId());
            LOGGER.info(">>>>>>>>>> 2 person name = {}", person2.getName());
            LOGGER.info(">>>>>>>>>> 2 person address = {}", person2.getAddress());
            Address address2 = person2.getAddress();
            LOGGER.info(">>>>>>>>>> 2 address number = {}", address2.getNumber());
            LOGGER.info(">>>>>>>>>> 2 address street = {}", address2.getStreet());
            LOGGER.info(">>>>>>>>>> 2 address city = {}", address2.getCity());
            LOGGER.info(">>>>>>>>>> 2 phones = {}", person2.getPhones());
        }

        LOGGER.info("########## LEAVING sayHello...");
        return "Hello World";
    }
}

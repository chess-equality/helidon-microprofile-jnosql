package org.chessequality.helidon.microprofile.jnosql.template;

import org.chessequality.helidon.microprofile.jnosql.model.Person;
import org.jnosql.artemis.document.DocumentTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Optional;

@Singleton
public class PersonTemplate {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonTemplate.class);

    @Inject
    private DocumentTemplate documentTemplate;

    public Person get(String id) {

        LOGGER.info("########## IN get...");

        Optional<Person> person = documentTemplate.find(Person.class, id);

        LOGGER.info("########## LEAVING get...");
        return person.orElse(null);
    }
}

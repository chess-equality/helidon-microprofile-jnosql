package org.chessequality.helidon.microprofile.jnosql.repository;

import org.chessequality.helidon.microprofile.jnosql.model.Person;
import org.jnosql.artemis.Repository;

public interface PersonRepository extends Repository<Person, String> {
}

package org.chessequality.helidon.microprofile.jnosql;

import org.chessequality.helidon.microprofile.jnosql.config.ConfigTestController;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
@ApplicationPath("/data")
@ApplicationScoped
public class JNoSQLRestApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        // resources
        classes.add(HelloController.class);
        classes.add(ConfigTestController.class);
        return classes;
    }
}

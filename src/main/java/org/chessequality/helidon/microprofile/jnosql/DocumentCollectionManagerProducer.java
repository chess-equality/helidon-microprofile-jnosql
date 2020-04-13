package org.chessequality.helidon.microprofile.jnosql;

import org.jnosql.artemis.ConfigurationUnit;
import org.jnosql.diana.api.document.DocumentCollectionManager;
import org.jnosql.diana.api.document.DocumentCollectionManagerFactory;
import org.jnosql.diana.mongodb.document.MongoDBDocumentCollectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

@ApplicationScoped
public class DocumentCollectionManagerProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(DocumentCollectionManagerProducer.class);

    private static final String DATABASE = "jnosql";

    @Inject
    @ConfigurationUnit(name = "document")
    private DocumentCollectionManagerFactory<MongoDBDocumentCollectionManager> managerFactory;

    @Produces
    public DocumentCollectionManager getManager() {
        LOGGER.info("########## IN getManager...");
        return managerFactory.get(DATABASE);
    }

    @PreDestroy
    public void closeFactory() {
        LOGGER.info("########## IN closeFactory...");
        if (managerFactory != null) {
            managerFactory.close();
        }
        LOGGER.info("########## LEAVING closeFactory...");
    }
}

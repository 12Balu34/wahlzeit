package org.wahlzeit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.handlers.HandlersTestSuite;
import org.wahlzeit.model.ModelTestSuite;
import org.wahlzeit.model.persistence.PersistenceTestSuite;
import org.wahlzeit.services.ServicesTestSuite;
import org.wahlzeit.services.mailing.MailingTestSuite;
import org.wahlzeit.utils.UtilsTestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        HandlersTestSuite.class,
        ModelTestSuite.class,
        ServicesTestSuite.class,
        UtilsTestSuite.class,
        PersistenceTestSuite.class,
        MailingTestSuite.class
})
public class AllSuites {
}

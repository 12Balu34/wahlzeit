package org.wahlzeit.model;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.model.coordinates.impl.SphericCoordinate;
import org.wahlzeit.model.persistence.PersistenceTestSuite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        AccessRightsTest.class,
        SphericCoordinateTest.class,
        CartesianCoordinateTest.class,
        FlagReasonTest.class,
        GenderTest.class,
        GuestTest.class,
        LocationTest.class,
        PhotoFilterTest.class,
        TagsTest.class,
        UserStatusTest.class,
        ValueTest.class,
        PersistenceTestSuite.class,
        KanzlerPhotoTest.class,
        KanzlerPhotoFactoryTest.class,
        KanzlerPhotoManagerTest.class
})

public class ModelTestSuite {
}

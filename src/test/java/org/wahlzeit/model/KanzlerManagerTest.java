package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Test;

public class KanzlerManagerTest extends KanzlerDomainTest {

    KanzlerManager manager = KanzlerManager.getInstance();

    @Test
    public void checkSingletonInstantiation() throws Exception {
        Assert.assertNotNull(manager);
    }

    @Test
    public void createKanzlerTypeTest() throws Exception {
        KanzlerType type = new KanzlerType("verstorben");
        Assert.assertNotNull(type);
        Assert.assertEquals(type.getName(), "verstorben");
    }

    @Test (expected = IllegalArgumentException.class)
    public void createKanzlerTypeWithNullArg_shouldThrowException() throws Exception {
        KanzlerType type = new KanzlerType(null);
    }

    @Test
    public void createKanzlerTest() throws Exception {
        Kanzler schmidt = manager.createKanzler(new KanzlerType("Test"), "Helmut Schmidt", 1918, 2015, 1974, 1982, "SPD");
        Assert.assertNotNull(schmidt);
    }

    @Test (expected = IllegalArgumentException.class)
    public void createKanzlerWithNullType_shouldThrowException() throws Exception {
        manager.createKanzler(null, "Helmut Schmidt", 1918, 2015, 1974, 1982, "SPD");
    }

    @Test (expected = IllegalArgumentException.class)
    public void createKanzlerTwice_shouldThrowException() throws Exception {
        manager.createKanzler(new KanzlerType("Test"), "Helmut Kohl", 1930, 2017, 1982, 1998, "CDU");
        manager.createKanzler(new KanzlerType("Test"), "Helmut Kohl", 1930, 2017, 1982, 1998, "CDU");
    }

    @Test (expected = IllegalArgumentException.class)
    public void createKanzlerTypeTwice_shouldThrowException() throws Exception {
        manager.createKanzlerType("lebend");
        manager.createKanzlerType("lebend");
    }

}

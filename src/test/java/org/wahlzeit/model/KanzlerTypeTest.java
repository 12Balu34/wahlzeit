package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KanzlerTypeTest {

    KanzlerType superType = new KanzlerType("super");
    KanzlerType subType = new KanzlerType("sub");
    KanzlerType subSubType = new KanzlerType("sub sub");

    @Before
    public void setUp() throws Exception {
        superType.addSubType(subType);
        subType.addSubType(subSubType);
    }

    @Test
    public void checkInstantiation() throws Exception {
        Assert.assertNotNull(superType);
        Assert.assertNotNull(subType);
    }

    @Test
    public void isSubtype_shouldReturnTrue() throws Exception {
        Assert.assertTrue(superType.isSubtype(subType));
        Assert.assertTrue(subType.isSubtype(subSubType));
        Assert.assertTrue(superType.isSubtype(subSubType));
    }

    @Test (expected = IllegalArgumentException.class)
    public void instantiateNullType_shouldThrowException() throws Exception {
        new KanzlerType(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void setNullName_shouldThrowException() throws Exception {
        subSubType.setName(null);
    }
    @Test (expected = IllegalArgumentException.class)
    public void addNullSubtype_shouldThrowException() throws Exception {
        superType.addSubType(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void isSubtypeWithNullArgument_shouldThrowException() throws Exception {
        subType.isSubtype(null);
    }
}

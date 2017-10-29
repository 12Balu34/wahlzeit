package org.wahlzeit.model;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class LocationTest {

    Location location1;
    Location location2;
    Location location3;
    Object genericObject;

    @Before
    public void setUp() {

        location1 = new Location(new Coordinate(1.0, 45.0, 33.0));
        location2 = new Location(new Coordinate(1.0, 45.0, 33.0));
        location3 = new Location(new Coordinate(9.0, -9087656241.987, 42));
        genericObject = new Object();
    }

    @Test
    public void locationEqualsShouldReturnTrue () {

        Assert.assertTrue(location1.equals(location2));
        Assert.assertTrue(location2.equals(location1));
    }

    @Test
    public void locationEqualsShouldReturnFalse () {

        Assert.assertFalse(location1.equals(location3));
        Assert.assertFalse(location3.equals(location2));
        Assert.assertFalse(location3.equals(genericObject));
    }


}

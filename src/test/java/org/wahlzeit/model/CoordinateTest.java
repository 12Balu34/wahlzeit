package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test cases for the Coordinate class.
 */
public class CoordinateTest {

    private Object nullObject;
    private Coordinate nullCoord;
    private Coordinate coord1;
    private Coordinate coord2;
    private Coordinate coord3;
    private Coordinate coord4;
    private Coordinate coord5;
    private Coordinate coord6;
    private Coordinate coord7;

    @Before
    public void setUp() {

        nullObject = null;
        nullCoord = null;
        coord1 = new Coordinate(0.0, 0.0, 0.0);
        coord2 = new Coordinate(0.0, 0.0, 0.0);
        coord3 = new Coordinate(1.0, 1.0, 1.0);
        coord4 = new Coordinate(-10298, -676537.9876, 7865);
        coord5 = new Coordinate(-10298, -676537.9876, 7865);
        coord6 = new Coordinate(10298, 676537.9876, -7865);
        coord7 = new Coordinate(67, -98789, 5.0);
    }


    @Test
    public void coordinateEqualsShouldReturnTrue() {

        Assert.assertTrue(coord1.equals(coord2));
        Assert.assertTrue(coord2.equals(coord1));

        Assert.assertTrue(coord4.equals(coord5));
        Assert.assertTrue(coord5.equals(coord4));
    }

    @Test
    public void coordinateEqualsShouldReturnFalse() {

        Assert.assertFalse(coord2.equals(coord3));
        Assert.assertFalse(coord3.equals(coord2));

        Assert.assertFalse(coord5.equals(coord6));
        Assert.assertFalse(coord6.equals(coord5));
    }

    @Test
    public void coordinateIsEqualShouldReturnTrue() {

        Assert.assertTrue(coord2.isEqual(coord2));

        Assert.assertTrue(coord1.isEqual(coord2));
        Assert.assertTrue(coord2.isEqual(coord1));

        Assert.assertTrue(coord4.isEqual(coord5));
        Assert.assertTrue(coord5.isEqual(coord4));
    }

    @Test
    public void coordinateIsEqualShouldReturnFalse() {

        Assert.assertFalse(coord2.isEqual(coord3));
        Assert.assertFalse(coord3.isEqual(coord2));

        Assert.assertFalse(coord5.isEqual(coord6));
        Assert.assertFalse(coord6.isEqual(coord5));
    }

    @Test
    public void isEqualComparingToNullCoordinateShouldReturnFalse() {

        Assert.assertNotNull(coord1);
        Assert.assertFalse(coord1.isEqual(nullCoord));
    }

    @Test
    public void equalsComparingToNullCoordinateShouldReturnFalse() {

        Assert.assertNotNull(coord1);
        Assert.assertFalse(coord1.equals(nullObject));
    }


    @Test
    public void equalsComparingToNullObjectShouldReturnFalse() {

        Assert.assertNotNull(coord1);
        Assert.assertFalse(coord1.equals(nullObject));
    }

    @Test
    public void getDistanceOfEqualCoordinatesShouldReturn0() {

        Assert.assertEquals(0.0, coord1.getDistance(coord2), 0);
        Assert.assertEquals(0.0, coord2.getDistance(coord1), 0);

        Assert.assertEquals(0.0, coord4.getDistance(coord5), 0);
        Assert.assertEquals(0.0, coord5.getDistance(coord4), 0);
    }

    @Test
    public void getDistanceShouldReturnSqrt3() {

        Assert.assertEquals(Math.sqrt(3.0), coord1.getDistance(coord3), 0);
    }

    @Test
    public void getDistanceShouldReturnSqrt831486222779_4() {

        Assert.assertEquals(Math.sqrt(1831486222779.4), coord4.getDistance(coord6), 0.0001);
    }

    @Test
    public void getDistanceShouldReturnSqrt333963105497_82() {

        Assert.assertEquals(Math.sqrt(333963105497.82), coord4.getDistance(coord7), 0.0001);
    }

}

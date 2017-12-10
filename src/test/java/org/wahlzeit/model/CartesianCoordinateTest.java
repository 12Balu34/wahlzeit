/*
 * Copyright (c) 2017 by 12Balu34, https://github.com/12Balu34
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.wahlzeit.model.coordinates.impl.CartesianCoordinate;
import org.wahlzeit.model.coordinates.impl.SphericCoordinate;

/**
 * Test cases for the Coordinate class.
 */
public class CartesianCoordinateTest {

    private Object nullObject;
    private CartesianCoordinate nullCoord;
    private CartesianCoordinate coord1;
    private CartesianCoordinate coord2;
    private CartesianCoordinate coord3;
    private CartesianCoordinate coord4;
    private CartesianCoordinate coord5;
    private CartesianCoordinate coord6;
    private CartesianCoordinate coord7;

    @Before
    public void setUp() {

        nullObject = null;
        nullCoord = null;
        coord1 = new CartesianCoordinate(0.0, 0.0, 0.0);
        coord2 = new CartesianCoordinate(0.0, 0.0, 0.0);
        coord3 = new CartesianCoordinate(1.0, 1.0, 1.0);
        coord4 = new CartesianCoordinate(-10298, -676537.9876, 7865);
        coord5 = new CartesianCoordinate(-10298, -676537.9876, 7865);
        coord6 = new CartesianCoordinate(10298, 676537.9876, -7865);
        coord7 = new CartesianCoordinate(67, -98789, 5.0);
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

    @Test (expected = IllegalArgumentException.class)
    public void isEqualComparingToNullCoordinate_ShouldThrowException() throws Exception {

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

        Assert.assertEquals(0.0, coord1.getCartesianDistance(coord2), 0);
        Assert.assertEquals(0.0, coord2.getCartesianDistance(coord1), 0);

        Assert.assertEquals(0.0, coord4.getCartesianDistance(coord5), 0);
        Assert.assertEquals(0.0, coord5.getCartesianDistance(coord4), 0);
    }

    @Test
    public void getDistanceShouldReturnSqrt3() {

        Assert.assertEquals(Math.sqrt(3.0), coord1.getCartesianDistance(coord3), 0);
    }

    @Test
    public void getDistanceShouldReturnSqrt831486222779_4() {

        Assert.assertEquals(Math.sqrt(1831486222779.4), coord4.getCartesianDistance(coord6), 0.0001);
    }

    @Test
    public void getDistanceShouldReturnSqrt333963105497_82() {

        Assert.assertEquals(Math.sqrt(333963105497.82), coord4.getCartesianDistance(coord7), 0.0001);
    }

    @Test
    public void asSphericCoordinate_shouldReturnTrue() throws Exception {
        double deltaValue = 0.01;
        CartesianCoordinate cartesian = new CartesianCoordinate(98,-9890,9891823);
        //source: http://www.learningaboutelectronics.com/Articles/Cartesian-rectangular-to-spherical-coordinate-converter-calculator.php#answer
        SphericCoordinate spheric = new SphericCoordinate(0.06, -89.43, 9_891_827.94 );
        Assert.assertEquals(cartesian.asSphericCoordinate().getRadius(), spheric.getRadius(), deltaValue);
        Assert.assertEquals(cartesian.asSphericCoordinate().getLongitude(), spheric.getLongitude(), deltaValue);
        Assert.assertEquals(cartesian.asSphericCoordinate().getLatitude(), spheric.getLatitude(), deltaValue);


    }

    @Test
    public void isEqualComparingReconvertedCartesianCoordinate_shouldReturnTrue() throws Exception {

        CartesianCoordinate cartesian = new CartesianCoordinate(98,-9890,9891823);
        SphericCoordinate spheric = cartesian.asSphericCoordinate();
        CartesianCoordinate cartesianReconverted = spheric.asCartesianCoordinate();
        Assert.assertEquals(cartesianReconverted, cartesian);
    }

    @Test
    public void getDistanceOfCartesianAndSpheric_shouldReturn6378885_810032() throws Exception {
        CartesianCoordinate cartesian = new CartesianCoordinate(18,656,987);
        SphericCoordinate spheric = new SphericCoordinate(45,-75);

        cartesian.getCartesianDistance(spheric);
    }

    @Test
    public void getDistance_shouldBehaveEqually() throws Exception {
        CartesianCoordinate cartesian = new CartesianCoordinate(18,656,987);
        SphericCoordinate spheric = new SphericCoordinate(45,-75);

        Assert.assertEquals(cartesian.getDistance(spheric), spheric.getDistance(cartesian), 0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void createCartesianCoordinateWithInvalidParameters_ShouldThrowException() throws Exception {
        CartesianCoordinate cartesian = new CartesianCoordinate(Math.sqrt(-1), 1, 2);
    }


}

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
import org.junit.Test;
import org.wahlzeit.model.coordinates.impl.CartesianCoordinate;
import org.wahlzeit.model.coordinates.impl.SphericCoordinate;

public class SphericCoordinateTest {

    @Test
    public void conversionToCartesianCoordinate() throws Exception {

        Double deltaValue = 0.2;
        SphericCoordinate sphericCoordinate = new SphericCoordinate(80, 30);
        CartesianCoordinate convertedCoordinate = sphericCoordinate.asCartesianCoordinate();

        //source: http://www.learningaboutelectronics.com/Articles/Spherical-to-cartesian-rectangular-coordinate-converter-calculator.php#answer
        CartesianCoordinate cartesianCoordinate =
                new CartesianCoordinate(5_439_926.41, 3_140_742.98, 1_107_595.45);

        Assert.assertEquals(cartesianCoordinate.getX(), convertedCoordinate.getX(), deltaValue);
        Assert.assertEquals(cartesianCoordinate.getY(), convertedCoordinate.getY(), deltaValue);
        Assert.assertEquals(cartesianCoordinate.getZ(), convertedCoordinate.getZ(), deltaValue);
    }


    @Test
    public void getSphericDistance() throws Exception {

        //source: https://www.kompf.de/trekka/distance.php
        SphericCoordinate nbg = new SphericCoordinate(11.07667,49.45210);
        SphericCoordinate muc = new SphericCoordinate(11.58198,48.13513);
        SphericCoordinate nyc = new SphericCoordinate(-74.00597, 40.71278);

        //source above calculates distance in km -> division by 1000 in assert statement
        Assert.assertEquals(6396.8, nbg.getSphericDistance(nyc)/1000,0.1);
        Assert.assertEquals(151.2, nbg.getSphericDistance(muc)/1000,0.1);

    }

    @Test
    public void getCartesianDistance() throws Exception {

        SphericCoordinate dublin = new SphericCoordinate(-6.24889,53.33306);
        SphericCoordinate como = new SphericCoordinate(9.0832,45.80819);
        //source: https://www.luftlinie.org/Dublin,IRL/Como,ITA
        double expectedDistance = 1_382.19;
        Assert.assertEquals(expectedDistance,dublin.getCartesianDistance(como)/1000, expectedDistance*0.3);

    }

    @Test (expected = IllegalArgumentException.class)
    public void getSphericDistanceWithDifferentRadius_ShouldThrowException() throws Exception {
        SphericCoordinate spheric1 = new SphericCoordinate(78, -46, 30000);
        SphericCoordinate spheric2 = new SphericCoordinate(78, -46, 6568);
        spheric1.getSphericDistance(spheric2);
    }

    @Test
    public void isEqualWithUnequalCoordinates_shouldReturnFalse() throws Exception {
        SphericCoordinate dublin = new SphericCoordinate(-6.24889,53.33306);
        SphericCoordinate como = new SphericCoordinate(9.0832,45.80819);

        Assert.assertFalse(como.isEqual(dublin));

    }
    @Test
    public void isEqualWithEqualCoordinates_shouldReturnTrue() throws Exception {
        SphericCoordinate dublin = new SphericCoordinate(-6.24889,53.33306);

        Assert.assertTrue(dublin.isEqual(dublin));
    }

    @Test
    public void equalsWithConvertedCoordinates_shouldReturnTrue() throws Exception {
        SphericCoordinate dublin = new SphericCoordinate(-6.24889,53.33306);
        CartesianCoordinate cartesianDublin = dublin.asCartesianCoordinate();

    }

    @Test(expected = IllegalArgumentException.class)
    public void creatingSphericCoordinatesWithInvalidArguments_shouldThrowException() throws Exception {

        SphericCoordinate spheric = new SphericCoordinate(181,-91);
    }

    @Test
    public void assertSameRadiusWithDefaultConstructor() throws Exception {

        SphericCoordinate spheric1 = new SphericCoordinate(-76,56);
        SphericCoordinate spheric2 = new SphericCoordinate(-76,56);

        Assert.assertEquals(spheric1.getRadius(), spheric2.getRadius(), 0);
    }
    @Test
    public void assertSameRadiusWithFullConstructor() throws Exception {

        SphericCoordinate spheric1 = new SphericCoordinate(-76,56, 30000);
        SphericCoordinate spheric2 = new SphericCoordinate(-76,56, 30000);

        Assert.assertEquals(spheric1.getRadius(), spheric2.getRadius(), 0);
    }
    @Test
    public void assertSameRadiusWithConvertedCoordinate() throws Exception {
        double deltaValue = 0.1;
        CartesianCoordinate cartesian = new CartesianCoordinate(3878, -897, 876);
        SphericCoordinate spheric1 = new SphericCoordinate(77.59,-13.02, 4_075.64);
        SphericCoordinate spheric2 = cartesian.asSphericCoordinate();

        Assert.assertEquals(spheric1.getLatitude(), spheric2.getLatitude(),deltaValue);
        Assert.assertEquals(spheric1.getLongitude(), spheric2.getLongitude(),deltaValue);
        Assert.assertEquals(spheric1.getRadius(), spheric2.getRadius(),deltaValue);

    }
    @Test
    public void assertSameWithReconvertedCoordinate() throws Exception {
        double deltaValue = 0.1;
        SphericCoordinate spheric = new SphericCoordinate(60,30);
        CartesianCoordinate cartesian = spheric.asCartesianCoordinate();
        SphericCoordinate reconvertedSpheric = cartesian.asSphericCoordinate();
        Assert.assertEquals(spheric.getLatitude(), reconvertedSpheric.getLatitude(),deltaValue);
        Assert.assertEquals(spheric.getLongitude(), reconvertedSpheric.getLongitude(),deltaValue);
        Assert.assertEquals(spheric.getRadius(), reconvertedSpheric.getRadius(),deltaValue);
    }
}

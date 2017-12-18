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


public class LocationTest {

    Location cartesianLocation1;
    Location cartesianLocation2;
    Location sphericLocation1;
    Location sphericLocation2;

    Location location5;
    Object genericObject;

    @Before
    public void setUp() {
        //different objects witch same coordinates
        cartesianLocation1 = new Location(CartesianCoordinate.getCartesianCoordinateInstance(1.0, 45.0, 33.0));
        cartesianLocation2 = new Location(CartesianCoordinate.getCartesianCoordinateInstance(1.0, 45.0, 33.0));

        sphericLocation1 = new Location(SphericCoordinate.getSphericCoordinateInstance(67, 78 ));
        sphericLocation2 = new Location(SphericCoordinate.getSphericCoordinateInstance(67, 78 ));

        sphericLocation1 = new Location(CartesianCoordinate.getCartesianCoordinateInstance(9.0, -9087656241.987, 42));
        genericObject = new Object();
    }


    @Test
    public void locationEqualsShouldReturnTrue() {

        Assert.assertEquals(cartesianLocation1, cartesianLocation1);
        Assert.assertEquals(sphericLocation1, sphericLocation1);

    }

    @Test
    public void locationEqualsShouldReturnFalse() {

        Assert.assertFalse(cartesianLocation1.equals(cartesianLocation2));
        Assert.assertFalse(cartesianLocation2.equals(cartesianLocation1));

        Assert.assertFalse(sphericLocation1.equals(sphericLocation2));
        Assert.assertFalse(sphericLocation2.equals(sphericLocation1));


        Assert.assertFalse(cartesianLocation1.equals(sphericLocation1));
        Assert.assertFalse(sphericLocation1.equals(cartesianLocation2));
        Assert.assertFalse(sphericLocation1.equals(genericObject));
    }


}

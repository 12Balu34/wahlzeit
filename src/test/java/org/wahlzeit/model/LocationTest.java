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


public class LocationTest {

    Location location1;
    Location location2;
    Location location3;
    Object genericObject;

    @Before
    public void setUp() {
        //different objects witch same coordinates
        location1 = new Location(new Coordinate(1.0, 45.0, 33.0));
        location2 = new Location(new Coordinate(1.0, 45.0, 33.0));

        location3 = new Location(new Coordinate(9.0, -9087656241.987, 42));
        genericObject = new Object();
    }

    @Test
    public void locationEqualsShouldReturnTrue() {

        Assert.assertEquals(location1, location1);
    }

    @Test
    public void locationEqualsShouldReturnFalse() {

        Assert.assertFalse(location1.equals(location2));
        Assert.assertFalse(location2.equals(location1));

        Assert.assertFalse(location1.equals(location3));
        Assert.assertFalse(location3.equals(location2));
        Assert.assertFalse(location3.equals(genericObject));
    }


}

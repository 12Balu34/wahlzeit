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

package org.wahlzeit.model.coordinates.impl;

import org.wahlzeit.model.coordinates.Coordinate;

public abstract class AbstractCoordinate implements Coordinate {

    protected static final double DOUBLE_COMPARISON_DELTA = 1e-6;

    /**
     * Delegates the equals method to isEqual () if the Object
     * passed is of Class Coordinate.
     * @param other
     * @return true if obj is of class Coordinate and all attributes are equal.
     */
    @Override
    public boolean equals(Object other) {

        return (other instanceof Coordinate) && this.isEqual((Coordinate) other);
    }

    @Override
    public abstract int hashCode();


    @Override
    public double getDistance(Coordinate coordinate) {
        return this.asCartesianCoordinate().getCartesianDistance(coordinate);
    }

    /**
     * Compares two double values for equality within the class' comparison delta.
     * @param firstDoubleValue
     * @param secondDoubleValue
     * @return true if the two values differ no more than the class' comparison delta
     */
    public boolean areDoublesEqual (double firstDoubleValue, double secondDoubleValue) {

        return ((Math.abs(firstDoubleValue - secondDoubleValue) < DOUBLE_COMPARISON_DELTA));
    }

    @Override
    public abstract CartesianCoordinate asCartesianCoordinate();

    @Override
    public abstract double getCartesianDistance(Coordinate coordinate);

    @Override
    public abstract SphericCoordinate asSphericCoordinate();

    @Override
    public abstract double getSphericDistance(Coordinate coordinate);

    @Override
    public abstract boolean isEqual(Coordinate coordinate);

    protected abstract void assertClassInvariants();

    protected void assertIsNonNullCoordinate (Coordinate coordinate) throws IllegalArgumentException {
        if (coordinate == null) {
            throw new IllegalArgumentException("The coordinate passed to the method was null");
        }
    }
}

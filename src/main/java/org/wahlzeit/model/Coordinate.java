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

/**
 * Class representing a three dimensional Cartesian coordinate.
 *
 * @author 12Balu34
 */
public class Coordinate {

    private double x;
    private double y;
    private double z;

    public Coordinate(double x, double y, double z) {

        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Compares this with the coordinate passed to the method.
     * @param coordinate
     * @return true if all attributes are equal and other coordinate is not null
     */
    public boolean isEqual(Coordinate coordinate) {

        if (coordinate == null) {
            return false;
        }
        return (this.x == coordinate.x) && (this.y == coordinate.y) && (this.z == coordinate.z);

    }

    /**
     * Delegates the equals method to isEqual () if the Object
     * passed is of Class Coordinate.
     * @param obj
     * @return true if obj is of class Coordinate and all attributes are equal.
     */
    @Override
    public boolean equals(Object obj) {

        return ((obj instanceof Coordinate) && (isEqual((Coordinate) obj)));
    }


    /**
     * Calculates the Euclidian between this and the
     * coordinate passed to the method.
     * @param coordinate
     * @return direct distance between two coordinates
     */
    public double getDistance(Coordinate coordinate) {

        return Math.sqrt(
                Math.pow(coordinate.x - this.x, 2.0) +
                        Math.pow(coordinate.y - this.y, 2.0) +
                        Math.pow(coordinate.z - this.z, 2.0)
        );
    }
}

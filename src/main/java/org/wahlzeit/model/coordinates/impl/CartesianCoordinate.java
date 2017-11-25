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

/**
 * Class representing a three dimensional Cartesian coordinate.
 *
 * @author 12Balu34
 */
public class CartesianCoordinate implements Coordinate {

    private static final double DELTA = 1e-6;
    private double x;
    private double y;
    private double z;

    public CartesianCoordinate(double x, double y, double z) {

        this.x = x;
        this.y = y;
        this.z = z;
    }


    /**
     * @return x value of the current coordinate
     */
    public double getX() {
        return x;
    }

    /**
     * @param x the new x value of the current coordinate
     */
    public void setX(double x) {
        this.x = x;
    }


    /**
     * @return y value of the current coordinate
     */
    public double getY() {
        return y;
    }

    /**
     * @param y the new y value of the current coordinate
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * @return z value of the current coordinate
     */
    public double getZ() {
        return z;
    }

    /**
     * @param z the new z value of the current coordinate
     */
    public void setZ(double z) {
        this.z = z;
    }

    /**
     * Compares this with the coordinate passed to the method.
     *
     * @param coordinate
     * @return true if all attributes are equal and other coordinate is not null
     */
    public boolean isEqual(Coordinate coordinate) {

        if (this == coordinate) {
            return true;
        }
        if (coordinate == null) {
            return false;
        }

        CartesianCoordinate otherCoordinate = coordinate.asCartesianCoordinate();
        return ((Math.abs(this.getX() - otherCoordinate.getX()) < DELTA)
                && (Math.abs(this.getY() - otherCoordinate.getY()) < DELTA)
                && (Math.abs(this.getZ() - otherCoordinate.getZ()) < DELTA));
    }

    /**
     * Delegates the equals method to isEqual () if the Object
     * passed is of Class Coordinate.
     * @param obj
     * @return true if obj is of class Coordinate and all attributes are equal.
     */
    @Override
    public boolean equals(Object obj) {

        return ((obj instanceof CartesianCoordinate) && (isEqual((CartesianCoordinate) obj)));
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(z);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    /**
     * Calculates the Euclidian distance between this and the
     * coordinate passed to the method.
     *
     * @param coordinate
     * @return direct distance between two coordinates
     */
    @Override
    public double getCartesianDistance (Coordinate coordinate) {

        CartesianCoordinate toCartesian = coordinate.asCartesianCoordinate();

        return Math.sqrt(
                Math.pow(toCartesian.x - this.x, 2.0) +
                        Math.pow(toCartesian.y - this.y, 2.0) +
                        Math.pow(toCartesian.z - this.z, 2.0)
        );
    }


    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        return this;
    }

    @Override
    public double getDistance (Coordinate coordinate) {
        return this.getCartesianDistance(coordinate);
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {

        double radius = Math.sqrt(Math.pow(this.getX(),2) + Math.pow(this.getY(),2) + Math.pow(this.getZ(),2));

        double longitude = Math.toDegrees(Math.acos(this.getZ()/radius));

        double latitude = Math.toDegrees(Math.atan(this.getY()/this.getX()));

        return new SphericCoordinate(longitude,latitude,radius);
    }

    @Override
    public double getSphericDistance(Coordinate coordinate) {

        return this.asSphericCoordinate().getSphericDistance(coordinate.asSphericCoordinate());
    }


}

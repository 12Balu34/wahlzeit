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

import java.util.Objects;

public class SphericCoordinate extends AbstractCoordinate {

    private double latitude;
    private double longitude;
    private double radius;

    private static final double EARTH_RADIUS_IN_METERS = 6_378_388;
    private static final double MAX_LATITUDE = 90;
    private static final double MIN_LATITUDE = - 90;
    private static final double MAX_LONGITUDE = 180;
    private static final double MIN_LONGITUDE = - 180;


    public SphericCoordinate() {
    }

    public SphericCoordinate(double longitude, double latitude, double radius) throws IllegalArgumentException {

        this.setLatitude(latitude);
        this.setLongitude(longitude);
        this.setRadius(radius);

        assertClassInvariants();
    }

    /**
     * Creates a new SphericCoordinate with Earth Radius.
     * @param latitude The latitude of the new SphericCoordinate in degrees
     * @param longitude The latitude of the new SphericCoordinate in degrees
     */
    public SphericCoordinate(double longitude, double latitude) {
        this.setLatitude(latitude);
        this.setLongitude(longitude);
        this.radius = EARTH_RADIUS_IN_METERS;

        assertClassInvariants();
    }

    public double getLatitude() {

        this.assertClassInvariants();
        return latitude;
    }
    /**
     * @param latitude the new x value of the current coordinate
     * @throws IllegalArgumentException if the parameter passed is not a valid double
     */
    public void setLatitude(double latitude) throws IllegalArgumentException {

        if (Double.isNaN(latitude)){
            throw new IllegalArgumentException("Parameter latitude is not a valid double (NaN)");
        }

        this.assertClassInvariants();
        if (latitude < MIN_LATITUDE || latitude > MAX_LATITUDE) {
            throw new IllegalArgumentException("Latitude must be between -90 and 90");
        }
        this.latitude = latitude;
        this.assertClassInvariants();
    }

    public double getLongitude() {
        this.assertClassInvariants();
        return longitude;
    }
    /**
     * @param longitude the new x value of the current coordinate
     * @throws IllegalArgumentException if the parameter passed is not a valid double
     */
    public void setLongitude(double longitude) throws IllegalArgumentException {

        if (Double.isNaN(latitude)){
            throw new IllegalArgumentException("Parameter longitude is not a valid double (NaN)");
        }
        this.assertClassInvariants();

        if (longitude < MIN_LONGITUDE || longitude > MAX_LONGITUDE) {
            throw new IllegalArgumentException("Longitude must be between -180 and 180");
        }
        this.longitude = longitude;
        this.assertClassInvariants();
    }

    public double getRadius() {
        this.assertClassInvariants();
        return radius;
    }

    /**
     * @param radius the new x value of the current coordinate
     * @throws IllegalArgumentException if the parameter passed is not a valid double
     */
    public void setRadius(double radius) throws IllegalArgumentException {
        if (Double.isNaN(radius)){
            throw new IllegalArgumentException("Parameter radius is not a valid double (NaN)");
        }

        if (radius < 0) {
            throw new IllegalArgumentException("Radius must not be smaller than zero!");
        }

        this.radius = radius;
        this.assertClassInvariants();
    }

    @Override
    public boolean isEqual(Coordinate coordinate) throws IllegalArgumentException {
        assertIsNonNullCoordinate(coordinate);
        if (this == coordinate) {
            return true;
        }

        SphericCoordinate otherCoordinate = coordinate.asSphericCoordinate();

        return areDoublesEqual(this.latitude, otherCoordinate.latitude)
                && areDoublesEqual(this.longitude, otherCoordinate.longitude )
                && areDoublesEqual(this.radius, otherCoordinate.radius);
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude, radius);
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {

        this.assertClassInvariants();

        double latitudeAsRadian = Math.toRadians(this.getLatitude());
        double longitudeAsRadian = Math.toRadians(this.getLongitude());

        double x = radius * Math.sin(longitudeAsRadian) * Math.cos(latitudeAsRadian);
        double y = radius * Math.sin(longitudeAsRadian) * Math.sin(latitudeAsRadian);
        double z = radius * Math.cos(longitudeAsRadian);

        CartesianCoordinate result = new CartesianCoordinate(x,y,z);

        result.assertClassInvariants();

        return result;

    }
    /**
     * Calculates the cartesian distance between two coordinates
     * @param coordinate
     * @return the spheric cartesian between the two coordinates
     * @throws IllegalArgumentException if the Coordinate passed is null
     */
    @Override
    public double getCartesianDistance(Coordinate coordinate) throws IllegalArgumentException {
        assertIsNonNullCoordinate(coordinate);
        this.assertClassInvariants();

        return this.asCartesianCoordinate().getCartesianDistance(coordinate);
    }


    /**
     * Calculates the spheric distance between two coordinates
     * @param coordinate
     * @return the spheric distance between the two coordinates
     * @throws IllegalArgumentException if the coordinate passed is null or the two coordinates are on different spheres
     */
    @Override
    public double getSphericDistance(Coordinate coordinate) throws IllegalArgumentException {

        assertIsNonNullCoordinate(coordinate);
        this.assertClassInvariants();

        SphericCoordinate otherCoordinate = coordinate.asSphericCoordinate();
        assertSameRadius(otherCoordinate);

        double thisLatitudeAsRadian = Math.toRadians(this.getLatitude());
        double thisLongitudeAsRadian = Math.toRadians(this.getLongitude());

        double otherLatitudeAsRadian = Math.toRadians(otherCoordinate.getLatitude());
        double otherLongitudeAsRadian = Math.toRadians(otherCoordinate.getLongitude());

        double distance = Math.acos(
                Math.sin(thisLatitudeAsRadian)* Math.sin(otherLatitudeAsRadian) +
                Math.cos(thisLatitudeAsRadian)* Math.cos(otherLatitudeAsRadian) *
                        Math.cos(otherLongitudeAsRadian - thisLongitudeAsRadian))* this.radius;
        return distance;
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        this.assertClassInvariants();
        return this;
    }


    /**
     * Checks if this Coordinate and the given one have the same radius
     * @methodtype assertion
     * @param otherCoordinate coordinate to be compared to
     */
    private void assertSameRadius (SphericCoordinate otherCoordinate) throws IllegalArgumentException {
        if (!areDoublesEqual(this.getRadius(), otherCoordinate.getRadius())) {
            throw new IllegalArgumentException("Unable to compare coordinates on different spheres");
        }
    }


    protected void assertClassInvariants() {
        assertIsNonNullCoordinate(this);

        assert !(Double.isNaN(this.latitude));
        assert !(Double.isNaN(this.longitude));
        assert !(Double.isNaN(this.radius));

        assert !(this.latitude < MIN_LATITUDE);
        assert !(this.latitude > MAX_LATITUDE);

        assert !(this.longitude < MIN_LONGITUDE);
        assert !(this.longitude > MAX_LATITUDE);

        assert !(this.radius < 0);

    }
}

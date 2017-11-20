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

public class SphericCoordinate implements Coordinate {

    private double latitude;
    private double longitude;
    private double radius;

    public static final double EARTH_RADIUS_IN_METERS = 6_378_388;
    private static final double DELTA = 1e-6;
    private static final double MAX_LATITUDE = 90;
    private static final double MIN_LATITUDE = - 90;
    private static final double MAX_LONGITUDE = 180;
    private static final double MIN_LONGITUDE = - 180;


    public SphericCoordinate() {
    }

    public SphericCoordinate(double longitude, double latitude, double radius) {
        this.setLatitude(latitude);
        this.setLongitude(longitude);
        this.setRadius(radius);
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
    }


    public double getLatitude() {
        return latitude;
    }


    public void setLatitude(double latitude) {
        if (latitude < MIN_LATITUDE || latitude > MAX_LATITUDE) {
            throw new IllegalArgumentException("Latitude must be between -90 and 90");
        }
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        if (longitude < MIN_LONGITUDE || longitude > MAX_LONGITUDE) {
            throw new IllegalArgumentException("Longitude must be between -180 and 180");
        }
        this.longitude = longitude;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {

        double latitudeAsRadian = Math.toRadians(this.getLatitude());
        double longitudeAsRadian = Math.toRadians(this.getLongitude());

        double x = radius * Math.sin(longitudeAsRadian) * Math.cos(latitudeAsRadian);
        double y = radius * Math.sin(longitudeAsRadian) * Math.sin(latitudeAsRadian);
        double z = radius * Math.cos(longitudeAsRadian);

        return new CartesianCoordinate(x,y,z);

    }

    @Override
    public double getCartesianDistance(Coordinate coordinate) {

        return this.asCartesianCoordinate().getDistance(coordinate.asCartesianCoordinate());
    }

    @Override
    public double getDistance(Coordinate coordinate) {
        return this.getCartesianDistance(coordinate);
    }


    /**
     * Calculates the spheric distance between two coordinates
     * @param coordinate
     * @return The spheric distance between two coordinates in m
     */
    @Override
    public double getSphericDistance(Coordinate coordinate) {

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
        return this;
    }

    @Override
    public boolean isEqual(Coordinate coordinate) {

        if (this == coordinate) {
            return true;
        }
        if (coordinate == null) {
            return false;
        }

        SphericCoordinate otherCoordinate = coordinate.asSphericCoordinate();
        return Double.compare(otherCoordinate.latitude, this.latitude) == 0 &&
                Double.compare(otherCoordinate.longitude, this.longitude) == 0 &&
                Double.compare(otherCoordinate.radius, this.radius) == 0;
    }

    @Override
    public boolean equals(Object other) {

        return other instanceof Coordinate && this.isEqual((Coordinate)other);
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude, radius);
    }

    /**
     * Checks if this Coordinate and the given one have the same radius
     * @methodtype assertion
     * @param otherCoordinate coordinate to be compared to
     */
    private void assertSameRadius (SphericCoordinate otherCoordinate) {
        if (this.getRadius() - otherCoordinate.getRadius() > DELTA) {
            throw new IllegalArgumentException("Unable to compare coordinates on different spheres");
        }
    }
}

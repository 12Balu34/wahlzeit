package org.wahlzeit.model;

public class Location {

    public Coordinate coordinate;

    public Location(Coordinate coordinate) {

        this.coordinate = coordinate;
    }

    @Override
    public boolean equals(Object obj) {

        return (obj instanceof Location && this.coordinate.equals(((Location) obj).coordinate));
    }
}



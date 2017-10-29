package org.wahlzeit.model;

/**
 * Class representing a location
 * @author 12Balu34
 */
public class Location {

    public Coordinate coordinate;

    public Location(Coordinate coordinate) {

        this.coordinate = coordinate;
    }

    /**
     * Delegates the equals method to the equals method of the Coordinate class
     * if the Object passed is of Class Location.
     * @param obj
     * @return true if obj is of class Location and all attributes are equal.
     */
    @Override
    public boolean equals(Object obj) {

        return (obj instanceof Location && this.coordinate.equals(((Location) obj).coordinate));
    }
}



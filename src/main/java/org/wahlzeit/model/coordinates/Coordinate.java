package org.wahlzeit.model.coordinates;

import org.wahlzeit.model.coordinates.impl.CartesianCoordinate;
import org.wahlzeit.model.coordinates.impl.SphericCoordinate;

public interface Coordinate {

    public CartesianCoordinate asCartesianCoordinate();
    public double getCartesianDistance(Coordinate coordinate);
    public SphericCoordinate asSphericCoordinate();
    public double getSphericDistance(Coordinate coordinate);
    public double getDistance(Coordinate coordinate);
    public boolean isEqual (Coordinate coordinate);

}

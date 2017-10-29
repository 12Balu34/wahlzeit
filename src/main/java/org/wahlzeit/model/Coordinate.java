package org.wahlzeit.model;

public class Coordinate {

    private double x;
    private double y;
    private double z;

    public Coordinate(double x, double y, double z) {

        this.x = x;
        this.y = y;
        this.z = z;
    }

    public boolean isEqual(Coordinate coordinate) {

        if (coordinate == null) {
            return false;
        }
        return (this.x == coordinate.x) && (this.y == coordinate.y) && (this.z == coordinate.z);

    }

    @Override
    public boolean equals(Object obj) {
        return ((obj instanceof Coordinate) && (isEqual((Coordinate) obj)));
    }


    public double getDistance(Coordinate coordinate) {

        return Math.sqrt(
                Math.pow(coordinate.x - this.x, 2.0) +
                        Math.pow(coordinate.y - this.y, 2.0) +
                        Math.pow(coordinate.z - this.z, 2.0)
        );
    }
}

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



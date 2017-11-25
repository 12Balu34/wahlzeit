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

import org.wahlzeit.model.coordinates.Coordinate;
import org.wahlzeit.model.coordinates.impl.CartesianCoordinate;

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
     * @return current coordinate
     */
    public Coordinate getCoordinate() {
        return coordinate;
    }

    /**
     * @param coordinate instance of Coordinate to be set
     */
    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
}



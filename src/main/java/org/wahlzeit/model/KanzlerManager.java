/*
 * Copyright (c) 2018 by 12Balu34, https://github.com/12Balu34
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

import org.wahlzeit.services.ObjectManager;
import java.util.HashMap;
import java.util.Map;

public class KanzlerManager extends ObjectManager {

    private static final KanzlerManager kanzlerManager = new KanzlerManager();
    private static final Map<String, KanzlerType> kanzlerTypeMap = new HashMap<>();
    private static final Map<String, Kanzler> kanzlerMap = new HashMap<>();

    private KanzlerManager () {

    }
    /**
     * /**
     * Public singleton access method.
     * @return Singleton Instance of KanzlerManager
     */
    public static KanzlerManager getInstance () {
        return kanzlerManager;
    }

    /**
     * @param type
     * @param name
     * @param yearOfBirth
     * @param yearOfDeath
     * @param yearEnteringOffice
     * @param yearLeavingOffice
     * @param party
     * @return Kanzler with the specified values
     */
    public Kanzler createKanzler (KanzlerType type, String name, int yearOfBirth, int yearOfDeath, int yearEnteringOffice, int yearLeavingOffice, String party) {
        assertIsValidType(type);
        if (existsKanzler(name)) {
            return kanzlerMap.get(name);
        }
        if ( !(existsKanzlerType(type.getName())) ) {
            kanzlerTypeMap.put(type.getName(), type);
        }
        Kanzler result = new Kanzler(type, name, yearOfBirth, yearOfDeath, yearEnteringOffice, yearLeavingOffice, party);
        kanzlerMap.put(name, result);
        return result;
    }

    /**
     * @param typeName
     * @return KanzlerType with the specified typeName
     */
    public KanzlerType createKanzlerType (String typeName) {
       if (existsKanzlerType(typeName)) {
           return kanzlerTypeMap.get(typeName);
       }
       KanzlerType result = new KanzlerType(typeName);
       kanzlerTypeMap.put(typeName, result);
       return result;
    }

    /**
     * Ensures that the type passed is valid
     * @param type
     */
    public void assertIsValidType (KanzlerType type) {
        if (type == null) {
            throw new IllegalArgumentException("Type passed to the method was null!");
        }
    }

    /**
     * Checks if the KanzlerType is already contained in the Map
     * @param name
     * @return True if the KanzlerType already exists
     * @methodtype boolean query
     */
    private boolean existsKanzlerType(String name) {
        return kanzlerTypeMap.containsKey(name);
    }

    /**
     * Checks if the Kanzler is already contained in the Map
     * @param name
     * @return True if the Kanzler already exists
     * @methodtype boolean query
     */
    private boolean existsKanzler(String name) {
        return kanzlerMap.containsKey(name);
    }

}

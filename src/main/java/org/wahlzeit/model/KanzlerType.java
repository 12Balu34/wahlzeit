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

import org.wahlzeit.services.DataObject;
import java.util.HashSet;
import java.util.Set;


public class KanzlerType extends DataObject{

    private String name;
    private KanzlerType superType = null;
    private Set<KanzlerType> subTypes = new HashSet<>();

    public KanzlerType (String name) {
        assertValidaName(name);
        this.name = name;
    }

    /**
     * @param superType
     * @methodtype set
     */
    private void setSuperType(KanzlerType superType) {
        this.superType = superType;
    }

    /**
     * @return superType
     * @methodtype get
     */
    public KanzlerType getSuperType () {
        return superType;
    }

    /**
     * Adds the kanzlerType passed to the method as a subType of this.
     * @param kanzlerType
     */
    protected void addSubType(KanzlerType kanzlerType) {
        if (kanzlerType == null) {
            throw new IllegalArgumentException("Tried to add a null subtype");
        }
        kanzlerType.setSuperType(this);
        subTypes.add(kanzlerType);
    }

    /**
     * Checks if the kanzlerType passed to the method is a subtype of this.
     * @param kanzlerType
     * @return True if the kanzlerType passed to the method is a subtype of this.
     */
    public boolean isSubtype (KanzlerType kanzlerType) {
        if (kanzlerType == null) {
            throw new IllegalArgumentException("Tried to retrieve information about null object");
        }
        if (kanzlerType == this) {
            return true;
        }

        for (KanzlerType type : subTypes) {
            if (type.isSubtype(kanzlerType)) {
                return true;
            }
        }
        return false;

    }

    /**
     * @param name
     * @methodtype set
     */
    public void setName(String name) {
        if (name==null) {
            throw new IllegalArgumentException("The type's name cannot be null! ");
        }
        this.name = name;
    }

    /**
     * @return name
     * @methodtype get
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the immediate subtypes of this.
     * @return subTypes
     * @methodtype get
     */
    public Set<KanzlerType> getSubTypes() {
        return subTypes;
    }

    private void assertValidaName (String name) {
        if (name==null) {
            throw new IllegalArgumentException("The type's name cannot be null! ");
        }
    }
}

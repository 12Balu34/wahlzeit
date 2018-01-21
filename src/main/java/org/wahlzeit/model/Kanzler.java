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

/**=======================================================================================================================
 * ||                                              Comments for adap-cw13                                               ||
 * =======================================================================================================================
 *  Sequence of method calls that lead to the new object                                                                *
 *      - KanzlerManager accessed via createKanzler createKanzler (KanzlerType type, String name, int yearOfBirth,      *
 *                                      int yearOfDeath, int yearEnteringOffice, int yearLeavingOffice, String party)   *
 *                                                                                                                      *
 *      - In createKanzler, Kanzler is created via Kanzler result = new Kanzler(type, name, yearOfBirth, yearOfDeath,   *
 *                                      yearEnteringOffice, yearLeavingOffice, party)                                   *
 *                                                                                                                      *
 *      - New object is returned                                                                                        *
 * _______________________________________________________________________________________________________________________
 * Object creation six-tuple                                                                                            *
 *      1. Delegation of object creation                                                                                *
 *         - by delegating to a seperate-object; KanzlerManager creates Kanzler objects                                 *
 *      2. Selection of concrete class                                                                                  *
 *         - On-the-spot; it is hard-coded to return a new Kanzler                                                      *
 *      3. Configuration of class mapping                                                                               *
 *         - N/A here                                                                                                   *
 *      4. Instantiation of concrete class                                                                              *
 *         - In-code; constructor is called directly via new                                                            *
 *      5. Initialization of new Object                                                                                 *
 *         - By-fixed-signature; field assignment fixed                                                                 *
 *      6. Building of object structure                                                                                 *
 *         - N/A                                                                                                    *
 * =======================================================================================================================
 */

package org.wahlzeit.model;

import org.wahlzeit.services.DataObject;

public class Kanzler extends DataObject {

    private KanzlerType type;
    private String name;
    private int yearOfBirth;
    private int yearOfDeath;
    private int yearEnteringOffice;
    private int yearLeavingOffice;
    private String party;


    /**
     * @param type
     * @param name
     * @param yearOfBirth
     * @param yearOfDeath
     * @param yearEnteringOffice
     * @param yearLeavingOffice
     * @param party
     */
    public Kanzler (KanzlerType type, String name, int yearOfBirth, int yearOfDeath, int yearEnteringOffice, int yearLeavingOffice, String party) {
        this.type = type;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.yearOfDeath = yearOfDeath;
        this.yearEnteringOffice = yearEnteringOffice;
        this.yearLeavingOffice = yearLeavingOffice;
        this.party = party;
    }


    /**
     * @return type
     * @methodtype get
     */
    public KanzlerType getType() {
        return this.type;
    }

    /**
     * @methodtype set
     */
    public void setType(KanzlerType type) {
        this.type = type;
    }

    /**
     * @return name
     * @methodtype get
     */
    public String getName() {
        return this.name;
    }
    /**
     * @methodtype set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return yearOfBirth
     * @methodtype get
     */
    public int getYearOfBirth() {
        return yearOfBirth;
    }
    /**
     * @methodtype set
     */
    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    /**
     * @return yearOfDeath
     * @methodtype get
     */
    public int getYearOfDeath() {
        return yearOfDeath;
    }
    /**
     * @methodtype set
     */
    public void setYearOfDeath(int yearOfDeath) {
        this.yearOfDeath = yearOfDeath;
    }

    /**
     * @return yearEnteringOffice
     * @methodtype get
     */
    public int getYearEnteringOffice() {
        return yearEnteringOffice;
    }

    /**
     * @methodtype set
     */
    public void setYearEnteringOffice(int yearEnteringOffice) {
        this.yearEnteringOffice = yearEnteringOffice;
    }

    /**
     * @return yearLeavingOffice
     * @methodtype get
     */
    public int getYearLeavingOffice() {
        return yearLeavingOffice;
    }

    /**
     * @methodtype set
     */
    public void setYearLeavingOffice(int yearLeavingOffice) {
        this.yearLeavingOffice = yearLeavingOffice;
    }

    /**
     * @return party
     * @methodtype get
     */
    public String getParty() {
        return party;
    }

    /**
     * @methodtype set
     */
    public void setParty(String party) {
        this.party = party;
    }

}

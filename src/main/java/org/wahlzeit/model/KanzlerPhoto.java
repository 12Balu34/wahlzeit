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
 *      - a KanzlerPhotoFactory and KanzlerPhotoManager is instantiated via startUp(String rootDir) in ModelMain        *
 *        (via PhotoManager.getInstance().init() and PhotoFactory.getInstance() )                                       *
 *      - doHandlePost (UserSession us, Map args) in UploadPhotoFormHandler accesses the creation method in             *
 *        PhotoManager via Photo photo = pm.createPhoto(fileName, uploadedImage);                                       *                               *
 *      - createPhoto(String filename, Image uploadedImage) is inherited from PhotoManager                              *
 *      - createPhoto calls the PhotoUtil via PhotoUtil.createPhoto(filename, id, uploadedImage)                        *                                                                                                                 *
 *      - there, the KanzlerPhoto is created via Photo result = PhotoFactory.getInstance().createPhoto(id)              *
 *      - as the PhotoFactory instance is a KanzlerPhotoFactory object, the createPhoto (PhotoId id)                    *
 *        KanzlerPhotoFactory is called                                                                                 *
 *      - this creates the KanzlerPhoto via the constructor new KanzlerPhoto(id)                                        *
 *      - the constructor calls the constructor of the super-class via super(myId)                                      *
 *      - the constructor of the super-class sets the id and increments the writeCount inherited from DataObject        *
 * ________________________________________________________________________________________________________________
 * Object creation six-tuple                                                                                            *
 *      1. Delegation of object creation                                                                                *
 *         - separate-object; created via KanzlerPhotoManager and -Factory                                              *
 *      2. Selection of concrete class                                                                                  *
 *         - By-subclassing; KanzlerPhotoFactory is subtype of PhotoFactory                                             *
 *      3. Configuration of class mapping                                                                               *
 *         - N/A here                                                                                                   *
 *      4. Instantiation of concrete class                                                                              *
 *         - In-code; constructor directly called via new                                                               *
 *      5. Initialization of new Object                                                                                 *
 *         - By-key-value-pair; there are constructor which take different sets of arguments                            *
 *      6. Building of object structure                                                                                 *
 *         - Default; KanzlerPhoto builds structure itself                                                              *
 * =======================================================================================================================
 */
package org.wahlzeit.model;


import com.googlecode.objectify.annotation.Serialize;
import com.googlecode.objectify.annotation.Subclass;

@Subclass
public class KanzlerPhoto extends Photo {

    @Serialize
    private Kanzler kanzler;

    public KanzlerPhoto() {
        super();

    }

    public KanzlerPhoto(Kanzler kanzler) {
        super();
        this.kanzler = kanzler;
    }

    public KanzlerPhoto(PhotoId myId) {
        super(myId);
    }

    public Kanzler getKanzler() {
        return kanzler;
    }

    public void setKanzler(Kanzler kanzler) {
        this.kanzler = kanzler;
    }
}

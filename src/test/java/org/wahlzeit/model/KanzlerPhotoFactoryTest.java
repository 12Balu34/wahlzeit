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

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KanzlerPhotoFactoryTest extends KanzlerDomainTest {

    private KanzlerPhotoFactory factory;

    @Before
    public void setUp() throws Exception {
        factory = KanzlerPhotoFactory.getInstance();
    }

    @Test
    public void checkInstantiation() throws Exception {

        Assert.assertFalse(factory.getClass().equals(PhotoFactory.class));
        Assert.assertTrue(factory.getClass().equals(KanzlerPhotoFactory.class));
    }

    @Test
    public void createPhotoWithoutArguments_ShouldReturnKanzlerPhoto() throws Exception {


        KanzlerPhoto kanzler = factory.createPhoto();

        Assert.assertFalse(kanzler.getClass().equals(Photo.class));
        Assert.assertTrue(kanzler.getClass().equals(KanzlerPhoto.class));
    }

    @Test
    public void createPhotoWithId_ShouldReturnKanzlerPhoto() throws Exception {
        PhotoId id = new PhotoId(4711);
        KanzlerPhoto kanzler = factory.createPhoto(id);

        Assert.assertFalse(kanzler.getClass().equals(Photo.class));
        Assert.assertTrue(kanzler.getClass().equals(KanzlerPhoto.class));
        Assert.assertEquals(4711, kanzler.id.asInt());
    }
}

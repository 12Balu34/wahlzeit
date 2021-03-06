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
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;
import org.wahlzeit.testEnvironmentProvider.RegisteredOfyEnvironmentProvider;

public class KanzlerPhotoTest extends KanzlerDomainTest {

    Kanzler kanzler;
    KanzlerPhoto kanzlerPhoto;


    @Before
    public void setUp() throws Exception {
        kanzler = new Kanzler(null, "Helmut Schmidt", 1918, 2015, 1974, 1982, "SPD");
        kanzlerPhoto = new KanzlerPhoto(kanzler);
    }

    @Test
    public void checkNotNullAfterInstantiation_emptyConstructor() throws Exception {

        KanzlerPhoto kanzlerPhoto = new KanzlerPhoto();
        Assert.assertNotNull(kanzlerPhoto);
    }

    @Test
    public void checkNotNullAfterInstantiation_fullConstructor() throws Exception {

        Assert.assertNotNull(kanzlerPhoto);
    }

    @Test
    public void testGetter() throws Exception {
        Assert.assertEquals(kanzlerPhoto.getKanzler(), kanzler);
    }

    @Test
    public void testSetter() throws Exception {
        KanzlerPhoto emptyPhoto = new KanzlerPhoto();
        emptyPhoto.setKanzler(kanzler);
        Assert.assertEquals(emptyPhoto.getKanzler(), kanzler);
    }
}

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

public class KanzlerPhotoManagerTest extends KanzlerDomainTest {

    private PhotoManager manager;
    private Kanzler kanzler;
    private KanzlerPhoto kanzlerPhoto;

    @Before
    public void setUp() throws Exception {

        manager = PhotoManager.getInstance();
        kanzler = new Kanzler(null, "Helmut Schmidt", 1918, 2015, 1974, 1982, "SPD");
        kanzlerPhoto = new KanzlerPhoto(kanzler);
    }

    @Test
    public void checkInstantiation() throws Exception {

        Assert.assertNotNull(manager);
        Assert.assertFalse(manager.getClass().equals(PhotoManager.class));
        Assert.assertTrue(manager.getClass().equals(KanzlerPhotoManager.class));
    }

    @Test
    public void testPersistence() throws Exception {
        manager.addPhoto(kanzlerPhoto);
        KanzlerPhoto persistedKanzler = (KanzlerPhoto) manager.getPhoto(kanzlerPhoto.id);

        Assert.assertEquals(kanzler.getName(), persistedKanzler.getKanzler().getName());
        Assert.assertEquals(kanzler.getYearOfBirth(), persistedKanzler.getKanzler().getYearOfBirth());
        Assert.assertEquals(kanzler.getYearOfDeath(), persistedKanzler.getKanzler().getYearOfDeath());
        Assert.assertEquals(kanzler.getYearEnteringOffice(), persistedKanzler.getKanzler().getYearEnteringOffice());
        Assert.assertEquals(kanzler.getYearLeavingOffice(), persistedKanzler.getKanzler().getYearLeavingOffice());
        Assert.assertEquals(kanzler.getParty(), persistedKanzler.getKanzler().getParty());
    }
}

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

    KanzlerPhoto kanzler;


    @Before
    public void setUp() throws Exception {
        kanzler = new KanzlerPhoto("Helmut Schmidt", 1918, 2015, 1974, 1982, "SPD");

    }

    @Test
    public void checkNotNullAfterInstantiation_emptyConstructor() throws Exception {

        KanzlerPhoto kanzler = new KanzlerPhoto();
        Assert.assertNotNull(kanzler);
    }

    @Test
    public void checkNotNullAfterInstantiation_idConstructor() throws Exception {

        KanzlerPhoto kanzler = new KanzlerPhoto(null);
        Assert.assertNotNull(kanzler);
    }

    @Test
    public void checkNotNullAfterInstantiation_fullConstructor() throws Exception {

        Assert.assertNotNull(kanzler);
    }

    @Test
    public void testGetters() throws Exception {

        Assert.assertTrue(kanzler.getName() == "Helmut Schmidt");
        Assert.assertTrue(kanzler.getParty() == "SPD");
        Assert.assertTrue(kanzler.getYearEnteringOffice() == 1974);
        Assert.assertTrue(kanzler.getYearLeavingOffice() == 1982);
        Assert.assertTrue(kanzler.getYearOfBirth() == 1918);
        Assert.assertTrue(kanzler.getYearOfDeath() == 2015);
    }
}

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

import org.wahlzeit.services.LogBuilder;

import java.util.logging.Logger;

/**
 * A photo manager provides access to and manages photos.
 */
public class KanzlerPhotoManager extends PhotoManager {

	/**
	 *
	 */
	protected static KanzlerPhotoManager instance;

	private static final Logger log = Logger.getLogger(KanzlerPhotoManager.class.getName());

	/**
	 *
	 */
	public KanzlerPhotoManager() {
		super();
	}

	/**
	 *
	 */
	public static KanzlerPhotoManager getInstance() {
		if (instance == null) {
			log.config(LogBuilder.createSystemMessage().addAction("Instantiating KanzlerPhotoManager").toString());
			instance = new KanzlerPhotoManager();
		}
		return instance;
	}

	public static void setInstance (KanzlerPhotoManager kanzlerPhotoManager) {
		if (instance != null) {
			throw new IllegalStateException("attempt to initialize KanzlerPhotoManager twice");
		}
		instance = kanzlerPhotoManager;
	}

}

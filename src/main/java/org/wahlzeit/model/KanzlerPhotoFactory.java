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
 * An Abstract Factory for creating photos and related objects.
 */
public class KanzlerPhotoFactory extends PhotoFactory {

	private static final Logger log = Logger.getLogger(KanzlerPhotoFactory.class.getName());
	/**
	 * Hidden singleton instance; needs to be initialized from the outside.
	 */
	private static KanzlerPhotoFactory instance = null;

	/**
	 *
	 */
	protected KanzlerPhotoFactory() {
		// do nothing
	}

	/**
	 * Hidden singleton instance; needs to be initialized from the outside.
	 */
	public static void initialize() {
		getInstance(); // drops result due to getInstance() side-effects
	}

	/**
	 * Public singleton access method.
	 */
	public static synchronized KanzlerPhotoFactory getInstance() {
		if (instance == null) {
			log.config(LogBuilder.createSystemMessage().addAction("setting generic KanzlerPhotoFactory").toString());
			setInstance(new KanzlerPhotoFactory());
		}

		return instance;
	}

	/**
	 * Method to set the singleton instance of PhotoFactory.
	 */
	protected static synchronized void setInstance(KanzlerPhotoFactory kanzlerPhotoFactory) {
		if (instance != null) {
			throw new IllegalStateException("attempt to initialize KanzlerPhotoFactory twice");
		}

		instance = kanzlerPhotoFactory;
	}

	/**
	 * @methodtype factory
	 */
	public KanzlerPhoto createPhoto() {
		return new KanzlerPhoto();
	}

	/**
	 * Creates a new KanzlerPhoto with the specified id
	 */
	public KanzlerPhoto createPhoto(PhotoId id) {
		return new KanzlerPhoto(id);
	}


}

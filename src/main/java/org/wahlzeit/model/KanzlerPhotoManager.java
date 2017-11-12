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

import com.google.appengine.api.images.Image;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Work;
import org.wahlzeit.model.persistence.ImageStorage;
import org.wahlzeit.services.LogBuilder;
import org.wahlzeit.services.ObjectManager;
import org.wahlzeit.services.Persistent;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.logging.Logger;

/**
 * A photo manager provides access to and manages photos.
 */
public class KanzlerPhotoManager extends PhotoManager {

	/**
	 *
	 */
	protected static final KanzlerPhotoManager instance = new KanzlerPhotoManager();

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
		return instance;
	}

	/**
	 *
	 */
	/**
	 *
	 */
	public Photo getPhoto(PhotoId id) {
		return instance.getPhotoFromId(id);
	}

	/**
	 *
	 */
	public Photo getPhotoFromId(PhotoId id) {
		if (id == null) {
			return null;
		}

		Photo result = doGetPhotoFromId(id);

		if (result == null) {
			result = KanzlerPhotoFactory.getInstance().loadPhoto(id);
			if (result != null) {
				doAddPhoto(result);
			}
		}

		return result;
	}

}

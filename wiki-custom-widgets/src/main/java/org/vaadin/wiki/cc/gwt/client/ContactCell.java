/*
 * Copyright 2010 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.vaadin.wiki.cc.gwt.client;

import org.vaadin.wiki.cc.gwt.client.ContactDatabase.ContactInfo;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.AbstractImagePrototype;

/**
 * Extracted from CwCellList.java
 */
public class ContactCell extends AbstractCell<ContactInfo> {

	/**
	 * The html of the image used for contacts.
	 */
	private final String imageHtml;

	public ContactCell(ImageResource image) {
		if (image != null) {
			this.imageHtml = AbstractImagePrototype.create(image).getHTML();
		}
		else {
			this.imageHtml = "https://secure.gravatar.com/avatar/64f96f4ad654f4dda900c5cb4ca29b1b?d=https%3A%2F%2Fdwz7u9t8u8usb.cloudfront.net%2Fm%2F17d71960eb2d%2Fimg%2Fdefault_avatar%2F96%2Fuser_blue.png&s=96";
		}
	}

	@Override
	public void render(Context context, ContactInfo value, SafeHtmlBuilder sb) {
		// Value can be null, so do a null check..
		if (value == null) {
			return;
		}

		sb.appendHtmlConstant("<table>");

		// Add the contact image.
		sb.appendHtmlConstant("<tr><td rowspan='3'>");
		// sb.appendHtmlConstant(imageHtml);
		sb.appendHtmlConstant("</td>");

		// Add the name and address.
		sb.appendHtmlConstant("<td style='font-size:95%;'>");
		sb.appendEscaped(value.getFullName());
		sb.appendHtmlConstant("</td></tr><tr><td>");
		sb.appendEscaped(value.getAddress());
		sb.appendHtmlConstant("</td></tr></table>");
	}
}

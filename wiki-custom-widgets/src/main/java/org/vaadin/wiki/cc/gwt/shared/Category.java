package org.vaadin.wiki.cc.gwt.shared;

import java.io.Serializable;

/**
 * A contact category.
 */
public class Category implements Serializable {

	private final String displayName;

	public Category(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
}

package org.vaadin.wiki.cc.gwt.shared;

import java.io.Serializable;

/**
 * A contact category.
 */
public class Category implements Serializable {

	private String displayName;

	public Category(String displayName) {
		this.displayName = displayName;
	}
	
	public Category() {
	}

	public String getDisplayName() {
		return displayName;
	}
	
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
}

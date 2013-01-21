package org.vaadin.wiki.cc.gwt.client;

import org.vaadin.wiki.cc.gwt.shared.ContactInfo;

import com.google.gwt.view.client.ProvidesKey;

public class ContactInfoKeyProvider implements ProvidesKey<ContactInfo> {

	public static final ContactInfoKeyProvider KEY_PROVIDER = new ContactInfoKeyProvider();
	
	private ContactInfoKeyProvider() {
	}
	
	@Override
	public Object getKey(ContactInfo item) {
		return item == null ? null : item.getId();
	}

}

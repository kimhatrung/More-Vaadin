package org.vaadin.wiki.cc.gwt.client;

import org.vaadin.wiki.cc.gwt.GwtCellListShowcase;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;

@Connect(GwtCellListShowcase.class)
public class ContactCellListConnector extends AbstractComponentConnector {
	
	@Override
	protected Widget createWidget() {
		return GWT.create(GwtCellListShowcaseWidget.class);
	}

	@Override
	public GwtCellListShowcaseWidget getWidget() {
		return (GwtCellListShowcaseWidget) super.getWidget();
	}	

}

package org.vaadin.wiki.cc.dynupdate.client;

import org.vaadin.wiki.cc.dynupdate.Addition;
import org.vaadin.wiki.cc.dynupdate.shared.AddResultState;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;

@Connect(Addition.class)
public class AdditionConnector extends AbstractComponentConnector {

	@Override
	protected Widget createWidget() {
		return GWT.create(AdditionWidget.class);
	}

	@Override
	public AdditionWidget getWidget() {
		return (AdditionWidget) super.getWidget();
	}
	
	@Override
	public AddResultState getState() {
		return (AddResultState) super.getState();
	}
}

package org.vaadin.wiki.cc.simple.ui.client;

import org.vaadin.wiki.cc.simple.shared.SimpleComponentState;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;

@Connect(org.vaadin.wiki.cc.simple.SimpleComponent.class)
public class SimpleComponentConnector extends AbstractComponentConnector {

	@Override
	public SimpleComponentState getState() {
		return (SimpleComponentState) super.getState();
	}

	@Override
	public void onStateChanged(StateChangeEvent stateChangeEvent) {
		super.onStateChanged(stateChangeEvent);

		final String text = getState().text;
		getWidget().setText(text);
	}

	@Override
	protected Widget createWidget() {
		return GWT.create(SimpleComponentWidget.class);
	}

	@Override
	public SimpleComponentWidget getWidget() {
		return (SimpleComponentWidget) super.getWidget();
	}
}

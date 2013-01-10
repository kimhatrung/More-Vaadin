package org.vaadin.wiki.cc.simple.client.ui;


import org.vaadin.wiki.cc.simple.shared.SimpleComponentToClientRpc;
import org.vaadin.wiki.cc.simple.shared.SimpleComponentToServerRpc;
import org.vaadin.wiki.cc.simple.shared.SimpleComponentState;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.MouseEventDetailsBuilder;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.MouseEventDetails;
import com.vaadin.shared.ui.Connect;

@Connect(org.vaadin.wiki.cc.simple.SimpleComponent.class)
public class SimpleComponentConnector extends AbstractComponentConnector {
	
	private SimpleComponentToServerRpc rpc = RpcProxy.create(SimpleComponentToServerRpc.class, this);
	
	public SimpleComponentConnector() {
		registerRpc(SimpleComponentToClientRpc.class, new SimpleComponentToClientRpc() {
			
			@Override
			public void alert(String message) {
				Window.alert(message);
			}
		});
		getWidget().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				final MouseEventDetails mouseDetails = MouseEventDetailsBuilder.buildMouseEventDetails(
						event.getNativeEvent(), getWidget().getElement());

				rpc.clicked(mouseDetails);
			}
		});
	}

	@Override
	public SimpleComponentState getState() {
		return (SimpleComponentState) super.getState();
	}

	// Either this or @DelegateToWidget
	/*
	@Override
	public void onStateChanged(StateChangeEvent stateChangeEvent) {
		super.onStateChanged(stateChangeEvent);

		final String text = getState().text;
		getWidget().setText(text);
	}
	*/

	@Override
	protected Widget createWidget() {
		return GWT.create(SimpleComponentWidget.class);
	}

	@Override
	public SimpleComponentWidget getWidget() {
		return (SimpleComponentWidget) super.getWidget();
	}
}

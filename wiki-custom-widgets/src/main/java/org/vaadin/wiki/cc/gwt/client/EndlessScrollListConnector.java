package org.vaadin.wiki.cc.gwt.client;

import org.vaadin.wiki.cc.gwt.EndlessScrollList;
import org.vaadin.wiki.cc.gwt.shared.ScrollListState;
import org.vaadin.wiki.cc.gwt.shared.ScrollListToServerRpc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ConnectorHierarchyChangeEvent;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.ui.AbstractHasComponentsConnector;
import com.vaadin.shared.ui.Connect;

@Connect(EndlessScrollList.class)
public class EndlessScrollListConnector extends AbstractHasComponentsConnector {
	
	private final ScrollListToServerRpc rpc = RpcProxy.create(ScrollListToServerRpc.class, this);

	public EndlessScrollListConnector() {
	}

    @Override
    protected void init() {
        super.init();
        getWidget().init(getConnection(), rpc, getState());
    }

	@Override
	protected Widget createWidget() {
		return GWT.create(EndlessScrollListWidget.class);
	}

	@Override
	public EndlessScrollListWidget getWidget() {
		return (EndlessScrollListWidget) super.getWidget();
	}
	
	@Override
	public ScrollListState getState() {
		return (ScrollListState) super.getState();
	}

	@Override
	public void updateCaption(ComponentConnector connector) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onConnectorHierarchyChange(ConnectorHierarchyChangeEvent connectorHierarchyChangeEvent) {
		// TODO Auto-generated method stub
		
	}

}

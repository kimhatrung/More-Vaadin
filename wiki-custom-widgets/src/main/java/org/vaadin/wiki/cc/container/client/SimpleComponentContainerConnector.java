package org.vaadin.wiki.cc.container.client;

import java.util.List;

import org.vaadin.wiki.cc.container.SimpleComponentContainer;

import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ConnectorHierarchyChangeEvent;
import com.vaadin.client.ui.AbstractComponentContainerConnector;
import com.vaadin.shared.ui.Connect;

@Connect(SimpleComponentContainer.class)
public class SimpleComponentContainerConnector extends AbstractComponentContainerConnector {

	@Override
    public void onConnectorHierarchyChange(ConnectorHierarchyChangeEvent event) {
		List<ComponentConnector> children = getChildComponents();
		VWidgetContainer widget = getWidget();
		widget.clear();
		for (ComponentConnector connector : children) {
			widget.add(connector.getWidget());
		}
	}

	@Override
	public VWidgetContainer getWidget() {
		return (VWidgetContainer) super.getWidget();
	}

	public void updateCaption(ComponentConnector connector) {
	}
	
}

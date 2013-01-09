package org.vaadin.wiki.cc.simple.ui.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;

@Connect(org.vaadin.wiki.cc.simple.SimpleComponent.class)
public class SimpleComponentConnector extends AbstractComponentConnector {
	
    @Override
    protected Widget createWidget() {
        return GWT.create(SimpleComponentWidget.class);
    }
    
    @Override
    public SimpleComponentWidget getWidget() {
        return (SimpleComponentWidget) super.getWidget();
    }    
}

package org.vaadin.wiki.cc.simple.client.ui;

import com.google.gwt.user.client.ui.Label;

public class SimpleComponentWidget extends Label {

	/**
	 * No reflection within GWT client...
	 */
    public static final String CLASSNAME = "simplecomponent";

    public SimpleComponentWidget() {
        setText("This is " + CLASSNAME);
        setStyleName(CLASSNAME);
    }
    
}

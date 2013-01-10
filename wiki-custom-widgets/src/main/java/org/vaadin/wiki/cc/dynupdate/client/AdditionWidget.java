package org.vaadin.wiki.cc.dynupdate.client;

import com.google.gwt.user.client.ui.Label;

public class AdditionWidget extends Label {

	/**
	 * No reflection within GWT client...
	 */
    public static final String CLASSNAME = "addition";

    public AdditionWidget() {
        setText("This is " + CLASSNAME);
        setStyleName(CLASSNAME);
    }

    public void setSum(int sum) {
    	setText(Integer.toString(sum));
    }
    
}

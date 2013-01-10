package org.vaadin.wiki.cc.scss.client;

import org.vaadin.wiki.cc.scss.MyPicker3;
import org.vaadin.wiki.cc.scss.shared.MyPickerState;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.client.ui.SimpleManagedLayout;
import com.vaadin.shared.ui.Connect;

@Connect(MyPicker3.class)
public class MyPicker3Connector extends AbstractComponentConnector implements SimpleManagedLayout {

	@Override
	protected Widget createWidget() {
		return GWT.create(MyPickerWidget.class);
	}

	@Override
	public MyPickerWidget getWidget() {
		return (MyPickerWidget) super.getWidget();
	}

	@Override
	public MyPickerState getState() {
		return (MyPickerState) super.getState();
	}

	// added for Picker3

	@Override
	public void layout() {
		Element button = getWidget().getWidget(1).getElement();
		int buttonWidth = getLayoutManager().getOuterWidth(button);
		buttonWidth -= getLayoutManager().getMarginRight(button);
		getWidget().adjustButtonSpace(buttonWidth);
	}

    @Override
    protected void init() {
        Element button = getWidget().getWidget(1).getElement();
        getLayoutManager().registerDependency(this, button);
    }

    @Override
    public void onUnregister() {
        Element button = getWidget().getWidget(1).getElement();
        getLayoutManager().unregisterDependency(this, button);
    }
    
}

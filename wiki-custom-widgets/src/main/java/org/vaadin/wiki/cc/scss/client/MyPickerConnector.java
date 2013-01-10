package org.vaadin.wiki.cc.scss.client;

import org.vaadin.wiki.cc.scss.MyPicker;
import org.vaadin.wiki.cc.scss.shared.MyPickerState;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;

@Connect(MyPicker.class)
public class MyPickerConnector extends AbstractComponentConnector {

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
}

package org.vaadin.wiki.cc.scss.client;

import org.vaadin.wiki.cc.scss.MyPicker2;
import org.vaadin.wiki.cc.scss.shared.MyPickerState;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.client.ui.layout.ElementResizeEvent;
import com.vaadin.client.ui.layout.ElementResizeListener;
import com.vaadin.shared.ui.Connect;

@Connect(MyPicker2.class)
public class MyPicker2Connector extends AbstractComponentConnector {

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

	// added for Picker2

	private final ElementResizeListener listener = new ElementResizeListener() {
		
		@Override
		public void onElementResize(ElementResizeEvent e) {
			int buttonWidth = getLayoutManager().getOuterWidth(e.getElement());
			buttonWidth -= getLayoutManager().getMarginRight(e.getElement());
			getWidget().adjustButtonSpace(buttonWidth);
		}
	};

	@Override
	protected void init() {
		super.init();
		Element button = getWidget().getWidget(1).getElement();
		getLayoutManager().addElementResizeListener(button, listener);
	}

	@Override
	public void onUnregister() {
		Element button = getWidget().getWidget(1).getElement();
		getLayoutManager().removeElementResizeListener(button, listener);
	}
	
}
